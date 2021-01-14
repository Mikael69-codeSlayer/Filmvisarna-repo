<template>

  <div id="login">
    <h1 class="loginbody">Logga in</h1>
    <div class="inputboxes">
      <input type="text" name="username" v-model="input.username" placeholder="E-postadress"
    />
    <input type="password" name="password" v-model="input.password" placeholder="Lösenord"/>
    </div>
    <div class="buttonsbody">
    <button type="login" @click="login()">Logga in</button>

    <p>---eller---</p>

    <router-link :to="'/skapaKonto/'" >  
    <button type="register">Skapa konto</button>
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
        username: "",
        password: "",
      },
    };
  },
  methods: {
    handlelogin(){
     
    }
  },
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

.inputboxes input{
  margin: 10px 0 5px;
 text-align: center; 
 border-radius:2px;
 border:none;
 font-family: "Roboto Slab", serif;
  font-size: 15px;
}

button {
text-align: center;
margin-top: 10px;
border-radius: 2px;
font-family: "Roboto Slab", serif;
font-size: 15px;
color: red;
border: 0;
padding:5px 10px;

}
</style>