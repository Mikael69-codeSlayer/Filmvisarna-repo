<template>
<div>
  <div class="available-seats">
      <div v-if="seatsLeft" class="movie-list">
        <p>Lediga säten {{ seatsLeft.availableSeats }}</p>
      </div>
      <div class="buttons-container">

        <div class="adult-ticket-container">  
             <p>Vuxenbiljett<br> Antal: {{ count }}</p>
              <button v-on:click.prevent="increment">+</button>
            <button v-on:click.prevent="decrement">-</button>
            <button v-on:click="createBooking()" class="book-adult-ticket">Boka</button>
          </div>

      </div>
  </div>




</div>
  
</template>

<script>
export default {
     data: ()=> {
    return {
      count: 0
    }
  },
computed: {

    id() {
      // get id from url parameter
      return this.$route.params.id;
    },
    seatsLeft() {
      // Also added this, to get filmes and id
      return this.$store.state.showtime.filter(
        (showtime) => showtime.id == this.id
      )[0];
      }
    },

    methods: {
    increment () {
      this.count++;
    },
    decrement () {
      if(this.count > 0){
        this.count-- ;
      }
    },

          /*  const credentials={
      email: this.email,
      password: this.password,
      }

     this.$store.dispatch('register', credentials)
      this.$router.replace('/minasidor');
    } */

    createBooking () {
       this.seatsLeft.availableSeats = this.seatsLeft.availableSeats - this.count;
       console.log(this.seatsLeft.availableSeats);
    
     /* const credentials={
      availableSeats: this.seatsLeft.availableSeats
      */

     this.$store.dispatch('book-adult-ticket', credentials)
    //  this.$router.replace('/minasidor');
    }
  }
}
</script>

<style scoped>
div.available-seats {
  background-color: rgba(128, 0, 128, 0.274);
  padding: 300px;
  
}

  .adult-ticket-container{
    padding-bottom: 20px;
    font-weight: bold;
  }
</style>