<template>
  <div>
    <div class="available-seats">
      <div v-if="seatsLeft" class="movie-list">
        <p>Lediga säten {{ seatsLeft.availableSeats }}</p>
      </div>
      <div class="buttons-container">
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
.adult-ticket-container {
  padding-bottom: 20px;
  font-weight: bold;
}
</style>