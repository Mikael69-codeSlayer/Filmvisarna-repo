<template>
  <h1>Filmer</h1>
  <h3>Param: {{ id }}</h3>
   
        
      <!--    <div class="movie-details">
            <div class="movie-details-poster">
              <img :src="film.posterUrl" />
            </div>

            <div class="movie-item-text">
              <p>{{ film.title }}</p> <br />
              {{ film.genre }} 
              | {{ film.length }} min
              | {{ film.language }}
            </div>
          </div> -->
 
 
      
       

</template>

<script>
export default {
  computed: {
    id() {
      // get id from url parameter
      return this.$route.params.id;
    },
  },
};
</script>

<style scoped>
</style> 