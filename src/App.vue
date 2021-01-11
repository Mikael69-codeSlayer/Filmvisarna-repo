<!-- HTML -->
<template>
  <!-- Navigationbar with router-link and data-bind-->
  <div id = "nav">
    <router-link :to ="{ name: 'Filmvisarna'}">Filmvisarna</router-link>
    |
    <router-link :to ="{ name: 'Movies'}">Movies</router-link>
    |
    <router-link :to ="{ name: 'Login'}">Login</router-link>
  </div>
</template>

<!-- JavaScript (Vue) -->
<script>
// Imported 3  Vue.js files
import Filmvisarna from './views/Filmvisarna.vue'
import Movies from './views/Movies.vue'
import Login from './views/Login.vue'


// This syntax is declaring a component
// which can be registered and reused later
export default {
  name: "App",
  components: {
    Filmvisarna,
    Movies,
    Login
  },
};
</script>

<style>
body {
  background-color: black;
}

#nav {
  background: crimson;
}
</style>