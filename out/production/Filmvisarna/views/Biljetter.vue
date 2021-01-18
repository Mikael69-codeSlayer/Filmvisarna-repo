<template>
<h1>Biljetter</h1>
<div>Boka dina biljetter idag</div>

<div class="filmdropdown">

<select v-model="films">
  <option disabled value="">Alla filmer</option>
   <option value="film" v-for="film of filmer" :key="film.title" > {{film.title}}</option>

</select>

</div>

<div class="datedropdown">
<select v-model="date">
<option disabled value="">Datum</option>
   <option value="date">15/1</option>
    <option value="date">16/1</option>
     
</select>
</div>


</template>



<script>
export default {
  data() {
    return {
      films:'',
      date:''

    };
  },
  computed: {
    filmer() {
      return this.$store.state.filmer;
    },
  },

}


</script>

<style scoped>
/*Test
IMPORTANT! Don't forget to use 'scope'
otherwise all changes will effect other files
*/ 
h1{
  font-family: "Roboto Slab", serif;
  text-align: center;
  color: whitesmoke;
  margin-top:70px;
}

select{
  
margin-top: 5px;
 text-align: center; 
 border-radius:2px;
 font-family: "Roboto Slab", serif;
font-size: 16px;
height: 30px;
width:250px;
border-color:white;
background-color: black;
color:white;

}

div.filmdropdown{
  float: left;
  margin-left:200px;
  margin-top:50px;
  color: white;

}

div.datedropdown{
  float: left;
  margin-top:50px;
  margin-left:2px;
}


</style>