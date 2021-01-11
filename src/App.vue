<!-- HTML -->
<template>
  <!-- Title -->
  <Navbar filmvisarna="Filmvisarna" />
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