var path = require('path')
var webpack = require('webpack')
var BundleTracker = require('webpack-bundle-tracker')


module.exports = {
    context: __dirname,

    entry: './src/tsx/index.tsx',

    output: {
        path: path.resolve('./assets/js/'),

        filename: '[name].js',
        },
    devtool: "source-map",

    plugins: [

        new BundleTracker({filename: './webpack-stats.json'}),

        new webpack.ProvidePlugin({
            $: 'jquery',
            jQuery: 'jquery',
            'window.jQuery': 'jquery'
        })

    ],

    module: {
            loaders: [
                {
                    test: /\.jsx$/,

                    loader: 'babel-loader',
                    query: {
                        presets: ['react']
                    }
                },
                {test: /\.js$/, exclude: /node_modules/, loader: 'babel-loader'},
                {test: /\.tsx?$/, exclude: /node_modules/, loader: 'ts-loader'}
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
