"use strict";
var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
var React = require("react");
var ReactDOM = require("react-dom");
;
var Hello = (function (_super) {
    __extends(Hello, _super);
    function Hello() {
        return _super.apply(this, arguments) || this;
    }
    Hello.prototype.render = function () {
        return React.createElement("h1", null, "Hello");
    };
    return Hello;
}(React.Component));
ReactDOM.render(React.createElement(Hello, { compiler: "test", framework: "test" }), document.getElementById("container"));
//# sourceMappingURL=index.js.map