<!--   HTML  -->
<template>
<div class="home">
    <h1>Homepage</h1>
    <h1>{{msg}}</h1>
    <h1>{{posterUrl}}</h1>
</div>
</template>

<!--  JavaScript (Vue.js)   -->
<script>
export default {
    name: 'home',
    data(){
        return {
            msg: 'Detta är ett test',
            posterUrl:"https://images.moviesanywhere.com/ae548928d15ceddbb6e1a6d16707fafd/8f079b10-aff5-4f2b-82f0-789ae7fedaea.jpg"
        }
    },
    
 
};
</script>

<!--- CSS  --->
<style scoped>
    
/*
IMPORTANT! Don't forget to use 'scoped'
otherwise all changes will effect other files
*/
</style>