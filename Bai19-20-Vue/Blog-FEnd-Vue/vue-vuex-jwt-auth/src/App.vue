<template>
  <div id="app">
    <div class="container-fluid ">
      <div class="row">
        <nav-bar class="col-4" />
        <router-view class="col-8 text-center" />
      </div>
    </div>
  </div>
</template>

<script>
import NavBar from './component/NavBar.vue';
export default {
  components: { NavBar },
  // computed: {
  //   currentUser() {
  //     return this.$store.state.auth.user;
  //   },
  //   showAdminBoard() {
  //     if (this.currentUser && this.currentUser.roles) {
  //       return this.currentUser.roles.includes('ROLE_ADMIN');
  //     }

  //     return false;
  //   },
  //   showModeratorBoard() {
  //     if (this.currentUser && this.currentUser.roles) {
  //       return this.currentUser.roles.includes('ROLE_MODERATOR');
  //     }

  //     return false;
  //   }
  // },
  // methods: {
  //   logOut() {
  //     this.$store.dispatch('auth/logout');
  //     this.$router.push('/login');
  //   }
  // }
};
</script>
<style scoped>
body{
  margin: 0;
  padding: 0;
}
</style>
