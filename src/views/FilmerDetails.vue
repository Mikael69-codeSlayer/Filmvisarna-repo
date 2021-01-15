<template>
  
  <!-- It works. 
  We added v-for to loop through films like we did in 'Filmvisarna.vue'
  and v-if to choose which poster should be displayed. -->
<div class="detail-container">
  
  <div class="detail-posters" v-for="film of filmer" :key="film.id">
    <div v-if="film.id == 1">
       </div>
      <img :src="film.posterUrl" />
      <div class="detail-text">
      <p>{{ film.title }}</p> <br />
              {{ film.genre }} 
              | {{ film.length }} min
              | {{ film.language }}
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
    },
  },
};
</script>

<style scoped>

div.detail-container {
  background-color: blueviolet;
  margin: 0 auto;
}

.detail-posters img {
  width: 200px;

}

div.detail-text {
  background-color: bisque;
  width: 300px;
  float: right;
  margin-right: 185px;
  margin-top: 205px;
}

.detail-posters {
  background-color: cadetblue;
  width: 700px;
  margin: 0 auto;
  text-align: left;
}


</style> 