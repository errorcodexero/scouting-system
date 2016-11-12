// Includes section
import React    from "react"
import ReactDOM from "react-dom"
import Chart    from "chart.js"

let ctx = document.getElementById("myChart");

Chart.defaults.global.maintainAspectRatio = false;

let options = {
    responsive: true,
    scale: {
        //width: 50,
        //height: 50,
        reverse: false,
        ticks: {
            beginAtZero: true
        }
    }
};

let data = {
    labels: ["OPR", "DPR", "FPR"],
    datasets: [
        {
            label: "Team A",
            backgroundColor: "rgba(179,181,198,0.2)",
            borderColor: "rgba(179,181,198,1)",
            pointBackgroundColor: "rgba(179,181,198,1)",
            pointBorderColor: "#fff",
            pointHoverBackgroundColor: "#fff",
            pointHoverBorderColor: "rgba(179,181,198,1)",
            data: [30.42, 5.00, 1.03]
        },
        {
            label: "Team B",
            backgroundColor: "rgba(255,99,132,0.2)",
            borderColor: "rgba(255,99,132,1)",
            pointBackgroundColor: "rgba(255,99,132,1)",
            pointBorderColor: "#fff",
            pointHoverBackgroundColor: "#fff",
            pointHoverBorderColor: "rgba(255,99,132,1)",
            data: [12.03, 20.00, 6.00]
        }
    ]
};

let myRadarChart = new Chart(ctx, {
    type: 'radar',
    data: data,
    options: options
});
