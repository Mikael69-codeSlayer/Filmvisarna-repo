<template>
  <div class="salon-container">
    <div class="salon-space"></div>
    <div class="salon-header">
      <h1>VÄLJ DINA PLATSER</h1>
      <!-- seat icons -->
      <div class="seats-icons">
        <div class="seat-available-icon"></div>
        <div class="seat-available">Ledig</div>
        <div class="seat-taken-icon"></div>
        <div class="seat-taken">Ej Ledig</div>
        <div class="seat-chosen-icon"></div>
        <div class="seat-chosen">Vald</div>
      </div>
    </div>

    <div class="salon-space"></div>
    
    <!-- loop salons -->
  
    
    <div class="salon" v-for="salon of salons" :key="salon">
      <!-- <div v-bind:class="selectedSalon">  -->
      <div v-if="salon.salonId == 1">
        
        <h1>{{ salon.name }}</h1>
        <p>{{ salon.seats }} Platser</p>
        <div class="salon-space"></div>
        <div class="salon-screen">BIODUK</div>
        <div class="salon-space"></div>
        
        <!-- loop rows -->
        <div class="row" v-for="(row,n) in salon.seatsPerRow" :key="row">
          {{ row }}  
             <!-- loop seats 
             <!--<div class="seat" v-for="seat in row" :key="seat"> {{ (seatNumber++)-8100 }}</div>  -->
             <div class="seat" v-for="seat in row" :key="seat"> {{letters[n]}}{{ (seat-1)+1 }}</div>  
        </div> 
        
        
      </div>
    </div>

    <div class="salon-space"></div>
    <div class="salon-space"></div>
  </div>
</template>



<script>
import { computed } from 'vue';
export default {

  data() {
    const letters = ["A","B","C","D","E","F","G","H","I","J","K","L"]
    return {letters }
    //return {
      //seatNumber: 1,
    //  return letters,
  },

  computed: {
    sNumber() {
    const seatNumber = computed(() => seatNumber + 1);
    },
    //selectedSalon() {
      //return this.$store.state.salons.filter(s => s.salonId == this.salonId)[1];
     // return this.$store.state.salons.filter((salons) => salons.salonId == this.salonId);
     // }
    //},

    salons() {
      //to get Salon
      return this.$store.state.salons;
    }

    //seatNumber: function () {
    //  return this.$store.state.salons.salonId[1].seats++;
    //}
    


    /*
    numberOfSeats: function() {
      return this$store.state.salons.filter(function(item) {
        return salons.seats;
      } );
      
    }, */
    
  }
};
</script>



<style scoped>


.row {
  height: 50px;
  text-align: center;
  color: black;
  display: inline-block;
  margin-left:auto;
  margin-right:auto;
  
}

._row {
  
  margin: 0 auto;
  background: green;
  text-align: center;
  
}


._seats {
  width: 600px;
  text-align: center;
  
  
}

.seat {
  float: left;
  background-color: rgb(204, 204, 204);
  border: 1px solid rgba(0, 0, 0, 0.8);
  font-size: 15px;
  font-weight: bold;
  width: 40px;
  height: 40px;
  text-align: center;
  vertical-align: middle;
  line-height: 40px;
  margin-left: 5px;
  
  
}

.seat:hover {
  background-color: rgb(255, 255, 255);
  cursor: pointer;
}

.salon {
  text-align: center;
  width: 800px;
  height: 300px;
  margin: 0 auto;
  
}

.salon-name {
  color: green;
  font-size: 20px;
}

.salon-header {
  font-family: "Roboto Slab", serif;
  color: white;
  font-weight: 100;
  width: 830px;
  height: 100px;
  background: rgb(0, 0, 0);
  text-align: left;
  margin: 0 auto;
}

.salon-screen {
  width: 730px;
  background: gray;
  color: rgb(255, 255, 255);
  font-family: "Roboto Slab", serif;
  margin: 0 auto;
  height: 30px;
  vertical-align: middle;
  line-height: 30px;
}

.salon-space {
  width: 500px;
  height: 100px;
  background: rgb(0, 0, 0);
  margin: 0 auto;
}
.seats-icons {
  width: 600px;
}

.seat-available-icon {
  float: left;
  width: 20px;
  height: 20px;
  background: rgb(204, 204, 204);
}

.seat-available {
  float: left;
  text-align: left;
  vertical-align: middle;
  line-height: 20px;
  margin-left: 8px;
  width: 70px;
  background: rgb(0, 0, 0);
}

.seat-taken-icon {
  float: left;
  width: 20px;
  height: 20px;
  background: rgb(93, 93, 93);
}

.seat-taken {
  float: left;
  width: 90px;
  vertical-align: middle;
  line-height: 20px;
  margin-left: 8px;
  background: rgb(0, 0, 0);
}

.seat-chosen-icon {
  float: left;
  width: 20px;
  height: 20px;
  background: rgb(255, 82, 82);
}

.seat-chosen {
  float: left;
  width: 80px;
  vertical-align: middle;
  line-height: 20px;
  margin-left: 8px;
  background: rgb(0, 0, 0);
}

.grid-container {
  display: inline-grid;
  grid-template-columns: repeat(16, 1fr);
  grid-gap: 10px;
}


</style>