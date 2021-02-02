<template>
  <div>
    <div class="available-seats">
      <div v-if="currentShow" class="movie-list">
        <p>Lediga säten {{ currentShow.availableSeats }}</p>
      </div>
      <h1 id="choose-amount">Välj antal biljetter</h1>
      <div class="buttons-container">
        <!-- Adult tickets -->
        <div class="adult-ticket-container">
          <div class="adult-header">
            Vuxen
            <p class="adult-price">120kr/st</p>
          </div>
          <!-- Adult plus and minus buttons -->
          <div class="increment-buttons">
            <button class="adultButton" v-on:click.prevent="aIncrement">+</button>
            <div class="adultCount">{{ adultCount }}</div>
            <button class="adultButton" v-on:click.prevent="aDecrement">-</button>
          </div>
        </div>
        <!-- Child tickets -->
        <div class="child-ticket-container">
          <div class="child-header">
            Barn
            <p class="child-price">80kr/st</p>
          </div>
          <!-- Child plus and minus buttons -->
          <div class="increment-buttons">
            <button class="childButton" v-on:click.prevent="cIncrement">+</button>
            <div class="childCount">{{ childCount }}</div>
            <button class="childButton" v-on:click.prevent="cDecrement">-</button>
          </div>
        </div>
        <!-- Senior tickets -->
        <div class="senior-ticket-container">
          <div class="senior-header">
            Pensionär
            <p class="senior-price">80kr/st</p>
          </div>
          <!-- Senior plus and minus buttons -->
          <div class="increment-buttons">
            <button class="seniorButton" v-on:click.prevent="sIncrement">+</button>
            <div class="seniorCount">{{ seniorCount }}</div>
            <button class="seniorButton" v-on:click.prevent="sDecrement">-</button>
          </div>
        </div>

        <button v-on:click="updateShow() /*,bookTicket() */" class="book-ticket">Boka</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "bookTicket",
  data() {
    return {
      adultCount: 0,
      childCount: 0,
      seniorCount: 0,
      availableSeats: "",
      userId: "",
      film: "",
      date: "",
      time: "",
      salon: "",
      seats: 0,
      price: 0,
    };
  },
  computed: {
    id() {
      // Get id from url parameter
      return this.$route.params.id;
    },
    currentShow() {
      // To get filmes and id
      return this.$store.state.showtime.filter(
        (showtime) => showtime.id == this.id
      )[0];
    },

  },

  methods: {

    updateShow() {
        // Send booked seats + show id to backend
        const show = {
          bookedSeats: this.adultCount + this.childCount + this.seniorCount,
          id: this.id
        }
        this.$store.dispatch('updateShow', show);
    },

    // Ticket button increments and decrements
    aIncrement() {
      if (this.adultCount < 8) {
        this.adultCount++;
      }
    },

    aDecrement() {
      if (this.adultCount > 0) {
        this.adultCount--;
      }
    },

    cIncrement() {
      if (this.childCount < 8) {
        this.childCount++;
      }
    },

    cDecrement() {
      if (this.childCount > 0) {
        this.childCount--;
      }
    },
    sIncrement() {
      if (this.seniorCount < 8) {
        this.seniorCount++;
      }
    },

    sDecrement() {
      if (this.seniorCount > 0) {
        this.seniorCount--;
      }
    },

    bookTicket() {
      const ticket = {
        userId: this.userId,
        film: this.film,
        date: this.date,
        time: this.time,
        salon: this.salon,
        seats: this.seats,
        price: this.price,
      };

      this.$store.dispatch("addTicket", ticket);
      this.$router.replace("/minasidor");
    },
  },
};
</script>

<style scoped>

#choose-amount {
  text-align: center;
  font-size: 30px;
  color: whitesmoke;
  font-family: "Roboto Slab", serif;
}

div.available-seats {
  background-color: rgba(47, 44, 44, 0.26);
  padding: 300px;
  text-align: center;
}
.increment-buttons {
  float: right;
  width: 100px;
}

/*/--/--/--/--/--/--/--/--/--/--/--/--/--/--/--/- ADULT TICKET -/--/--/--/--/--/--/--/--/--/--/--/--/--/*/

.adult-price {
  color: rgba(250, 227, 227, 0.719);
  font-size: 15px;
}

div.adult-header {
  float: left;
  padding-right: 300px;
  color: whitesmoke;
  font-family: "Roboto Slab", serif;
  font-size: 20px;
  line-height: 15px;
}

div.adultCount {
  float: left;
  margin: 0 auto;
  text-align: center;
  width: 40px;
  color: whitesmoke;
  font-family: "Roboto Slab", serif;
  font-size: 20px;
  line-height: 30px;
}

.adultButton {
  float: left;
  margin: 0 auto;
  line-height: 30px;
  width: 30px;
  border-radius: 100px;
  border: none;
  cursor: pointer;
  outline: none;
}

div.adult-ticket-container {
  padding: 30px;
  font-weight: bold;
  width: 500px;
  text-align: left;
  background-color: rgba(0, 0, 0, 0.329);
  margin: 0 auto;
  height: 60px;
}

.adult-ticket-container {
  padding-bottom: 20px;
  font-weight: bold;
}

/*/--/--/--/--/--/--/--/--/--/--/--/--/--/--/--/- CHILD TICKET -/--/--/--/--/--/--/--/--/--/--/--/--/--/*/

.child-price {
  color: rgba(250, 227, 227, 0.719);
  font-size: 15px;
}

div.child-header {
  float: left;
  padding-right: 300px;
  color: whitesmoke;
  font-family: "Roboto Slab", serif;
  font-size: 20px;
  line-height: 15px;
}

div.childCount {
  float: left;
  margin: 0 auto;
  text-align: center;
  width: 40px;
  color: whitesmoke;
  font-family: "Roboto Slab", serif;
  font-size: 20px;
  line-height: 30px;
}

.childButton {
  float: left;
  margin: 0 auto;
  line-height: 30px;
  width: 30px;
  border-radius: 100px;
  border: none;
  cursor: pointer;
  outline: none;
}

div.child-ticket-container {
  padding: 30px;
  font-weight: bold;
  width: 500px;
  text-align: left;
  background-color: rgb(10, 10, 10);
  margin: 0 auto;
  height: 60px;
}

/*/--/--/--/--/--/--/--/--/--/--/--/--/--/--/--/- SENIOR TICKET -/--/--/--/--/--/--/--/--/--/--/--/--/--/*/

.senior-price {
  color: rgba(250, 227, 227, 0.719);
  font-size: 15px;
}

div.senior-header {
  float: left;
  padding-right: 300px;
  color: whitesmoke;
  font-family: "Roboto Slab", serif;
  font-size: 20px;
  line-height: 15px;
}

div.seniorCount {
  float: left;
  margin: 0 auto;
  text-align: center;
  width: 40px;
  color: whitesmoke;
  font-family: "Roboto Slab", serif;
  font-size: 20px;
  line-height: 30px;
}

.seniorButton {
  float: left;
  margin: 0 auto;
  line-height: 30px;
  width: 30px;
  border-radius: 100px;
  border: none;
  cursor: pointer;
  outline: none;
}

div.senior-ticket-container {
  padding: 30px;
  font-weight: bold;
  width: 500px;
  text-align: left;
  background-color: rgba(0, 0, 0, 0.329);
  margin: 0 auto;
  height: 60px;
}
</style>