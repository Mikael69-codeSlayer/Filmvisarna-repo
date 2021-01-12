<!--   HTML  -->
<template>
<div class="home">
    <h1>Homepage</h1>
    <div class="-paBio">
        <h1>{{ msg }}</h1>
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

</style>