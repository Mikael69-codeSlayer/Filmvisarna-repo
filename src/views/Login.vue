<template>

  <div id="login">
    <h1 class="loginbody">Logga in</h1>
    <div class="inputboxes">
    <input type="email" required v-model="input.email" placeholder="E-postadress"/>
    <input type="password" required v-model="input.password" placeholder="Lösenord"/>
    </div>

    <div class="buttonsbody">
    <button type="login" @click.prevent="login" v-if="!isLoggedIn">Logga in</button>

   <button v-else @click="logout">Logout</button>

    <p>---eller---</p>
    <router-link :to="'/skapaKonto/'" >  
    <button type="register" >Skapa konto</button>
    </router-link>
  

    </div>
 
  </div>
  
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      input: {
        email: "",
        password: "",
      },
    }
  },
   computed:{
    isLoggedIn(){
      return this.$store.state.user != null
    }

  },
  methods: {
    login(){
      const credentials={
      email: this.email,
      password: this.password
      }
     this.$store.dispatch('login', credentials)
    },
    logout(){
      fetch('/api/logout')
      this.$store.commit('setUser', null)
    }
  }

};
</script>

<style scoped>
/*
IMPORTANT! Don't forget to use 'scope'
otherwise all changes will effect other files
*/

#login {
  width: 300px;
  margin: auto;
  margin-top: 100px;
  padding: 20px;
  border-radius: 15px;
  color: white;
  font-family: "Roboto Slab", serif;
  text-align: center;
  letter-spacing: 1px;
  
}
 input{
  margin-top: 7px;
 text-align: center; 
 border-radius:2px;
 border:none;
 font-family: "Roboto Slab", serif;
  font-size: 15px;
  width:250px;
  height: 30px;
}

button {
text-align: center;
margin-top: 25px;
border-radius: 2px;
font-family: "Roboto Slab", serif;
font-size: 15px;
color: white;
background-color:  rgb(209, 6, 46);
border: 0;
width:200px;
height:30px;

}

</style>