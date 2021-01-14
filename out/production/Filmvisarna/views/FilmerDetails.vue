<template>
  <h1>Filmer</h1>
  <h3>Param: {{ id }}</h3>
  
       

</template>

<script>


export default {
  computed: {
     filmer() {
        return this.$store.state.filmer.filter(filmer => filmer.id == this.id)[0]
    },
    id() {
      // get id from url parameter
      return this.$route.params.id;
    }
  }
};
</script>

<style scoped>
</style> 