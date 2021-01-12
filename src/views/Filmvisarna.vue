<!--   HTML  -->
<template>
<div class="home">
    <h1>Homepage</h1>
    <h1>{{msg}}</h1>
</div>
</template>

<!--  JavaScript (Vue.js)   -->
<script>
export default {
    name: 'home',
    data(){
        return{
            msg: 'Detta är ett test'
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