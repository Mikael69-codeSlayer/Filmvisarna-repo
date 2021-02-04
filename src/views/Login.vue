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
import { warn } from "vue";
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
    async login() {
      const credentials = {
        email: this.email,
        password: this.password,
      };

      let user = await fetch("/api/login", {
        method: "POST",
        body: JSON.stringify(credentials),
      });
      try {
        user = await user.json();
        console.log(user);
        this.$store.commit("setUser", user);
        this.$router.replace("/minasidor");
      } catch {
        console.warn("Fel uppgifter");
      }
    },
  },
};
</script>

<style scoped>

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
  cursor: pointer;
}
</style>