<template>
  <div id="app">
    <div class="container-fluid ">
      <div class="row">
        <nav-blog class="col-lg-2" />
        <blogs-list class="col-lg-10" />
      </div>
    </div>
  
  
  </div>
</template>

<script>
import BlogsList from './components/BlogsList.vue'
import NavBlog from './components/NavBlog.vue'


export default {
  name: 'App',
  components: {
    NavBlog,
    BlogsList   
}
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
