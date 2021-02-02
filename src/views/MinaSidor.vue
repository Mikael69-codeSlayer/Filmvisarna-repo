<template>
  <h1>Mina Sidor</h1>
  <div>Mina bokningar</div>

  <p>{{tickets}}</p>
</template>

<script>
export default {
  data() {
    return {};
  },

  computed: {
    userName() {
      return this.$store.state.user.email;
    },
    tickets(){
      return this.$store.state.allTickets
    }
  },
  created() {
    this.$store.dispatch("fetchTickets")
  }
};
</script>

<style scoped>
h1 {
  font-family: "Roboto Slab", serif;
  color: white;
  text-align: center;
  margin-top: 40px;
}
div {
  font-family: "Roboto Slab", serif;
  color: white;
  text-align: left;
  margin-left: 40px;
  margin-top: 40px;
}
</style>