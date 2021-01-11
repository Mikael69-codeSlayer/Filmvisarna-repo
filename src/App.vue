<!-- HTML -->
<template>
  <!-- Navigationbar with router-link and data-bind-->
  <div id="nav">
    <div class="filmV">
      <router-link :to="{ name: 'Filmvisarna' }">Filmvisarna</router-link>
    </div>
    <div class="filmer">
      <router-link :to="{ name: 'Filmer' }">Filmer</router-link>
    </div>
    <div class="bil">
      <router-link :to="{ name: 'Biljetter' }">Biljetter</router-link>
    </div>
    <div class="log">
      <router-link :to="{ name: 'Login' }">Login</router-link>
    </div>
  </div>
  <!--We added router-view to App.vue template, it must be included to render components.-->
  <router-view />
</template>

<!-- JavaScript (Vue) -->
<script>
// Imported 3  Vue.js files
import Filmvisarna from "./views/Filmvisarna.vue";
import Filmer from "./views/Filmer.vue";
import Login from "./views/Login.vue";
import Biljetter from "./views/Biljetter.vue";

// This syntax is declaring a component
// which can be registered and reused later
export default {
  name: "App",
  components: {
    Filmvisarna,
    Filmer,
    Login,
    Biljetter,
  },
};
</script>

<style>
/******************** google fonts **************/ 
@import url('https://fonts.googleapis.com/css2?family=Cookie&display=swap');

@import url('https://fonts.googleapis.com/css2?family=Cookie&family=Lora&display=swap');
/***********************************************/ 

#nav {
  background: rgb(209, 6, 46);
  padding: 25px;
  margin: -20px;
}
body {
  background-color: black;
}

a {
   color: white;
}
a:link {
  text-decoration: none;
}

div.filmV {
  font-family: 'Cookie', cursive;
  float: center;  
  font-size: 50px;
  margin-top: -5px;
}
div.filmer {
  font-family: 'Lora', serif;
  float: left;
  padding-left: 90px;
  margin-top: -20px;
  font-size: 20px;
}
div.bil {
  font-family: 'Lora', serif;
  float: left;
  padding-left: 120px;
  margin-top: -20px;
  font-size: 20px;
}
div.log {
  font-family: 'Lora', serif;
  float: right;
  margin-top: -20px;
  font-size: 20px;
  padding-right: 70px;
}
</style>