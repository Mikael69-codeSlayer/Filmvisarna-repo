<template>
<h1>Biljetter</h1>
<div>Boka dina biljetter idag</div>

<div v-for="show of showtime" :key="show.id">
  <h1>{{show.id}}</h1>

</div>

</template>


<script>
export default {
  
  data() {
    return {
      films:'',
      date:'',
      noDuplicates:'',
    }
  },

  computed: {
    filmer() {
      return this.$store.state.filmer.filter((filmer) => filmer.id == this.id);
    },
   showtime() {
     return this.$store.state.showtime.filter(
        (showtime) => showtime.id == this.id
      );
    },
    id() {
      // get id from url parameter
      return this.$route.params.id;
    },
    sortedShows(){
      //This removes all "-" in dates
      for (let show of this.showtime){
        if(show.date.includes("-")){
          show.date = show.date.replaceAll("-","")
          //console.log(show.date)
        }

      }
      //This sorts showtimes dates in order
      this.showtime.sort((a, b) => a.date - b.date );
      //console.log(this.showtime)

      //This adds "-" between year-month and month-day 
      for(let show of this.showtime){
        if(show.date.includes(2021)){
          show.date=show.date.replace("2021", "2021-")
        }
        if(show.date.includes(2021)){
          show.date=show.date.replace("-02", "-02-")
        }
        //console.log(show.date)
      }
      console.log(this.showtime)

      //THIS IS THE SORTING OF DATE
      //   let noDuplicates = []
      
      //     this.showtime.forEach(remove => {
      //         if(!noDuplicates.includes(remove.date)){
      //             noDuplicates.push(remove.date)
      //         }
      //     })  
      
      // console.log(noDuplicates)
      // this.showtime=this.noDuplicates;
      return this.showtime;
      /*
      let shows = this.$store.state.showtime.sort((a, b) => a.date - b.date );
      console.log("Detta är shows" + shows)
      return shows;*/
    }
  },
  

  methods:{
    selectFilm(){
      console.log(this.showtime)

    },
    sortJASON(){

      console.log("JASON")
        return this.showtime.sort((a, b) => a.showId - b.showId );
  }
    
  },

}


</script>

<style scoped>
/*Test
IMPORTANT! Don't forget to use 'scoped'
otherwise all changes will effect other files
*/ 

</style>