
  <!-- Title -->
  
<template>
  <nav>
    <router-link to="/">Filmvisarna</router-link>

    <a class="tickets" @click="goToTickets">Biljetter</a>

    <a class="filmsAndTrailers" @click="goToFilmsAndTrailer"
      >Filmer & Trailer</a
    >

    <a class="login" @click="login">Logga in</a>
  </nav>
</template>

<script>
export default {
  name: "Navbar",
  props: {
    filmvisarna: String,
  },
};
</script>


<style scoped>
nav {
  margin: -15px;
  margin-top: -15px;
  user-select: none;
  padding: 25px 0 45px 0;
  text-align: center;
  background-color: rgb(218, 31, 31);
  color: rgb(241, 241, 241);
}

router-link {
  text-decoration: none;
  color: rgb(241, 241, 241);
  font-weight: bold;
  float: left;
  padding-left: 10px;
}
a {
  text-decoration: none;
  color: rgb(241, 241, 241);
  font-weight: bold;
  float: left;
  cursor: pointer;
}

a:hover {
  color: burlywood;
}

.tickets {
  padding-left: 20vh;
}

.filmsAndTrailers {
  padding-left: 20vh;
}

.login {
  float: right;
  padding-right: 50px;
}

.login:hover {
  color: rgb(128, 195, 226);
}
</style>