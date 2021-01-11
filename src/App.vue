<!-- HTML -->
<template>
  <!-- Navigationbar with router-link and data-bind-->
  <div id = "nav">
    <router-link :to ="{ name: 'Filmvisarna'}">Filmvisarna</router-link>
    |
    <router-link :to ="{ name: 'Filmer'}">Filmer</router-link>
    |
    <router-link :to ="{ name: 'Biljetter'}">Biljetter</router-link>
    |
    <router-link :to ="{ name: 'Login'}">Login</router-link>
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
  padding: 25px;
  margin: -15px;
}
body {
  background-color: black;
}

#nav {
  background: crimson;
}
</style>