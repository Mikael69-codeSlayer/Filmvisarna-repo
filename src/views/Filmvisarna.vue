<!--   HTML  -->
<template>
<div class="home">
    <div class=aktuellt-container>

        <p class="aktuellt-title">Aktuellt på bio</p>

             <div class="aktuellt-poster" 
             v-for="film of filmer" 
             :key="film.id">

             <div v-if="film.id == 4">
         <router-link :to="'/filmerDetails/' + film.id">
                   <img :src="film.images[1]">
         </router-link>
                     

             </div>
            </div>

    </div>
     <div class="paBio">
        <h1>{{ msg }}</h1>
        <div class="filmDiv"
        v-for="film of filmer" 
        :key="film.id"
        >
        <router-link :to="'/filmerDetails/' + film.id">
                <img :src="film.posterUrl">
                
        </router-link>
        <p>{{ film.title }}</p>
    </div>
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
    name: 'home',
    data(){
        return {
            msg: 'På bio nu',
            posterUrl:""
        }
    }, 
    computed: {
      filmer() {
        return this.$store.state.filmer
      }
    }
    
};
</script>

<!--- CSS  --->
<style scoped>
/*
IMPORTANT! Don't forget to use 'scoped'
otherwise all changes will effect other files
*/
.filmDiv{
    display: inline-block
}
img{
    width: 200px;
}
div.aktuellt-container {
    background-color: rgb(105, 84, 105);
    padding: 120px;
}
p.aktuellt-title {
    color: white;
    padding-right: 780px;
}

.aktuellt-poster img {
   width: 400px;
}

</style>