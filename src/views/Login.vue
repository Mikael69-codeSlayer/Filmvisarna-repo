<template>
  <div id="login">
    <h1 class="loginbody">Login</h1>
    <div class="inputboxes"><input
      type="text"
      name="användarnamn"
      v-model="input.anvandarnamn"
      placeholder="Användarnamn"
    />
    <input
      type="lösenord"
      name="lösenord"
      v-model="input.losenord"
      placeholder="Lösenord"
    /></div>
    <div class="buttonsbody">
    <button type="button" @click="login()">Login</button>
    <p>---eller---</p>
    <button type="bliMedlem" @click="bliMedlem()">Skapa konto</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      input: {
        anvandarnamn: "",
        losenord: "",
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
  background-color: rgba(209, 6, 47, 0.973);
  margin: auto;
  margin-top: 100px;
  padding: 20px;
  border-radius: 15px;
  color: white;
  font-family: "Roboto Slab", serif;
  text-align: center;
  letter-spacing: 1px;
  
}

.inputboxes{
 text-align: center; 
 border-radius:20px;
 box-sizing: border-box;
 border:none;
 font-weight: bold;
 
}

.buttonsbody{
text-align: center;
margin-top: 10px;
}

</style>