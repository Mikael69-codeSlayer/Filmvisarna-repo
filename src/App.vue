<!-- HTML -->
<template>
<!-- Title -->
  <Navbar filmvisarna="Filmvisarna" />
</template>

<!-- JavaScript (Vue) -->
<script>
// Imported 2  Vue.js files
import Filmvisarna from "./components/Filmvisarna.vue";
import Navbar from "./components/Navbar.vue";

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

