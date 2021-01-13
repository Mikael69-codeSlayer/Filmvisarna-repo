<!-- HTML -->
<template>
  <!-- Navigationbar with router-link and data-bind-->
  <div class="main-container">
    <div id="nav">
      <div class="filmV">
        <router-link :to="{ name: 'Filmvisarna' }">Filmvisarna</router-link>
      </div>
      <div class="filmer">
        <router-link :to="{ name: 'Filmer' }">Filmer & Trailer</router-link>
      </div>
      <div class="bil">
        <router-link :to="{ name: 'Biljetter' }">Biljetter</router-link>
      </div>
      <div class="log">
        <router-link :to="{ name: 'Login' }">Login</router-link>
      </div>
    </div>
    <!--We added router-view to App.vue template, it must be included to render components.-->
  </div>
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
  created(){
    this.$store.dispatch('fetchFilmer')
  }
}
</script>

<style>
/*
IMPORTANT! Don't forget to use 'scope'
otherwise all changes will effect other files
*/

/******************** google fonts **************/
/*Cookie*/
@import url("https://fonts.googleapis.com/css2?family=Cookie&display=swap");

/*Roboto Slab*/
@import url("https://fonts.googleapis.com/css2?family=Roboto+Slab&display=swap");
/***********************************************/

/*Navigationbar*/
div.main-container {
  width: 100%;
}
#nav {
  background-color: rgb(209, 6, 46);
  padding: 5px;

  /*fix margin*/
}
body {
  background-color: black;
  margin: 0 !important;
  padding: 0 !important;
}

/*a -> filmer, biljetter, filmvisarna, login*/
a {
  color: white;
  text-decoration: none;
  position: relative;
}
/*the :hover selector is used to select elements when you mouse over them*/
a:hover {
  color: rgba(240, 248, 255, 0.842);
}
/*the ::after selector inserts something after the content of each selected element(s)*/
a:after {
  bottom: -11px;
  content: "";
  display: block;
  height: 4px;
  left: 50%;
  position: absolute;
  background: rgba(255, 255, 255, 0.548);
  transition: width 0.3s ease 0s, left 0.3s ease 0s;
  width: 0;
}
a:hover:after {
  width: 90%;
  left: 6%;
}

/*Filmvisarna*/
div.filmV {
  font-family: "Cookie", cursive;
  float: center;
  font-size: 50px;
  margin-top: 5px;
}
/*First letter*/
div.filmV::first-letter {
  font-size: 70px;
  color: aliceblue;
}
/*Filmer*/
div.filmer {
  font-family: "Roboto Slab", serif;
  float: left;
  padding-left: 300px;
  margin-top: -45px;
  font-size: 20px;
}
/*Biljetter*/
div.bil {
  font-family: "Roboto Slab", serif;
  float: left;
  padding-left: 90px;
  margin-top: -45px;
  font-size: 20px;
}
/*Login*/
div.log {
  font-family: "Roboto Slab", serif;
  float: right;
  margin-top: -45px;
  font-size: 20px;
  padding-right: 70px;
}
</style>