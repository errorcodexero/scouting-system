module.exports = function(grunt) {
    require("matchdep").filterAll("grunt-*").forEach(grunt.loadNpmTasks);
    var webpack = require("webpack");
    var webpackConfig = require("./webpack.config.js");
    var webpackConfigDev = require("./webpack.dev.config.js");

    grunt.initConfig({
        // Needs to be done first
        webpack: {
            dist: webpackConfig,
            dev: webpackConfigDev,
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
                     "staging/css/*.css",
                     "staging/css/*.css.map",
                     "staging/css/*.min.css"
                ]
            },
            build: {
                src: [
                     "assets/css/*.css",
                     "assets/css/*.css.map",
                     "assets/css/*.min.css",
                     "assets/js/*.js",
                     "assets/js/*.js.map",
                     "assets/bundles/*.js",
                     "assets/bundles/*.js.map"
                 ]
            },
            templates: {
                src: [
                    "templates/**/*.html"
                    ]
            },
            all: {
                src: [
                    "staging/css/*.css",
                    "staging/css/*.css.map",
                    "assets/css/*.min.css",
                    "staging/css/*.css",
                    "assets/css/*.min.css",
                    "staging/js/*.js",
                    "assets/js/*.js",
                    "staging/js/*.js.map",
                    "assets/js/*.js.map",
                    "assets/bundles/*.js",
                    "assets/bundles/*.js.map",
                    "templates/**/*.html"
                ]
            }
        },
        sass: {
                options: {
                    sourceMap: true
                },
                dist: {
                    files: {
                        'staging/css/chart.css': 'src/sass/charts.scss',
                        'staging/css/index.css': 'src/sass/index.scss'
                    }

                },
                dev: {
                    files: {
                        'assets/css/chart.css': 'src/sass/charts.scss',
                        'assets/css/index.css': 'src/sass/index.scss'
                }
        }
    },
        pug: {
            dist: {
                files: {
                    "templates/home/index.html": ["src/pug/head_dist.pug", "src/pug/home/index.pug"],
                    "templates/explore/index.html": ["src/pug/head_dist.pug", "src/pug/explore/index.pug"],
                    "templates/teams/index.html": ["src/pug/head_dist.pug", "src/pug/teams/index.pug"]

                }
            },
            dev: {
                files: {
                    "templates/home/index.html": ["src/pug/head.pug", "src/pug/home/index.pug"],
                    "templates/explore/index.html": ["src/pug/head.pug", "src/pug/explore/index.pug"],
                    "templates/teams/index.html": ["src/pug/head.pug", "src/pug/teams/index.pug"]

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
                        'staging/js',
                        'staging/bundles',
                        'templates/'
                    ]
                }
            }
        },
        uglify: {
            dev: {
                files: {
                    'assets/bundles/home.js': ['staging/bundles/home.js'],
                    'assets/bundles/explore.js': ['staging/bundles/explore.js'],
                    'assets/bundles/teams.js': ['staging/bundles/teams.js']


                }
            },
            dist: {
                files: {
                        'assets/bundles/home.js': ['staging/bundles/home.js'],
                        'assets/bundles/explore.js': ['staging/bundles/explore.js'],
                        'assets/bundles/teams.js': ['staging/bundles/teams.js']


                }
            }
        },
        copy: {
            devjs: {},
            devcss: {},
            distjs: {
                expand: true,
                cwd: 'staging/',
                src: ['bundles/*.map'],
                dest: 'assets/bundles/',
                flatten: true,
                filter: 'isFile'
            },
            distcss: {
                expand: true,
                cwd: 'staging/',
                src: ['css/*.map'],
                dest: 'assets/css/',
                flatten: true,
                filter: 'isFile'
            }
        },
        cssmin: {
            dev: {},
            dist: {
                files: [{
                    expand: true,
                    cwd: 'staging/css/',
                    src: ['*.css', '!*.min.css'],
                    dest: 'assets/css/',
                    ext: '.min.css'
                }]
            }
        }
    });

    grunt.registerTask("default", ["mkdir:all", "clean:all", "webpack:dev", "sass:dev", "pug:dev", "clean-staging"]);
    grunt.registerTask("dist", ["mkdir:all", "clean:all", "webpack:dist", "sass:dist", "copy:distjs", "copy:distcss", "uglify:dist", "pug:dist", "cssmin:dist", "clean-staging"])

    //grunt.registerTask("lint", ["jslint", "tslint"])


    grunt.registerTask("templates-dev", ["pug:dev"]);
    grunt.registerTask("templates-dist", ["pug:dist"]);

    grunt.registerTask("clean-staging", ["clean:staging"]);
    grunt.registerTask("clean-build", ["clean:build"]);
    grunt.registerTask("clean-templates", ["clean:templates"]);
    grunt.registerTask("clean-all", ["clean:all"]);

};
