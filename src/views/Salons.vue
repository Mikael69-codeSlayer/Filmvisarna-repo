<template>
  <div class="salon-container">
    <div class="spacing"></div>
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

    <div class="spacing"></div>
    
    <!--- Loop salons to get Salon1--->
    <div class="salon" v-for="salon of salons" :key="salon">
      
      <div v-if="salon.salonId == 1">
        <!-- display salon name, seats and movie screen  -->
        <h1>{{ salon.name }}</h1>
        <p>{{ salon.seats }} Platser</p>
        <div class="spacing"></div>
        <div class="salon-screen">BIODUK</div>
        <div class="spacing"></div>
        
        <!-- loop through the rows -->
        <div class="row" v-for="(row,n) in salon.seatsPerRow" :key="row">
          
             <!-- loop seats and set seat/row number-->
             <button class="seat" @click="$event.target.classList.toggle('selected')" v-for="seat in row" :key="seat"> {{letters[n]}}{{ (seat-1)+1 }}</button>  
        </div>  
      </div>
    </div>

        
    <!--<div id="app3">-->

      <!--- Loop salons to get Salon2--->
    <div class="salon" v-for="salon of salons" :key="salon">
      <div v-if="salon.salonId == 2">
        <!-- display salon name, seats and movie screen  -->
        <h1>{{ salon.name }}</h1>
        <p>{{ salon.seats }} Platser</p>
        <div class="spacing"></div>
        <div class="salon-screen">BIODUK</div>
        <div class="spacing"></div>
        
        <!-- loop through the rows -->
        <div class="row" v-for="(row,n) in salon.seatsPerRow" :key="row">
           
             <!-- loop seats and set seat/row number-->
             <button class="seat" @click="$event.target.classList.toggle('selected')" v-for="seat in row" :key="seat"> {{letters[n]}}{{ (seat-1)+1 }}</button> 
        </div>  
      </div>
        <div class="spacing"></div>
        <div class="spacing"></div>
    </div>
    </div>

  <!--</div>-->
</template>



<script>
import { computed } from 'vue';
export default {
  //el: '#app3',
  data: { selected: false },

  data() {
    //return row letter
    const letters = ["A","B","C","D","E","F","G","H","I","J","K","L"]
    return { letters }
    
  },

  computed: {
    sNumber() {
    const seatNumber = computed(() => seatNumber + 1);
    },
    salons() {
      //to get Salon
      return this.$store.state.salons;
    }, 
   methods: {
    toggleClass: function(event){
       this.isActive = !this.isActive;
    }
  }
  }
};
</script>



<style scoped>

.seat {
  text-align: center;
  padding: 10px 10px;
  margin: 3px;
  border: none;
  font-family: "Roboto Slab", serif;
  font-weight: bold;
  background-color: rgb(204, 204, 204);
  font-size: 14px;
  user-select: none;
  border-radius: 2px;
}

.selected {
  background: red;
}



h1 {
  font-family: "Roboto Slab", serif;
  color: white;
  font-size: 25px;
}

p {
  font-family: "Roboto Slab", serif;
  color: white;
}


.row {
  height: 50px;
  text-align: center;
  color: black;
  display: inline-block;
  margin-left:auto;
  margin-right:auto;
  user-select: none;
}
/*
.seats {
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
  user-select: none;
}
 */
.seats:hover {
  background-color: rgb(255, 255, 255);
  cursor: pointer;
}

.salon {
  text-align: center;
  width: 600px;
  height: 250px;
  margin: 0 auto;
  user-select: none;
  background-color: rgb(0, 0, 0);
  
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
  width: 600px;
  background: gray;
  color: rgb(255, 255, 255);
  font-family: "Roboto Slab", serif;
  margin: 0 auto;
  height: 30px;
  vertical-align: middle;
  line-height: 30px;
}

.spacing {
  width: 500px;
  height: 70px;
  background: rgb(0, 0, 0);
  margin: 0 auto;
  user-select: none;
}
.seats-icons {
  width: 600px;
}

.seat-available-icon {
  float: left;
  width: 20px;
  height: 20px;
  background: rgb(204, 204, 204);
  user-select: none;
}

.seat-available {
  float: left;
  text-align: left;
  vertical-align: middle;
  line-height: 20px;
  margin-left: 8px;
  width: 70px;
  background: rgb(0, 0, 0);
  user-select: none;
}

.seat-taken-icon {
  float: left;
  width: 20px;
  height: 20px;
  background: rgb(93, 93, 93);
  user-select: none;
}

.seat-taken {
  float: left;
  width: 90px;
  vertical-align: middle;
  line-height: 20px;
  margin-left: 8px;
  background: rgb(0, 0, 0);
  user-select: none;
}

.seat-chosen-icon {
  float: left;
  width: 20px;
  height: 20px;
  background: rgb(255, 82, 82);
  user-select: none;
}

.seat-chosen {
  float: left;
  width: 80px;
  vertical-align: middle;
  line-height: 20px;
  margin-left: 8px;
  background: rgb(0, 0, 0);
  user-select: none;
}
</style>