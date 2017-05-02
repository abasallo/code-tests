gulp = require('gulp')
coffee = require('gulp-coffee')
del = require('del')
karma = require('karma').server

paths =
  application: 'app/'
  libraries: 'bower_components/'
  www: 'www/'

  sourcesCoffee: 'src/coffee'
  sourcesJavascript: 'src/js'

  targetRoot: ''
  targetImages: 'images'
  targetStyles: 'css'

files =
  all: '**/*'
  allJavascript: '**/*.js'
  allCoffeescript: '**/*.coffee'
  allHTML: '**/*.html'
  allImages: 'images/**/*'
  allStyles: 'css/**/*'

gulp.task 'clean', (cb) ->
  del ['www', 'app/src/js'], cb

gulp.task 'coffee', ['clean'], ->
  gulp.src(files.allCoffeescript, cwd: paths.application + paths.sourcesCoffee).pipe(coffee()).pipe gulp.dest(paths.application + paths.sourcesJavascript)

gulp.task 'copy', ['clean', 'coffee'], ->
  gulp.src(files.allHTML, cwd: paths.application).pipe gulp.dest(paths.targetRoot, cwd: paths.www)
  gulp.src(files.allImages, cwd: paths.application).pipe gulp.dest(paths.targetImages, cwd: paths.www)
  gulp.src(files.allStyles, cwd: paths.application).pipe gulp.dest(paths.targetStyles, cwd: paths.www)
  gulp.src(paths.sourcesJavascript + files.allJavascript, cwd: paths.application).pipe gulp.dest(paths.www)
  gulp.src(paths.libraries + files.all).pipe gulp.dest(paths.libraries, cwd: paths.www)

gulp.task 'default', [
  'copy'
]

gulp.task 'watch', ['default'],  ->
  gulp.watch '**/*', ['app']
