<template>
  <h1>Mina Sidor</h1>
  <div> Mina bokningar </div>
  <p></p>



</template>

<script>


export default {
  data(){
    return{
      
  }
  },

computed: {
   userName(){
      return this.$store.state.user.email
    },
   isLoggedIn(){
      return this.$store.state.user != null
    },
    myBookings(){
      return this.$store.state.user.bookings 
    }
  
  },
methods: {

  created() {
    this.$store.dispatch("whoAmI")
  },
}
}

</script>

<style scoped>

h1{
  font-family: "Roboto Slab", serif;
  color: white;
  text-align: center;
  margin-top:40px;
}
div{
  font-family: "Roboto Slab", serif;
  color: white;
  text-align: left;
  margin-left: 40px;
  margin-top:40px;
}
</style>