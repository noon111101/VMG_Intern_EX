const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  runtimeCompiler: true
})
module.exports = {
  devServer: {
    port: 3000
  }
}
