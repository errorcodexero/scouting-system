import * as React from "react";
import * as ReactDOM from "react-dom";

var canvas = <HTMLCanvasElement>document.getElementById("canvas")</HTMLCanvasElement>;
var ctx = canvas.getContext("2d");

interface HelloProps { compiler: string; framework: string; };
class Hello extends React.Component<HelloProps, {}> {
    render() {
        return <h1>Hello from {this.props.compiler} and {this.props.framework}!</h1>;
    }
}

ReactDOM.render(
    <Hello compiler="test" framework="test" />,
    document.getElementById("container")
);
