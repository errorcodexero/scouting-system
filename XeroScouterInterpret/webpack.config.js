var path = require('path')
var webpack = require('webpack')
var BundleTracker = require('webpack-bundle-tracker')


module.exports = {
    context: __dirname,

    entry: {
        main: './src/tsx/index.tsx'//,
        //explore: './src/ts/explore/explore.tsx'
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
                    test: /\.jsx$/,

                    loader: 'babel-loader'
                },
                {
                    test: /\.js$/,

                    loader: 'babel',

                    query: {
                        presets: ['es2015', 'stage-0']
                    }
                },
                {test: /\.tsx?$/, exclude: /node_modules/, loader: 'babel-loader!ts-loader'},
                {test: /\.json$/, exclude: /node_modules/, loader: 'json-loader'}
                //{test: /(explore)?(\.tsx?$)/, exclude: /node_modules/, loader: 'ts-loader?tsconfig=src/ts/explore/tsconfig.json'}

            ]
        },


    resolve: {
        modulesDirectories: ['node_modules'],

        extensions: ['', '.js', '.jsx', '.ts', '.tsx', '.webpack/js', '.web.js']
    },
    externals: {
        "react": "React",
        "react-dom": "ReactDOM"
    }
}
