var path = require('path')
var webpack = require('webpack')
var BundleTracker = require('webpack-bundle-tracker')


module.exports = {
    context: __dirname,

    entry: {
        home: './src/jsx/home/home.jsx',
        explore: './src/jsx/explore/explore.jsx',
        teams: './src/jsx/teams/teams.jsx',
        strategy: './src/jsx/strategy/strategy.jsx'
        
    },

    output: {
        path: path.resolve('./assets/bundles/'),

        filename: '[name].js',
        },
    devtool: "source-map",

    plugins: [

        new BundleTracker({filename: './webpack-stats.json'}),

        new webpack.ProvidePlugin({
            $: 'jquery',
            jQuery: 'jquery',
            'window.jQuery': 'jquery'
        }),
        //new webpack.optimize.CommonChunkPlugin('main', './src/')

    ],

    module: {
            loaders: [
                {
                    test: /\.js$/,

                    loader: 'babel-loader',
                    exclude: /node_modules/
                },
                {
                    test: /\.jsx$/,

                    loader: 'babel',
                    exclude: /node_modules/,

                    query: {
                        presets: ['stage-0', 'react']
                    }
                },
                {
                    test: /\.json$/,
                    exclude: /node_modules/,
                    loader: 'json-loader'
                }

            ]
        },


    resolve: {
        modulesDirectories: ['node_modules'],

        extensions: ['', '.js', '.jsx', '.webpack.js', '.web.js']
    },
    externals: {
        "react": "React",
        "react-dom": "ReactDOM",
        "amcharts": "var AmCharts"
    }
}
