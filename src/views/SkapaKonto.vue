<template>
<h1>Skapa konto</h1>
<div>Skapa konto för att kunna boka biljetter, se bokningsnummer och avboka/omboka biljetter.</div>

<div class="inputboxes">
      <input type="email" required v-model="email" placeholder="E-postadress"/><br>
    <input type="password" required v-model="password" placeholder="Lösenord"/><br>
    <input type="confirmpassword" required v-model="confirmPassword" placeholder="Bekräfta lösenord"/>
    </div>
<button type="submit" @click.prevent="register"> Skapa</button>
</template>

<script>

export default {

 name: "Login",
  data() {
  return{
        email: "",
        password: "",
        confirmPassword: ""
      }
    },

    methods:{
    register(){
      const credentials={
      email: this.email,
      password: this.password,
      
      }
     this.$store.dispatch('register', credentials)
    }
    }
};

</script>

<style scoped>

div {
  width: 400px;
  margin: auto;
  padding: 20px;
  color: white;
  font-family: "Roboto Slab", serif;
  text-align: center;
  letter-spacing: 1px;

}

h1{
  padding-top:100px;
  color:white;
  margin:auto;
  font-family: "Roboto Slab", serif;
  text-align: center;
  letter-spacing: 1px;
}

input {
margin-top: 7px;
width:250px;
height: 30px;
text-align: center;
font-size: 15px;
font-family: "Roboto Slab", serif;
}

button{
  text-align: center;
margin-top: 20px;
border-radius: 2px;
font-family: "Roboto Slab", serif;
font-size: 15px;
color:white;
background: rgb(209, 6, 46);
border: 0;
padding:5px 10px;
width:200px;
height:30px;
}



</style> 