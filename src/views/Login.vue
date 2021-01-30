<template>
  <div id="login">
    <h1 class="loginbody">Logga in</h1>

    <form @submit.prevent="login">
      <input type="email" required v-model="email" placeholder="E-postadress" />
      <input
        type="password"
        required
        v-model="password"
        placeholder="Lösenord"
      />
      <button type="login">Logga in</button>
    </form>

    <p>---eller---</p>

    <router-link :to="'/skapaKonto/'">
      <button type="register">Skapa konto</button>
    </router-link>
  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      email: "",
      password: "",
    };
  },
  computed: {
    isLoggedIn() {
      return this.$store.state.user != null;
    },
  },
  methods: {
    login() {
      const credentials = {
        //sparar login detaljer i credentials
        email: this.email,
        password: this.password,
      };

      this.$store.dispatch("login", credentials); //skickar till store. Dispatch = kallar på en metod i actions. Commit = kallar på en metod i mutations
      this.$router.replace("/minasidor");
    },
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
input {
  margin-top: 7px;
  text-align: center;
  border-radius: 2px;
  border: none;
  font-family: "Roboto Slab", serif;
  font-size: 15px;
  width: 250px;
  height: 30px;
}

button {
  text-align: center;
  margin-top: 25px;
  border-radius: 2px;
  font-family: "Roboto Slab", serif;
  font-size: 15px;
  color: white;
  background-color: rgb(209, 6, 46);
  border: 0;
  width: 200px;
  height: 30px;
}
</style>