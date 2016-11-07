import * as React from "react";
import * as ReactDOM from "react-dom";

interface HelloProps { compiler: string; framework: string; };
class Hello extends React.Component<HelloProps, {}> {
    render() {
        return <h1>Hello</h1>;
    }
}

ReactDOM.render(
    <Hello compiler="test" framework="test" />,
    document.getElementById("container")
);
