<template>
  <h1>Mina Sidor</h1>
  <div class="header">Mina bokningar</div>
  <div v-for="info of tickets" :key="info">
    <p>{{ info.film }}</p>
    <pre>
    Datum:  {{ info.date }} 
    Tid:  {{ info.time }}
    Antal bokade platser:  {{ info.seats }} 
    Bokningsnummer:  {{ info.id }}
    Totala kostnaden:  {{ info.price }}kr</pre
    >
  </div>
</template>

<script>
export default {

  computed: {
    userName() {
      return this.$store.state.user.email;
    },
    tickets() {
      return this.$store.state.allTickets;
    },
  },
  created() {
    this.$store.dispatch("fetchTickets");
  },
  
};
</script>

<style scoped>
h1 {
  font-family: "Roboto Slab", serif;
  color: white;
  text-align: center;
  margin-top: 40px;
}
.header{
   font-family: "Roboto Slab", serif;
  color: white;
  text-align: left;
  margin-left: 40px;
  margin-top: 40px;
  font-size: 20px;
}
div {
  font-family: "Roboto Slab", serif;
  color: white;
  text-align: left;
  margin-left: 40px;
  margin-top: 40px;
}

pre {
  font-family: "Roboto Slab", serif;
  color: white;
}
</style>