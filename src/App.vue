<!-- HTML -->
<template>
  <!-- Navigationbar with router-link and data-bind-->
  <div id = "nav">
    <div class="filmV">
      <router-link :to ="{ name: 'Filmvisarna'}">Filmvisarna</router-link>
    </div>
    <div class="filmer">
      <router-link :to ="{ name: 'Filmer'}">Filmer</router-link>
    </div>
    <div class="bil">
      <router-link :to ="{ name: 'Biljetter'}">Biljetter</router-link>
    </div>
    <div class="log">
      <router-link :to ="{ name: 'Login'}">Login</router-link>
    </div>
    
  </div>
  <!--We added router-view to App.vue template, it must be included to render components.-->
  <router-view />
</template>

<!-- JavaScript (Vue) -->
<script>
// Imported 3  Vue.js files
import Filmvisarna from './views/Filmvisarna.vue'
import Filmer from './views/Filmer.vue'
import Login from './views/Login.vue'
import Biljetter from './views/Biljetter.vue'

// This syntax is declaring a component
// which can be registered and reused later
export default {
  name: "App",
  components: {
    Filmvisarna,
    Filmer,
    Login,
    Biljetter
  },
};
</script>

<style>
#nav {
  background: rgb(238, 5, 52);
  padding: 30px;
  margin: -20px;
}
body {
  background-color: black;
}
.filmV {
  float: left;
  padding-right: 130px;
}
.filmer{
  float: left;
  padding-right: 130px;
}
.bil{
  float: left;
}
.log{
  float: right;
}

</style>