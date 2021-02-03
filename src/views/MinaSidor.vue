<template>
  <h1>Mina Sidor</h1>
  <div class="header">Mina bokningar</div>


  <div v-for="info of sortedTickets" :key="info">
    <div class="ticket-info">
      <p>{{ info.film }}</p>
      <pre>
    Datum:  {{ info.date }} 
    Tid:  {{ info.time }}
    Antal bokade platser:  {{ info.seats }} 
    Bokningsnummer:  {{ info.id }}
    Totala kostnaden:  {{ info.price }}kr</pre>
    <div class="ticket-image" v-for="film of filmer" :key="film.id" >
      <div v-if="info.film == film.title">
      <img :src="film.posterUrl"/></div>
      <div class="line"></div>
    </div>
  </div>
</div>
  <!---<div class="salon" v-for="salon of salons" :key="salon.name">              <div v-if="salon.name == currentShow.salon"> -->

  <footer>Betalning sker på plats, uppge ditt bokningsnummer</footer>
</template>

<script>
export default {
  data(){
   return{
     films: "",
     posterUrl: "",
     date:""
   }
  },
  methods:{
    imagesDisplayed(){
        if(filmer.title == allTickets.film){
              return this.posterUrl
        }
    }
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
    sortedTickets() {                         //sorts the tickets by date
      //This removes all "-" in dates
      for (let ticket of this.tickets) {
        if (ticket.date.includes("-")) {
          ticket.date = ticket.date.replaceAll("-", "");
          //console.log(ticket.date)
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
  margin-left: 40px;
  margin-top: 40px;
  font-size: 20px;
}
div {
  font-family: "Roboto Slab", serif;
  color: rgba(250, 227, 227, 0.719);
  text-align: left;
  margin-left: 40px;
  margin-top: 40px;
}
p {
  margin-left: 35px;
}

pre {
  font-family: "Roboto Slab", serif;
  color: white;
  margin-left: 40px;
}
div.line {
  background-color: white;
  width: 90%;
  height: 1px;
  margin-top: 10px;
}

footer {
  font-family: "Roboto Slab", serif;
  color: rgba(250, 227, 227, 0.719);
  margin-top: 20px;
  margin-bottom: 20px;
  font-size: 15px;
}
.ticket-image{
  background-color: green;
  width: 100px;
  height:100px;
}
img {
  width: 100px;
}
</style>