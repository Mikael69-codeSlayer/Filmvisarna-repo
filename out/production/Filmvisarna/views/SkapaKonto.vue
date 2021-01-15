<template>
  
 <h1>Skapa konto</h1>

</template>

<script>

export default {
  computed: {
    id() {
      // get id from url parameter
      return this.$route.params.id;
    },
  },
};
</script>

<style scoped>
h1{
  color:white;
}
</style> 