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
          <!-- plus and minus buttons -->

          <div class="increment-buttons">
            <button class="aButton" v-on:click.prevent="aIncrement">+</button>
            <div class="aCount">{{ aCount }}</div>
            <button class="aButton" v-on:click.prevent="aDecrement">-</button>
          </div>
        </div>
        <!-- Child tickets -->
        <div class="child-ticket-container">
          <div class="child-header">
            Barn
            <p class="child-price">80kr/st</p>
          </div>
          <!-- plus and minus buttons -->
          <div class="increment-buttons">
            <button class="cButton" v-on:click.prevent="cIncrement">+</button>
            <div class="cCount">{{ cCount }}</div>
            <button class="cButton" v-on:click.prevent="cDecrement">-</button>
          </div>
        </div>
        <!-- Senior tickets -->
        <div class="senior-ticket-container">
          <div class="senior-header">
            Pensionär
            <p class="senior-price">80kr/st</p>
          </div>

          <div class="increment-buttons">
            <button class="sButton" v-on:click.prevent="sIncrement">+</button>
            <div class="sCount">{{ sCount }}</div>
            <button class="sButton" v-on:click.prevent="sDecrement">-</button>
          </div>
        </div>

        <button
          v-on:click="updateAvailableSeats, writeSeatsLeft, bookTicket"
          class="book-adult-ticket"
        >
          Boka
        </button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "bookTicket",
  data() {
    return {
      aCount: 0,
      cCount: 0,
      sCount: 0,
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
      // get id from url parameter
      return this.$route.params.id;
    },
    currentShow() {
      // Also added this, to get filmes and id
      return this.$store.state.showtime.filter(
        (showtime) => showtime.id == this.id
      )[0];
    },
    updateAvailableSeats() {
      this.seatsLeft.availableSeats =
        this.seatsLeft.availableSeats -
        (this.aCount + this.cCount + this.sCount);

      //console.log(this.seatsLeft.availableSeats);
    },
  },

  methods: {
    writecurrentShow() {
        const show = {
          availableSeats: this.currentShow.availableSeats
        }
        this.$store.commit('updateShow', show);
    },

    aIncrement() {
      if (this.aCount < 8) {
        this.aCount++;
      }
    },

    aDecrement() {
      if (this.aCount > 0) {
        this.aCount--;
      }
    },

    cIncrement() {
      if (this.cCount < 8) {
        this.cCount++;
      }
    },

    cDecrement() {
      if (this.cCount > 0) {
        this.cCount--;
      }
    },
    sIncrement() {
      if (this.sCount < 8) {
        this.sCount++;
      }
    },

    sDecrement() {
      if (this.sCount > 0) {
        this.sCount--;
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

/*/--/--/--/--/--/--/--/--/--/--/--/--/--/--/--/- ADULT TICKET -/--/--/--/--/--/--/--/--/--/--/--/--/--/*/

.adult-price {
  color: rgba(250, 227, 227, 0.719);
  font-size: 15px;
}

div.available-seats {
  background-color: rgba(47, 44, 44, 0.26);
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

div.aCount {
  float: left;
  margin: 0 auto;
  text-align: center;
  width: 40px;
  color: whitesmoke;
  font-family: "Roboto Slab", serif;
  font-size: 20px;
  line-height: 30px;
}

.aButton {
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

.increment-buttons {
  float: right;
  width: 100px;
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

div.cCount {
  float: left;
  margin: 0 auto;
  text-align: center;
  width: 40px;
  color: whitesmoke;
  font-family: "Roboto Slab", serif;
  font-size: 20px;
  line-height: 30px;
}

.cButton {
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

div.sCount {
  float: left;
  margin: 0 auto;
  text-align: center;
  width: 40px;
  color: whitesmoke;
  font-family: "Roboto Slab", serif;
  font-size: 20px;
  line-height: 30px;
}

.sButton {
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