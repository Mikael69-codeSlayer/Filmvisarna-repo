<template>
  <div>
    <div class="available-seats">
      <div v-if="seatsLeft" class="movie-list">
        <p>Lediga säten {{ seatsLeft.availableSeats }}</p>
      </div>
      <h1 id="choose-amount">Välj antal biljetter</h1>
      <div class="buttons-container">
        <div class="adult-ticket-container">  
             <div class="adult-header">Vuxen 
               <p class="adult-price">120kr/st</p>
             </div>
               
            
             <div class="increment-buttons"> 
              <button class="button" v-on:click.prevent="increment">+</button>
              <div class="count">{{ count }}</div>
            <button class="button" v-on:click.prevent="decrement">-</button>
            </div>
            </div>
            <button v-on:click="createBooking()" class="book-adult-ticket">Boka</button>

        <div class="adult-ticket-container">
          <p>
            Vuxenbiljett<br />
            Antal: {{ count }}
          </p>
          <button v-on:click.prevent="increment">+</button>
          <button v-on:click.prevent="decrement">-</button>
          <button v-on:click="bookTicket" type="bookTicket" class="book-adult-ticket">Boka</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name:"bookTicket",
  data() {
    return {
      count: 0,
      userId:"",
      film: "",
      date: "",
      time: "",
      salon: "",
      seats: 0,
      price: 0
    };
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
    },
  },

    methods: {
    increment() {
      this.count++;
    },
    decrement() {
      if (this.count > 0) {
        this.count--;
      }
    },
    createBooking() {
      this.seatsLeft.availableSeats =
        this.seatsLeft.availableSeats - this.count;
      console.log(this.seatsLeft.availableSeats);

    },
    bookTicket() {
      const ticket = {
        userId: this.userId,
        film: this.film,
        date: this.date,
        time: this.time,
        salon: this.salon,
        seats: this.seats,
        price: this.price

      };

      this.$store.dispatch("addTicket", ticket);
      this.$router.replace("/minasidor");
    },
  },
};

</script>

<style scoped>

#choose-amount{
  text-align: center;
  font-size: 30px;
  color: whitesmoke;
  font-family: "Roboto Slab", serif;
}

div.adult-price{
  
  float: left;
  padding-top: 30px;
  padding-right: 50px;
}

div.available-seats {
  background-color: rgb(133, 228, 149);
  padding: 300px;
  text-align: center;
}

div.adult-header {
  float: left;
  padding-right: 300px;
  color: whitesmoke;
   font-family: "Roboto Slab", serif;
   font-size: 20px;
   line-height: 15px;
}
.adult-price {
  color: black;
  font-size: 15px;
}

div.count {
  float: left;
  margin: 0 auto;
  text-align: center;
  width: 40px;
    color: whitesmoke;
   font-family: "Roboto Slab", serif;
    font-size: 20px;
    line-height: 30px;
}

.button {
  float: left;
  margin: 0 auto;
  line-height: 30px;
  width: 30px;
  border-radius: 100px;
  border: none;
  cursor: pointer;
  outline: none;
} 


div.adult-ticket-container{
    padding: 30px;
    font-weight: bold;
    width: 500px;
    text-align: left;
    background-color: rgba(255, 228, 196, 0.342);
     margin: 0 auto;
     height: 60px;
     
  }

 
.adult-ticket-container {
  padding-bottom: 20px;
  font-weight: bold;
}
</style>