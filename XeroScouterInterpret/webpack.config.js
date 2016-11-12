var path = require('path')
var webpack = require('webpack')
var BundleTracker = require('webpack-bundle-tracker')


module.exports = {
    context: __dirname,

    entry: {
        main: './src/jsx/index.jsx',
        explore: './src/jsx/explore/explore.jsx'
    },

    output: {
        path: path.resolve('./staging/bundles/'),

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
                {test: /\.tsx?$/, exclude: /node_modules/, loader: 'babel-loader!ts-loader'},
                {test: /\.json$/, exclude: /node_modules/, loader: 'json-loader'}
                //{test: /(explore)?(\.tsx?$)/, exclude: /node_modules/, loader: 'ts-loader?tsconfig=src/ts/explore/tsconfig.json'}

            ]
        },


    resolve: {
        modulesDirectories: ['node_modules'],

        extensions: ['', '.js', '.jsx', '.webpack/js', '.web.js']
    },
    externals: {
        "react": "React",
        "react-dom": "ReactDOM"
    }
}
