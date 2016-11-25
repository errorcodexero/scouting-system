// Includes section
import React            from "react";
import ReactDOM         from "react-dom";

let Highcharts          = require('highcharts')

let chartDiv = document.getElementById('#chartDiv')

let DropdownTest = React.createClass ({
    render: function () {
        let elementsList = [];

        for (var i = 0; i < (team_list.length); i++) {
            elementsList.push(<li id={"team_" + i} key={i}><a href="#">{team_list[i]}</a></li>);
        }

        return(
            <div className="dropdown">
                <div className="btn-group">
                    <a className="btn btn-raised btn-info dropdown-toggle">
                        <span id="current-team-span">
                            {current_team}
                        </span>
                    </a>
                    <a className="btn btn-raised btn-info dropdown-toggle" type="button" data-toggle="dropdown" aria-expanded="false">
                        <span className="caret"></span>
                        <div className="ripple-container"></div>
                    </a>
                    <ul className="dropdown-menu" id="team_dropdown">
                        {elementsList}
                    </ul>
                </div>
            </div>
            );
    }
});

$(document).ready(function(){
    $('#team_dropdown li a').click(function(){
        var dataToPush = {'team_name': $(this).text()};
        $.post(team_url, dataToPush, function(response){

            let i = 0
            jQuery.parseJSON(response).data.forEach(function(element) {

                i++;
            });
            $("#current-team-span").text(jQuery.parseJSON(response).team);

        });
    });
});

//ReactDOM.render(React.createElement(DropdownTest), document.getElementById('testing-div'));

ReactDOM.render(React.createElement('div', { id: 'chartingDiv'}), document.getElementById('chartDiv'), function(){
    Highcharts.chart('chartingDiv', {
        chart: {
            type: 'bar'
        },
        title: {
            text: 'Fruit Consumption'
        },
        xAxis: {
            categories: ['Apples', 'Bananas', 'Oranges']
        },
        yAxis: {
            title: {
                text: 'Fruit eaten'
            }
        },
        series: [{
            name: 'Jane',
            data: [1, 0, 4]
        }, {
            name: 'John',
            data: [5, 7, 3]
        }]
    });
});
