<!--   HTML  -->
<template>
  <div class="home">
    <div class="news-container">
      <div class="news-container-inside">
        <h1 class="news-headline">Aktuellt på bio</h1>

        <div class="news-poster" v-for="film of filmer" :key="film.id">
          <div v-if="film.id == 4">
            <router-link :to="'/filmerDetails/' + film.id">
              <img :src="film.images[1]" />
              <p class="news-spotlight">{{ film.title }}</p>
            </router-link>
            <div class="space"></div>
          </div>
        </div>
      </div>
    </div>
    <div class="showing-now">
      <h1 class="showing-now-headline">{{ msg }}</h1>
      <br>
      <div class="showing-films" v-for="film of filmer" :key="film.id">
        <div class="movie-item">
          <router-link :to="'/filmerDetails/' + film.id">
            <img :src="film.posterUrl" />
          </router-link>
          <br /><a>{{ film.title }}</a>
        </div>
      </div>
     <div class="space"></div>

    </div>
    <!--
    <div
    v-for ="film of filmer"
    :key ="film.id">
        <img :src="posterUrl">
    </div>-->
    <!--If you want to add some pictures-->
    <!--<img :src="posterUrl">-->
  </div>
</template>

<!--  JavaScript (Vue.js)   -->
<script>
export default {
  name: "home",
  data() {
    return {
      msg: "På bio nu",
      posterUrl: "",
    };
  },
  computed: {
    filmer() {
      return this.$store.state.filmer;
    },
  },
};
</script>

<!--- CSS  --->
<style scoped>
/*
IMPORTANT! Don't forget to use 'scoped'
otherwise all changes will effect other files
*/
.space {
  width: 100%;
  height: 50px;
}

a {
  font-family: "Roboto Slab", serif;
  color: white;
  text-decoration: none;
}

p {
  font-family: "Roboto Slab", serif;
  color: white;
}

.news-spotlight {
  font-family: "Roboto Slab", serif;
  color: white;
  text-decoration: none;
}

h1.news-headline {
  font-family: "Roboto Slab", serif;
  color: white;
  padding-right: 70px;
  text-align: left;
  font-size: 20px;
}

.showing-films {
  display: inline-block;
}

.movie-item {
  width: 220px;
}

img {
  width: 200px;
}
div.news-container {
  padding: 50px;
}

.news-poster img {
  width: 400px;
}
.news-container-inside {
  text-align: left;
  padding-left: 26.6vw;
}
.showing-now-headline {
  font-family: "Roboto Slab", serif;
  color: white;
  text-align: center;
  font-size: 20px;
}
.showing-now > h1 {
  text-align: center;
}
</style>