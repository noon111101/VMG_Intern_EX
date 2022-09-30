module.exports = {
  devServer: {
    port: 3000
  }
}
const {defineConfig} = require('@vue/cli-service')
module.exports=defineConfig({
  transpileDependencies:true,
  lintOnSave: false 
})