<template>
  <!-- Navigationbar with router-link and data-bind-->
  <div class="main-container">
    <div class="nav">
      <div class="nav filmV">
        <router-link :to="{ name: 'Filmvisarna' }">Filmvisarna</router-link>
      </div>
      <div class="nav filmer">
        <router-link :to="{ name: 'Filmer' }">Filmer & Trailer</router-link>
      </div>
      <div class="nav log">
        <router-link v-if="userLoggedIn" :to="{ name: 'Login' }"
          >Login</router-link
        >
        <div class="welcome" v-else>
          Välkommen, {{ userName }}!
          <button @click="mypages">Mina Sidor</button>
          <router-link :to="'/'">
            <button @click="logout">Logga ut</button>
          </router-link>
        </div>
      </div>

      <div class="nav salons">
        <router-link :to="{ name: 'Salons' }">Salonger</router-link>
      </div>
    </div>
  </div>

  <router-view />
</template>

<script scoped>
import Filmvisarna from "./views/Filmvisarna.vue";
import Filmer from "./views/Filmer.vue";
import Login from "./views/Login.vue";
import Tickets from "./views/Tickets.vue";
import Salons from "./views/Salons.vue";
import SkapaKonto from "./views/SkapaKonto.vue";
import MinaSidor from "./views/MinaSidor.vue";

export default {
  name: "App",
  data() {
    return {
      email: "",
    };
  },
  components: {
    Filmvisarna,
    Filmer,
    Login,
    Tickets,
    SkapaKonto,
    MinaSidor,
    Salons,
    SkapaKonto,
  },
  methods: {
    logout() {
      fetch("/api/logout");
      this.$store.commit("setUser", null);
    },
    mypages() {
      this.$router.replace("/minasidor");
    },
  },
  created() {
    this.$store.dispatch("fetchFilmer"),
      this.$store.dispatch("fetchShowtime"),
      this.$store.dispatch("fetchSalons"),
      this.$store.dispatch("whoAmI");
  },
  computed: {
    userLoggedIn() {
      return this.$store.state.user == null;
    },
    isLoggedIn() {
      return this.$store.state.user != null;
    },
    id() {
      // get id from url parameter
      return this.$route.params.id;
    },
    userName() {
      return this.$store.state.user.email;
    },
  },
};
</script>

<style>

/******************** google fonts **************/
/*Cookie*/
@import url("https://fonts.googleapis.com/css2?family=Cookie&display=swap");

/*Roboto Slab*/
@import url("https://fonts.googleapis.com/css2?family=Roboto+Slab&display=swap");
/***********************************************/

/*Navigationbar*/
div.main-container {
  width: 100%;
}
.nav {
  background: rgb(133, 0, 0);
  background: linear-gradient(
    0deg,
    rgba(133, 0, 0, 1) 0%,
    rgba(230, 21, 21, 1) 55%,
    rgba(255, 85, 85, 1) 100%
  );
  padding: 5px;

}
body {
  background-color: black;
  margin: 0 !important;
  padding: 0 !important;
}

/*a -> filmer, biljetter, filmvisarna, login*/
.nav a {
  color: white;
  text-decoration: none;
  position: relative;
}
/*the :hover selector is used to select elements when you mouse over them*/
.nav a:hover {
  color: rgba(240, 248, 255, 0.842);
}
/*the ::after selector inserts something after the content of each selected element(s)*/
.nav a:after {
  bottom: -11px;
  content: "";
  display: block;
  height: 4px;
  left: 50%;
  position: absolute;
  background: rgba(255, 255, 255, 0.548);
  transition: width 0.3s ease 0s, left 0.3s ease 0s;
  width: 0;
}
.nav a:hover:after {
  width: 90%;
  left: 6%;
}

/*Filmvisarna*/
div.filmV {
  font-family: "Cookie", cursive;
  float: center;
  font-size: 50px;
  margin-top: 5px;
  background: rgba(142, 0, 0, 0);
}
/*First letter*/
div.filmV::first-letter {
  font-size: 70px;
  color: aliceblue;
}
/*Filmer*/
div.filmer {
  font-family: "Roboto Slab", serif;
  float: left;
  padding-left: 300px;
  margin-top: -45px;
  font-size: 20px;
  background: rgba(142, 0, 0, 0);
}
/*Biljetter*/
div.bil {
  font-family: "Roboto Slab", serif;
  float: left;
  padding-left: 90px;
  margin-top: -45px;
  font-size: 20px;
  background: rgba(142, 0, 0, 0);
}
/*Login*/
div.salons {
  font-family: "Roboto Slab", serif;
  float: left;
  margin-top: -45px;
  font-size: 20px;
  padding-left: 550px;
  background: rgba(142, 0, 0, 0);
}

/*Login*/
div.log {
  font-family: "Roboto Slab", serif;
  float: right;
  margin-top: -45px;
  font-size: 20px;
  padding-right: 80px;
  color: white;
  background: rgba(142, 0, 0, 0);
}

button {
  color: white;
  text-decoration: none;
  background: rgba(142, 0, 0, 0);
  font-family: "Roboto Slab", serif;
  margin-left: 15px;
  border: none;
  cursor: pointer;
}
</style>