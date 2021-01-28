<template>
  <h1>Biljetter</h1>
  <div>Boka dina biljetter idag</div>
  <!--
<div v-for="show of sortedShows" :key="show.id">
  <h1>TEST</h1>
  <h1>{{show.id}}</h1>
</div>
-->
  <div v-if="film" class="movie-list">
      <div class="movie-item">
        <div class="movie-item-poster">
          <img :src="film.posterUrl" />
        </div>
    </div>
    <!-- <div v-for="film of filmer" :key="film.id">
     <h1>{{ film.title }}</h1> 
    </div> -->
    <div v-for="show of showtime" :key="show.id">
      <h1>{{ show.date }}</h1>
      <div></div>
    </div>
  </div>
</template>


<script>
export default {
  data() {
    return {
      films: "",
      date: "",
      noDuplicates: "",
    };
  },

  computed: {
    id() {
      // get id from url parameter
      return this.$route.params.id;
    },
    film() {
      // Also added this, to get filmes and id
      return this.$store.state.filmer.filter((filmer) => filmer.id == this.id)[0];
      // this.id)[0]; alltid en stor vilket blir retunerad 
      //array[0]
    },
    // images() {
    //   return this.$store.state.images.filter((images) => images.id == this.id);
    // },
    showtime() {
      return this.$store.state.showtime.filter(
        (showtime) => showtime.film == this.film.title
      );
    },
    sortedShows() {
      //This removes all "-" in dates
      for (let show of this.showtime) {
        if (show.date.includes("-")) {
          show.date = show.date.replaceAll("-", "");
          //console.log(show.date)
        }
      }
      //This sorts showtimes dates in order
      this.showtime.sort((a, b) => a.date - b.date);
      //console.log(this.showtime)

      //This adds "-" between year-month and month-day
      for (let show of this.showtime) {
        if (show.date.includes(2021)) {
          show.date = show.date.replace("2021", "2021-");
        }
        if (show.date.includes(2021)) {
          show.date = show.date.replace("-02", "-02-");
        }
        //console.log(show.date)
      }
      console.log(this.showtime);

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
    },
  },

  methods: {
    selectFilm() {
      console.log(this.showtime);
    },
    sortJASON() {
      console.log("JASON");
      return this.showtime.sort((a, b) => a.showId - b.showId);
    },
  },
};
</script>

<style scoped>
/*Test
IMPORTANT! Don't forget to use 'scope'
otherwise all changes will effect other files
*/
h1 {
  font-family: "Roboto Slab", serif;
  text-align: center;
  color: whitesmoke;
  margin-top: 70px;
}

select {
  margin-top: 5px;
  text-align: center;
  border-radius: 2px;
  font-family: "Roboto Slab", serif;
  font-size: 16px;
  height: 30px;
  width: 250px;
  border-color: white;
  background-color: black;
  color: white;
}

div.filmdropdown {
  float: left;
  margin-left: 200px;
  margin-top: 50px;
  color: white;
}

div.datedropdown {
  float: left;
  margin-top: 50px;
  margin-left: 2px;
}

/* */

.space {
  width: 100%;
  height: 100px;
}

a {
  font-family: "Roboto Slab", serif;
  color: white;
  text-decoration: none !important;
}

.movie-title {
  font-size: 25px;
  font-weight: bold;
  line-height: 70px;
}

div.movies-container {
  color: white;
  width: 100%;
  position: relative;
  height: 500px;
  background: rgb(0, 0, 0);
  padding: 40px 0;
}

div.movies-header {
  background-color: rgb(0, 0, 0);
  width: 55%;
  margin: 0 auto;
  text-align: left;
  padding-left: 10px;
  padding-top: 5px;
}

h1.filmer-header {
  font-size: 25px;
  width: 980px;
  height: 42px;
  color: white;
  font: 36px;
  margin: 0 0 8px;
  padding: 0 84px 0px 0px;
}

div.movie-list {
  background-color: rgb(0, 0, 0);
  height: 1100px;
  width: 55%;
  margin: 0 auto;
  padding-left: 10px;
  padding-top: 5px;
}

div.movie-item {
  background-color: rgb(0, 0, 0);
  width: 100%;
  overflow: hidden;
  height: 140px;
}

div.movie-item-poster {
  background-color: rgb(0, 0, 0);
  width: 100px;
  height: 150px;
  float: left;
}

div.movie-item-text {
  background-color: rgb(0, 0, 0);
  display: inline-block;
  width: 40vw;
  height: 100px;
  text-align: left;
  padding-left: 25px;
  vertical-align: bottom;
  display: table-cell;
  line-height: 7px;
}
div.movie-item-text p {
  font-weight: bold;
  font-size: 25px;
}

div.movie-item-space {
  background-color: rgb(0, 0, 0);
  width: 100%;
  height: 10px;
}

div.line {
  background-color: white;
  width: 100%;
  height: 1px;
  margin-top: 10px;
}

img {
  width: 100px;
}
</style>