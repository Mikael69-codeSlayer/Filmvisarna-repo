<template>
  <div class="salon-container">
    <div class="salon-space"></div>
    <div class="salon-header">
      <h1>VÄLJ DINA PLATSER</h1>
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
    <div class="salon-screen">BIODUK</div>
    <div class="salon-space"></div>
    <!--
    <div class="grid-container" v-for="salon of salons" :key="salon.id">
        -->
    <div class="salon" v-for="salon of salons" :key="salon.id">
      <div v-if="salon.salonId == 1">
        <h1>{{ salon.name }}</h1>
        <h1>{{ salon.seats }}</h1>
        
        <!--<div class="seats_per_row" v-for="row in salon.seatsPerRow" :key="row"><br>    -->
           
          <div class="seat" v-for="seat in salon.seats" :key="seat">
            <div class="grid-item"> </div>
          </div>
          
        </div> 
        
        
      </div>
    </div>

    <div class="salon-space"></div>
  </div>
</template>



<script>
export default {

  computed: {
    salons() {
      //to get Salon and
      return this.$store.state.salons;
    },
    
    /*
    numberOfSeats: function() {
      return this$store.state.salons.filter(function(item) {
        return salons.seats;
      } );
      
    }, */
    
  },
};
</script>



<style scoped>


.seats {
  width: 500px;
}
.salon {
  width: 500px;
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
  width: 830px;
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

.grid-item {
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
}

.grid-item:hover {
  background-color: rgb(255, 255, 255);
  cursor: pointer;
}
</style>