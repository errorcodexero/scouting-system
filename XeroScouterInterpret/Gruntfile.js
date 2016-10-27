module.exports = function(grunt) {
    grunt.initConfig({
        less: {
	        options: {
	            paths: ['assets/less']
	        },
    		files: [{
    			'interpret/public/css': 'assets/less/**/*.less'
    		}]
        },
        typescript: {
            src: ['assets/typescript/**/*.ts'],
            dest: 'interpret/public/js/main.js'
        },
        clean: ['interpret/public/css', 'interpret/public/js/']

    });

    
    grunt.loadNpmTasks('grunt-contrib-less');
    grunt.loadNpmTasks('grunt-contrib-clean');

    grunt.loadNpmTasks('grunt-typescript');


    grunt.registerTask('default', ['less', 'typescript']);
    
    grunt.registerTask('less', ['less']);
    grunt.registerTask('typescript', ['typescript']);
    grunt.registerTask('clean', ['clean']);
}