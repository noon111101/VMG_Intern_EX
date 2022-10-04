<template>
    <el-table
    :data="blogList"
    style="width: 100%">
    <el-table-column
      label="Title"
      prop="title">
    </el-table-column>
    <el-table-column
      label="Content"
      prop="content">
    </el-table-column>
    <el-table-column
      label="Cover"
      >
      <template slot-scope="props">
        <img  v-for="(cover, i) in props.row.coverNameList" :key="i"
          v-bind:src="'http://localhost:8080/api/files/images?file=' + cover" 
          width="50px"
        />        
      </template>
    </el-table-column>
    <el-table-column
      label="Category"
      prop="categoryCode">
    </el-table-column>
    <el-input 
        placeholder="Please input" 
        v-model="search"
        size="small"
        @input="handleInputSearch"
    ></el-input>
  </el-table>
  </template>
  
  <script>
    import blogService from '../../services/blog.service';
    export default {
        
      data() {
        return {
        blogList :[],
        page: 1,
        search: '',

        }
      },
      methods: {
      //   handleInputSearch(val, page) {
      //   this.search = val;
      //   Blog.getBlogSearchTitle(val, page)
      //     .then(result => {
      //       console.log('title: ' + this.search);
      //       this.tableData = result.data.blogs;
      //       this.dataPagination = result.data;
      //     })
      //     .catch(error => {
      //       console.log(error);
      //     })
      // },
      },
      mounted() {
        blogService.getAll(0).then(respone =>{
            this.blogList=respone.data.blogDTOList;
            console.log(this.blogList);
        })

        .catch(e => {
          console.log(e);
        });
      },

}
  </script>