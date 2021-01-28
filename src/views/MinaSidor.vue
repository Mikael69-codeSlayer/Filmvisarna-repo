<template>
  <h1>Mina Sidor</h1>
  <div>Mina bokningar</div>



</template>

<script>


export default {
  data(){
    return{
      user: "",
    bookings: []
  }},


computed: {
   isLoggedIn(){
      return this.$store.state.user != null
    }
    
  },
methods: {
  
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