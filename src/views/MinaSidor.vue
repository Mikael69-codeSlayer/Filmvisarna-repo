<template>


  <h1>Mina Sidor</h1>
  <div class="header">Mina bokningar</div>
  <div class="payInfo">Betalning sker på plats, uppge ditt bokningsnummer</div>
<!-- Loops out all tickets the user bought, sorted by date -->
  <div class="ticket-container" v-for="info of sortedTickets" :key="info">
    <div class="ticket-info">
      <p>{{ info.film }}</p>

      <pre>
    Datum:  {{ info.date }} 
    Tid:  {{ info.time }}
    Antal bokade platser:  {{ info.seats }} 
    Bokningsnummer:  {{ info.id }}
    Totala kostnaden:  {{ info.price }}kr</pre
      >
    </div>

    <div class="ticket-image" v-for="film of filmer" :key="film.id">
      <div v-if="info.film == film.title">
        <img :src="film.posterUrl" />
      </div>
    </div>
  </div>
  
</template>

<script>
export default {
  data() {
    return {
      films: "",
      posterUrl: "",
      date: "",
    };
  },
  computed: {
    id() {
      // Get id from url parameter
      return this.$route.params.id;
    },
    userName() {
      return this.$store.state.user.email;
    },
    tickets() {
      return this.$store.state.allTickets;
    },
    filmer() {
      return this.$store.state.filmer;
    },
    sortedTickets() {
      //sorts the tickets by date
      //This removes all "-" in dates
      for (let ticket of this.tickets) {
        if (ticket.date.includes("-")) {
          ticket.date = ticket.date.replaceAll("-", "");
        }
      }
      //This sorts ticket dates in order
      this.tickets.sort((a, b) => a.date - b.date);

      //This adds "-" between year-month and month-day
      for (let ticket of this.tickets) {
        if (ticket.date.includes(2021)) {
          ticket.date = ticket.date.replace("2021", "2021-");
        }
        if (ticket.date.includes(2021)) {
          ticket.date = ticket.date.replace("-02", "-02-");
        }
      }

      return this.tickets;
    },
    sortedPosters() {
      for (let info of this.filmer) {
        if (info.posterUrl == film.title) {
          return this.$store.state.filmer.posterUrl;
        }
      }
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
.header {
  font-family: "Roboto Slab", serif;
  color: white;
  text-align: left;
  font-size: 20px;
  margin: 0 auto;
  width: 1000px;
  height: 100px;
  line-height: 100px;
}
.ticket-info {
  font-family: "Roboto Slab", serif;
  color: rgba(250, 227, 227, 0.719);
  text-align: left;
  margin-left: 40px;
  margin-top: 40px;
  float: left;
  margin: 0 auto;
  width: 800px;
 
}

.ticket-container{
width: 910px;
margin: 0 auto;

}

p {
  margin-left: 35px;
}

pre {
  margin-left: 100px;
  font-family: "Roboto Slab", serif;
  color: white;
  margin-left: 40px;
  margin-bottom: 80px;
}
div.line {
  background-color: white;
  width: 90%;
  height: 1px;
  margin-top: 10px;
}

.payInfo {
  font-family: "Roboto Slab", serif;
  color: rgb(143, 131, 131);
  margin:0 auto;
  font-size: 12px;
  text-align: center;
  height: 80px;
}
.ticket-image {
  float: left;
  margin: 0 auto;
}
img {
  width: 110px;
}
</style>