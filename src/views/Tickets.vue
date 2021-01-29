<template>
<div>
  <div class="available-seats">
      <div v-if="seatsLeft" class="movie-list">
        <p>Lediga säten {{ seatsLeft.availableSeats }}</p>
      </div>
  </div>








</div>
  
</template>

<script>
export default {
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
      // this.id)[0]; alltid en stor vilket blir retunerad
      //array[0]
    },userLoggedIn() {
      return this.$store.state.user == null
  },
   isLoggedIn(){
      return this.$store.state.user != null
    },
    // images() {
    //   return this.$store.state.images.filter((images) => images.id == this.id);
    // },
    showtime() {
      return this.$store.state.showtime.filter(
        (showtime) => showtime.film == this.film.title
      );
    },
}
}
</script>

<style>

</style>