<template>
  <h1>Filmer</h1>

  <!-- It works, but it breaks when page is reloaded. 
  We added v-for to loop through films like we did in 'Filmvisarna.vue'
  and v-if to choose which poster should be displayed. -->

  <div class="detail-posters" v-for="film of filmer" :key="film.id">
    <div v-if="film.id == 1">
      <img :src="film.posterUrl" />
      <p>{{ film.title }}</p>
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
.detail-posters img {
  width: 200px;
}
</style> 