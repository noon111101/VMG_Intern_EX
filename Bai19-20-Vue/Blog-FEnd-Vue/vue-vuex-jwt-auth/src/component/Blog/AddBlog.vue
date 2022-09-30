<template>
<el-form :model="blogFrom" id="blogFrom" :rules="rules" ref="blogFrom" label-width="120px" class="demo-ruleForm">
  <el-form-item label="Title" prop="title">
    <el-input name="title" v-model.trim="blogFrom.title"></el-input>
  </el-form-item>
  <el-form-item label="Category" prop="category">
    <el-select v-model="blogFrom.category" name="categoryCode" placeholder="Chose category">
      <el-option v-for="cate in categories" :key="cate.id" :value="cate.code"  >{{cate.name}}</el-option>
    </el-select>    
  </el-form-item>
  <el-form-item label="Content" prop="content">
    <el-input type="textarea" v-model="blogFrom.content" name="content"></el-input>
  </el-form-item>
  <el-form-item label="Blog covers" prop="cover">
      <b-form-file
          v-model="blogFrom.cover"
          name="cover" multiple accept="image/*"
          placeholder="Choose your images..."
          >
        <template #file-name="{ names }">
          <b-badge variant="dark">{{ names[0] }}</b-badge>
          <b-badge v-if="names.length > 1" variant="dark" class="ml-1">
            + {{ names.length - 1 }} More images
          </b-badge>
        </template>
      </b-form-file>
    </el-form-item>
  
  <el-form-item>
      <el-button type="primary" @click="submitForm('blogFrom')">Create</el-button>
      <el-button @click="resetForm('blogFrom')">Reset</el-button>
    </el-form-item>
</el-form>

</template>

<script>
import CategoryDataService from '../../services/category.service';
import BlogDataService from '../../services/blog.service'
export default {
    name: 'AddBlog',

    data() {
      return {
        blogFrom: {
        title: '',
        category: '',
        content: '',
        cover: []
        },
        categories: [],
        rules: {
        title: [
          {required: true, message: 'Please input title blog', trigger: 'blur'},
          {min: 3, max: 20, message: 'Length should be 3 to 20', trigger: 'blur'}
        ],
        categoryCode: [
          {required: true, message: 'Please select Category ', trigger: 'change'}
        ],
        content: [
          {required: true, message: 'Please input content bolg', trigger: 'blur'}
        ],
        cover: [
          {required: true, message: 'Please input cover bolg', trigger: 'change'}
        ]
      }
      };
    },
    methods: {
        submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        console.log(valid)
        if (valid) {
          let form = document.querySelector('#blogFrom');
          console.log(form);
          BlogDataService.create(form);
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    },
    created() {
        CategoryDataService.getAll()
        .then(response =>{
            this.categories=response.data;
            console.log(this.categories)
        })
        .catch(error=>{
            console.log(error)
        })
    }
}
  

    
</script>

<style scoped>

</style>