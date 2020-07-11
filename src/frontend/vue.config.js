const path = require('path')

module.exports = {
  outputDir: path.resolve(__dirname, "../"+"main/resources/static"),
  devServer: {
    proxy : {
      '/main':{
        target : 'http://localhost:9000',
        ws:true,
        changeOrigin :true
      }
    }
  },

  lintOnSave: false,
  runtimeCompiler: true,
  configureWebpack: {
    //Necessary to run npm link https://webpack.js.org/configuration/resolve/#resolve-symlinks
    resolve: {
       symlinks: false
    }
  },
  transpileDependencies: [
    '@coreui/utils'
  ]
}
