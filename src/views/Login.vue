<template>
  <div id="login">
    <h1 class="loginbody">Login</h1>
    <div class="inputboxes"><input
      type="text"
      name="användarnamn"
      v-model="input.användarnamn"
      placeholder="Användarnamn"
    />
    <input
      type="lösenord"
      name="lösenord"
      v-model="input.lösenord"
      placeholder="Lösenord"
    /></div>
    <div class="buttonsbody"><button type="button" @click="login()">Login</button>
    <button type="bliMedlem" @click="bliMedlem()">Skapa konto</button></div>
  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      input: {
        användarnamn: "",
        lösenord: "",
      },
    };
  },
  methods: {
    login() {},
    bliMedlem() {},
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
  background-color: rgb(209, 6, 46);
  margin: auto;
  margin-top: 100px;
  padding: 20px;
  border-radius: 15px;
  color: white;
  font-family: "Roboto Slab", serif;
  text-align: left;
  
}

.inputboxes{
  padding-left: 50px;
  border-radius:10px;
}
.buttonsbody{

padding-left:50px;


}


h1 .loginbody{
  
  float: right;
  margin-top: -45px;
  font-size: 20px;
  padding-right: 70px;
}
</style>