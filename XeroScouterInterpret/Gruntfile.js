module.exports = function(grunt) {
    require("matchdep").filterAll("grunt-*").forEach(grunt.loadNpmTasks);
    var webpack = require("webpack");
    var webpackConfig = require("./webpack.config.js");

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
                "no-write": false
            },
            staging: {
                src: [
                     "staging/js/*.js",
                     "staging/js/*.js.map",
                     "staging/css/*.css"
                ]
            },
            build: {
                src: [
                     "assets/css/*.css",
                     "assets/js/*.js",
                     "assets/js/*.js.map",
                     "assets/bundles/*.js",
                     "assets/bundles/*.js.map"
                 ]
            },
            all: {
                src: [
                    "staging/css/*.css",
                    "assets/css/*.css",
                    "staging/js/*.js",
                    "assets/js/*.js",
                    "staging/js/*.js.map",
                    "assets/js/*.js.map",
                    "assets/bundles/*.js",
                    "assets/bundles/*.js.map"
                ]
            }
        },
        pug: {
            compile: {
                files: {
                    "templates/index.html": ["src/pug/index.pug"]//,
                    //"templates/explore/index.html": ["src/pug/explore_index.pug"]
                }
            }
        },
        mkdir: {
            all: {
                options: {
                    create: [
                        'assets/js',
                        'assets/css',
                        'assets/bundles',
                        'templates/explore',
                        'templates/teams',
                        'staging/css',
                        'staging/js'
                    ]
                }
            }
        }
    });

    grunt.registerTask("default", ["mkdir:all", "webpack:build", "pug", "clean-staging"]);

    grunt.registerTask("templates", ["pug"]);

    grunt.registerTask("clean-staging", ["clean:staging"]);

    grunt.registerTask("clean-build", ["clean:build"]);

    grunt.registerTask("clean-all", ["clean:all"]);

};
