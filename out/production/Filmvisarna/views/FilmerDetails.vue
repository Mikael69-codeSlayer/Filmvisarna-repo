<template>
  <!-- It works. 
  We added v-for to loop through films like we did in 'Filmvisarna.vue'
  and v-if to choose which poster should be displayed. -->
  <div class="detail-container" v-for="film of filmer" :key="film.id">
    <div v-if="film.id == 1">
      <!-- <img :src="film.images[1]"> -->
    </div>
    <div class="movie-container">
      <div class="gradient-background"></div>

      <!-- <div class="trailer-button-container">
       <button class="trailer-button" @click="">Play</button> 
      </div> -->

      <div class="detail-posters">
        <img :src="film.posterUrl" />

        <div class="detail-text">
          <h1>{{ film.title }}</h1>
          <br />
          <p>{{ film.genre }} | {{ film.length }} min</p>

          <div class="trailer-button-container">
            <router-link :to="'/biljetter/'" >  
            <button class="trailer-button">Biljetter</button>
           </router-link>
           <!-- <button class="trailer-button" @click="ticketButton()">Biljetter</button>-->
          </div>
        </div>
      </div>
    </div>

    <div class="movie-info-container">
      <div class="movie-description">
        <p>{{ film.description }}</p>
      </div>

      <div class="movie-director">
        <p>Regi:<br />{{ film.director }}</p>
      </div>

      <div class="movie-actors">
        <p>Skådespelare:<br />{{ film.actors }}</p>
      </div>

      <div class="movie-language">
        <p>Originalspråk:<br />{{ film.language }}</p>
      </div>

      <div class="movie-year">
        <p>Utgivningsår:<br />{{ film.productionYear }}</p>
      </div>

      <div class="trailer-video">
        <section>
          <iframe
            width="560"
            height="315"
            :src="film.youtubeTrailers"
            frameborder="0"
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
            allowfullscreen
          ></iframe>
        </section>
      </div>
    </div>
  </div>
</template>

<script>
import BiljetterVue from '../../out/production/Filmvisarna/views/Biljetter.vue';
export default {
  computed: {
    filmer() {
      // Also added this, to get filmes and id
      return this.$store.state.filmer.filter((filmer) => filmer.id == this.id);
    },
    id() {
      // get id from url parameter
      return this.$route.params.id;
    },
  },
  /*
  methods: {
    ticketButton: function() {
      window.open("/biljetter", "_self")
    }
  },*/
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

.trailer-button {
   background-color: rgba(220, 20, 60, 0.877);  
   font-size: 1.2em;
   color: white;
   padding: 5px 15px 5px;
  
   border: 1px solid red;
   cursor: pointer;
}

.trailer-button:hover {
  background-color: rgba(250, 82, 82, 0.787);
}

div.detail-container {
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
  background-image: url("https://variety.com/wp-content/uploads/2020/10/borat-subsequent-moviefilm-Borat_Subsequent_Moviefilm_00038_V2_rgb.jpg");
  position: relative;
  background-repeat: no-repeat;
  background-size: cover;
}

div.gradient-background {
  width: 100%;
  height: 200px;
  position: absolute;
  top: 500px;
  left: 0;
  z-index: 10;
  background-image: linear-gradient(rgba(0, 0, 0, 0), rgb(0, 0, 0));
}

.detail-posters img {
  width: 200px;
  z-index: 10;
  position: relative;
}

.detail-posters {
  background-color: rgba(139, 225, 230, 0);
  width: 700px;
  margin: 0 auto;
  text-align: left;
  z-index: 10;
  position: relative;
}

div.movie-info-container {
  height: 500px;
  text-align: center;
  font-family: "Roboto Slab", serif;
  color: white;
  padding-top: 30px;
  position: absolute;

  /*background-image: linear-gradient(rgb(0, 0, 0), rgba(24, 156, 179, 0.192));*/
}

div.movie-description {
  width: 37%;
  margin: 0 auto;
  text-align: left;
}

div.movie-director {
  width: 37%;
  margin: 0 auto;
  text-align: left;
}

div.movie-actors {
  width: 37%;
  margin: 0 auto;
  text-align: left;
}

div.movie-language {
  width: 37%;
  margin: 0 auto;
  text-align: left;
}

div.movie-year {
  width: 37%;
  margin: 0 auto;
  text-align: left;
}

div.trailer-video {
  margin-top: 150px;
}
</style> 