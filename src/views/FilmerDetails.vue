<template>
  <!-- It works. 
  We added v-for to loop through films like we did in 'Filmvisarna.vue'
  and v-if to choose which poster should be displayed. -->
  <div class="detail-container" v-for="film of filmer" :key="film.id">
      <div v-if="film.id == 1">
       
       <!-- <img :src="film.images[1]"> -->
         
    </div>
  <div class="movie-container">
    <div class="detail-posters">
        <img :src="film.posterUrl" />
        <div class="detail-text">
          <h1>{{ film.title }}</h1>
          <br />
          <p>{{ film.genre }}
          | {{ film.length }} min</p>
        </div>
      </div>
    </div>
  </div>
  
</template>

<script>
export default {
  computed: {
    filmer() {
      // Also added this, to get filmes and id
      return this.$store.state.filmer.filter((filmer) => filmer.id == this.id);
    },
    id() {
      // get id from url parameter
      return this.$route.params.id;
    }
  }
};
</script>

<style scoped>


div.detail-text {
  background-color: rgba(93, 218, 93, 0);
  width: 400px;
  float: right;
  margin-right: 80px;
  margin-top: 190px;
}

div.detail-text h1 {
    font-weight: bold;
    font-size: 1.6em;
    line-height: 2px;
    color: white;
}

div.detail-text p {
    line-height: 2px;
    color: white;
    font-size: 1em;
}


div.detail-container {
  background-color: rgb(141, 106, 42);
  height: 600px;
  width: 100%;
  
}


/*div.inner-background img{
  background-color: orange;
  width: 100%;
  z-index: -1;
  overflow: hidden;
}*/

div.movie-container {
  background-color: blueviolet;
  padding-top: 400px;
  background-image: url('https://variety.com/wp-content/uploads/2020/10/borat-subsequent-moviefilm-Borat_Subsequent_Moviefilm_00038_V2_rgb.jpg');
  position: relative;
  background-repeat: no-repeat;
  background-size: cover;
}

.detail-posters img {
  width: 200px;
}



.detail-posters {
  background-color: rgba(139, 225, 230, 0);
  width: 700px;
  margin: 0 auto;
  text-align: left;
}
</style> 