<!--This is for movies and trailers-->
<template>
  <div class="movies-container">
    <div class="movies-header">
      <h1 class="filmer-header">Filmer</h1>
    </div>

    <div class="movie-list">
      <div v-for="film of filmer" :key="film.id">
        <router-link :to="'/filmerDetails/' + film.id">
          <div class="movie-item">
            <div class="movie-item-poster">
              <img :src="film.posterUrl" />
            </div>

            <div class="movie-item-text">
              <p>{{ film.title }}</p> <br />
              {{ film.genre }} 
              | {{ film.length }} min
              | {{ film.language }}
            </div>
          </div>
        </router-link>

        <div class="movie-item-space">
          <div class="line"></div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      
    };
  },
  computed: {
    filmer() {
      return this.$store.state.filmer;
    },
  },
};
</script>

<style scoped>
/*
IMPORTANT! Don't forget to use 'scope'
otherwise all changes will effect other files
*/

div.movies-container {
  color: white;
  width: 100%;
  position: relative;
  height: 5000px;
  background: rgb(0, 0, 0);
  padding: 40px 0;
}

div.movies-header {
  background-color: rgb(0, 0, 0);
  width: 55%;
  margin: 0 auto;
  text-align: left;
  padding-left: 10px;
  padding-top: 5px;
}

h1.filmer-header {
  font-size: 25px;
  width: 980px;
  height: 42px;
  color: white;
  font: 36px;
  margin: 0 0 8px;
  padding: 0 84px 0px 0px;
}

div.movie-list {
  background-color: rgb(0, 0, 0);
  height: 1100px;
  width: 55%;
  margin: 0 auto;
  padding-left: 10px;
  padding-top: 5px;
}

div.movie-item {
  background-color: rgb(0, 0, 0);
  width: 100%;
  overflow: hidden;
  height: 140px;
}

div.movie-item-poster {
  background-color: rgb(0, 0, 0);
  width: 100px;
  height: 150px;
  float: left;
}

div.movie-item-text {
  background-color: rgb(0, 0, 0);
  display: inline-block;
  width: 40vw;
  height: 100px;
  text-align: left;
  padding-left: 25px;
  vertical-align: bottom;
  display: table-cell;
  line-height: 7px;
}
div.movie-item-text p {
    font-weight: bold;
    font-size: 25px;
    
}

div.movie-item-space {
  background-color: rgb(0, 0, 0);
  width: 100%;
  height: 10px;
}

div.line {
  background-color: white;
  width: 100%;
  height: 1px;
  margin-top: 10px;
}

img {
  width: 100px;
}
</style>