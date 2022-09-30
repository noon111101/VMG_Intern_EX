<template>
    <div>
        <h4>Blogs List</h4>
        <ul class="list-group" v-for="(blog, index) in blogs"
            :key="index">
          <li class="list-group-item">
            {{ blog.title }}
          </li>
          <h1>{{blog.imageBlogs[0].imageName}}</h1>
          <img v-bind:src="blog.imageBlogs[0].imageName" width="100px" height="120px" alt="">
        </ul>
        
    </div>
  </template>
  
  <script>
  import BlogService from "@/service/BlogService";
  
  export default {
    name: "BlogList",
    data() {
      return {
        blogs: [],
        title: ""
      };
    },
    methods: {
      retrieveBlogs() {
        BlogService.getAll()
          .then(response => {
            this.blogs = response.data;
            console.log(response.data);

          })
          .catch(e => {
            console.log(e);
          });
      }
          }
    ,
    mounted() {
      this.retrieveBlogs();
    }
  };
  </script>
  
  <style>
  .list {
    text-align: left;
    max-width: 750px;
    margin: auto;
  }
  </style>