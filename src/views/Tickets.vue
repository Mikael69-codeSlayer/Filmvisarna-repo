<template>
  <div class="salon-container">
    <div class="salon-header">{{ currentShow.film + " - " +  
      " " + currentShow.date + "  " + currentShow.time + " - " + currentShow.salon}}</div>
<!--- Loop salons to get Salon1--->
    <div class="salon" v-for="salon of salons" :key="salon.name">
      
      <div v-if="salon.name == currentShow.salon">
         <!-- display seats and movie screen  -->
        <div class="spacing"></div>
        <div class="salon-screen">BIODUK</div>
        <div class="spacing"></div>
        
        <!-- loop through the rows -->
        <div class="row" v-for="(row,n) in salon.seatsPerRow" :key="row">
          
             <!-- loop seats and set seat/row number-->
             <button class="seat" v-for="seat in row" :key="seat"> {{letters[n]}}{{ (seat-1)+1 }}</button>  
        </div>
        <br><br>
        <p id="available-seats">{{ currentShow.availableSeats }} Lediga platser</p>
        
      </div>
    </div>
  </div>

    <div class="tickets-container">
      <div v-if="currentShow" class="movie-list">
        
      </div>
      <div class="tickets-header">Boka biljetter</div>
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

        <button class="book-button" v-on:click="updateShow()">Boka</button>
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
      letters : ["A","B","C","D","E","F","G","H","I","J","K","L"],
      selected: false
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
        salons() {
      //to get Salon
      return this.$store.state.salons;
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

.salon-container {
  background-color: rgb(34, 17, 17);
  
}
.salon-header {
  font-family: "Roboto Slab", serif;
  color: white;
  font-size: 30px;
  background-color: rgb(34, 17, 17);
  padding-top: 70px;

}
.increment-buttons {
  float: right;
  width: 100px;
}

/*-------------------Salon----------------------*/
.row {
  height: 30px;
  text-align: center;
  color: black;
  display: inline-block;
  margin-left:auto;
  margin-right:auto;
  user-select: none;
}
.seat {
  text-align: center;
  margin: 3px;
  width: 25px;
  height: 25px;
  border: none;
  font-family: "Roboto Slab", serif;
  font-size: 8px;
  user-select: none;
  border-radius: 2px;
  background-color: rgb(156, 156, 156);
  color: 156, 156, 156;
}

.salon {
  text-align: center;
  width: 430px;
  height: 270px;
  margin: 0 auto;
  user-select: none;
  background-color: rgba(34, 17, 17, 0);
}


.salon-screen {
  width: 370px;
  background-color: rgb(70, 70, 70);
  color: rgb(255, 255, 255);
  font-family: "Roboto Slab", serif;
  margin: 0 auto;
  height: 20px;
  vertical-align: middle;
  line-height: 20px;
  font-size: 12px;
}

.spacing {
  width: 500px;
  height: 50px;
  background: rgba(0, 0, 0, 0);
  margin: 0 auto;
  user-select: none;
}
/*------------Tickets---------------*/
#available-seats {
  font-family: "Roboto Slab", serif;
  font-size: 18px;
  color: white;
  
}

.buttons-container {
  height: 550px;
  padding-top: 10px;
}

.tickets-header {
  text-align: center;
  font-size: 30px;
  color: white;
  font-family: "Roboto Slab", serif;
}
.tickets-container {
  background-color: rgb(34, 17, 17);
  text-align: center;
}

/*/--/--/--/--/--/--/--/--/--/--/--/--/--/--/--/- ADULT TICKET -/--/--/--/--/--/--/--/--/--/--/--/--/--/*/

.adult-price {
  color: rgba(175, 175, 175);
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
  height: 56px;
}

.adult-ticket-container {
  padding-bottom: 20px;
  font-weight: bold;
}

/*/--/--/--/--/--/--/--/--/--/--/--/--/--/--/--/- CHILD TICKET -/--/--/--/--/--/--/--/--/--/--/--/--/--/*/

.child-price {
  color: rgb(175, 175, 175);
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
  background-color: rgba(10, 10, 10, 0.294);
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
.book-button {
  padding: 10px 30px;
  font-size: 20px;
}

</style>