<template>
<h1>Skapa konto</h1>

<div>Skapa konto för att kunna boka biljetter, se bokningsnummer och avboka/omboka biljetter.</div>

<form @submit.prevent="register"> 
      <input type="email" v-model="email" required placeholder="E-postadress"/><br>
    <input type="password" v-model="password" required placeholder="Lösenord"/><br>
   <!-- <input type="confirmpassword" required v-model="password" placeholder="Bekräfta lösenord"/>-->
<<<<<<< HEAD
    </div>
  <router-link :to="'/'" > 
<button type="submit" @click.prevent="register"> Skapa</button>
</router-link>
=======
    
<button type="register">Skapa</button>
</form> 
>>>>>>> 1907b0741464924e21eeb2c654415e68c0924b11
</template>

<script>

export default {

 name: "Login",
  data() {
  return{
        email: "",
        password: "",
       /* confirmPassword: ""*/
      }
    },

    methods:{
    register(){
      const credentials={
      email: this.email,
      password: this.password,
      
      }
     this.$store.dispatch('register', credentials)
<<<<<<< HEAD
      this.$router.replace('/');
=======
      this.$router.replace('/minasidor');
>>>>>>> 1907b0741464924e21eeb2c654415e68c0924b11
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