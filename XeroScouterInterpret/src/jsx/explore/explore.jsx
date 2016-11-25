// Includes section
import React            from "react";
import ReactDOM         from "react-dom";
import ReactHighcharts  from "react-highcharts";

let Highcharts          = require('highcharts')


let chartDiv = document.getElementById('#chartDiv')

let graph_range = new Array(40);
let pairs = [[]]

for(let i = 0; i<graph_range.length; i++ ) {
    graph_range[i] = i;
}

for(let i = 0; i< graph_range.length; i++) {
    pairs[i] = [graph_range[i], opr_y[i]]
}


let DropdownTest = React.createClass ({
    render: function () {
        let elementsList = [];

        for (let i = 0; i < (team_list.length); i++) {
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

let chartData = {
    tooltip: {
        enabled: false
    },
    title: {
        text: 'OPR Curve'
    },
    xAxis: {
    },
    plotOptions: {
            spline: {
                marker: {
                    enabled: false
                }
            }
    },
    series: [{
        type: 'spline',
        name: 'OPR',
        data: pairs
    }]
};

$(document).ready(function(){
    $('#team_dropdown li a').click(function(){
        let dataToPush = {'team_name': $(this).text()};
        $.post(team_url, dataToPush, function(response){
            alert(pairs);
            let i = 0
            jQuery.parseJSON(response).data.forEach(function(element) {

                i++;
            });
            $("#current-team-span").text(jQuery.parseJSON(response).team);

        });
    });
    $('#homeTab').removeClass('active');
    $('#exploreTab').addClass('active');
    let numTeams = sorted_opr.length - 1;

    $('#firstTeam').text("First Place: " + opr_team_dict[sorted_opr[numTeams]]);
    $('#secondTeam').text("Second Place: " + opr_team_dict[sorted_opr[numTeams - 1]]);
    $('#thirdTeam').text("Third Place: " + opr_team_dict[sorted_opr[numTeams - 2]]);
    $('#fourthTeam').text("Fourth Place: " + opr_team_dict[sorted_opr[numTeams - 3]]);
    $('#fifthTeam').text("Fifth Place: " + opr_team_dict[sorted_opr[numTeams - 4]]);
});

ReactDOM.render(React.createElement(DropdownTest), document.getElementById('testing-div'));

ReactDOM.render(<ReactHighcharts config = {chartData}></ReactHighcharts>, document.getElementById('chartDiv'), );
