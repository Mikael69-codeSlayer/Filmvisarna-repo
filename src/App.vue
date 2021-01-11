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
// Imported 2  Vue.js files
import Filmvisarna from "./views/Filmvisarna.vue";
import Navbar from "./views/Navbar.vue";


// This syntax is declaring a component
// which can be registered and reused later
export default {
  name: "App",
  components: {
    Filmvisarna,
    Navbar,
  },
};
</script>

<style>
body {
  background-color: black;
}
</style>