// Includes section
import React    from "react"
import ReactDOM from "react-dom"
import path     from "path"

$(document).ready(function(){
    $('#homeTab').removeClass('active');
    $('#teamsTab').addClass('active');
});

class TeamImage extends React.Component {

    getImagePath() {
    }

    render() {
        return (
        <div className="image-holder">
            <img src="https://i.imgur.com/yIqEvQ8h.jpg" width="240" height="240"/>
        </div>
        );
    }
}

class PresentTeam extends React.Component {
    constructor(props) {
        super(props);
        //this.state.teamInfoff
    }
    render () {
        return (
                <div className="container-fluid">
                        <div className="col-xs-1 col-sm-1 col-md-1 col-lg-1">
                            {/* Spacer */}
                        </div>
                        <div className="col-xs-10 col-sm-10 col-md-10 col-lg-10">
                            <div className="jumbotron">
                                <div className="row">
                                    <div className="col-xs-6 col-sm-5 col-md-4 col-lg-4">
                                        <TeamImage/>
                                    </div>
                                    <div className="col-xs-1 col-sm-1 col-md-1 col-lg-1">

                                    </div>
                                    <div className="col-xs-3 col-sm-4 col-md-5 col-lg-5">
                                        <p>
                                            Test
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    <div className="col-xs-1 col-sm-1 col-md-1 col-lg-1">
                        {/* Spacer */}
                    </div>
                </div>
        );
    }
}

ReactDOM.render(<PresentTeam />, document.getElementById('team-container'));
