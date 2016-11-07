module.exports = function(grunt) {
    require("matchdep").filterAll("grunt-*").forEach(grunt.loadNpmTasks);
    var webpack = require('webpack');
    var webpackConfig = require('./webpack.config.js');

    grunt.initConfig({
        // Needs to be done first
        webpack: {
            options: webpackConfig,
            build: {
                //plugins:
            }
        },
        clean: {
            options: {
                'no-write': false
            },
            staging: {
                css: [
                     './staging/css/*.css'
                 ],
                js: [
                    './staging/js/*.js',
                    './staging/js/*.js.map'
                ],
                all: [
                     './staging/js/*.js',
                     './staging/js/*.js.map',
                     './staging/css/*.css'
                ]
            },
            build: {
                css: [
                    './assets/css/*.css'
                ],
                js: [
                    './assets/js/*.js',
                    './assets/js/*.js.map'
                ],
                all: [
                     './assets/css/*.css',
                     './assets/js/*.js',
                     './assets/js/*.js.map'
                ]
            },
            all: {
                css: [
                    './staging/css/*.css',
                    './assets/css/*.css'
                ],
                js: [
                     './staging/js/*.js',
                     './assets/js/*.js',
                     './staging/js/*.js.map',
                     './assets/js/*.js.map'
                 ],
                all: [
                    './staging/css/*.css',
                    './assets/css/*.css',
                    './staging/js/*.js',
                    './assets/js/*.js',
                    './staging/js/*.js.map',
                    './assets/js/*.js.map',
                ]
            }
        }
    });

    grunt.registerTask("default", ["webpack:build"]);

    grunt.registerTask("clean-staging", ["clean:staging:all"]);
    grunt.registerTask("clean-staging-css", ["clean:staging:css"]);
    grunt.registerTask("clean-staging-js", ["clean:staging:js"]);

    grunt.registerTask("clean-build", ["clean:build:all"]);
    grunt.registerTask("clean-build-js", ["clean:build:js"]);
    grunt.registerTask("clean-build-css", ["clean:build:css"]);

    grunt.registerTask("clean-all", ["clean:all:all"]);
    grunt.registerTask("clean-all-js", ["clean:all:js"]);
    grunt.registerTask("clean-all-css", ["clean:all:css"]);


}
