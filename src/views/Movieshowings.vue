<template>
  <h1>Biljetter</h1>
  <div id="subtitle">Boka dina biljetter idag</div>
  <div v-if="film" class="movie-list">
    <div class="movie-item-poster">
      <img :src="film.posterUrl" />
    </div>
    </div>
      <div class="film-title"> {{ film.title }} </div>
    <div class="header-container">
       <div class="header-date"> Datum </div>
          <div class="header-time"> Tid </div>
          <div class="header-salon"> Salong </div>
          <div class="header-seats"> Lediga säten </div>
         <div class="header-empty"></div>
    </div>
    <div class="showings-container">
      <div v-for="show of sortedShows" :key="show.id">
        <div class="showings" v-if="isLoggedIn">
          <div class="show-date">{{ show.date }}</div>
          <div class="show-time">{{ show.time }}</div>
          <div class="show-salon">{{ show.salon }}</div>
          <div class="show-seats"> {{ show.availableSeats }}</div>
          <router-link :to="'/tickets/' + show.id">
            <button class="ticket-button">Biljetter</button>
          </router-link>
        </div>
        
        <div class="showings" v-else>
          <div class="show-date">{{ show.date }}</div>
          <div class="show-time">{{ show.time }}</div>
          <div class="show-salon">{{ show.salon }}</div>
          <div class="show-seats"> {{ show.availableSeats }}</div>
          <router-link :to="'/tickets/' + show.id">
            <button class="ticket-button">Biljetter</button>
          </router-link>
        </div>
      </div>
    </div>
    <div class="empty-space" style="height: 100px"></div>
 
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
      return this.$store.state.filmer.filter(
        (filmer) => filmer.id == this.id
      )[0];
      // this.id)[0]; alltid en stor vilket blir retunerad
      //array[0]
    },
    userLoggedIn() {
      return this.$store.state.user == null;
    },
    isLoggedIn() {
      return this.$store.state.user != null;
    },

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
        }
      }
      //This sorts showtimes dates in order
      this.showtime.sort((a, b) => a.date - b.date);

      //This adds "-" between year-month and month-day
      for (let show of this.showtime) {
        if (show.date.includes(2021)) {
          show.date = show.date.replace("2021", "2021-");
        }
        if (show.date.includes(2021)) {
          show.date = show.date.replace("-02", "-02-");
        }
      }

      return this.showtime;
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
  height: 450px;
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
  width: 200px;
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  margin: auto;
}
.showings {
  background-color: rgba(58, 58, 58, 0.281);
   padding:10px;    
}
div > p {
  color: whitesmoke;
}
#subtitle {
  color: whitesmoke;
}
.showings-container {
width: 700px;
  margin: auto;

}

.ticket-button {
  background-color: rgba(220, 20, 60, 0.877);
  cursor: pointer;
  padding: 6px 8px;
  border: 1px solid rgba(245, 245, 245, 0.424);
  border-radius: 3px;
  align-items: center;
}

.show-date {
  float: left;
  margin: 0 auto;
  font-family: "Roboto Slab", serif;
  font-size: 16px;
  color: whitesmoke;
  width: 100px;
}
.show-time {
  float: left;
  margin: 0 auto;
  font-family: "Roboto Slab", serif;
  font-size: 16px;
  color: rgba(245, 245, 245, 0.637);
    width: 150px;

}
.show-salon {
  float: left;
  margin: 0 auto;
  font-family: "Roboto Slab", serif;
  font-size: 16px;
  color: rgba(245, 245, 245, 0.637);
  width: 150px;
  text-align: left;
  margin-left: 20px;
}
.show-seats {
  float: left;
  margin: 0 auto;
  font-family: "Roboto Slab", serif;
  font-size: 16px;
  color: rgba(245, 245, 245, 0.637);
  padding-left: 10px;
  width: 100px;
}

.header-date {
   padding-left: 5px;
  float: left;
  margin: 0 auto;
  font-family: "Roboto Slab", serif;
  font-size: 16px;
  color: whitesmoke;
  width: 100px;
height: 30px;
  background-color: rgba(245, 245, 245, 0.157);
  line-height: 30px;
}

.header-time {
  padding-left: 3px;
  float: left;
  margin: 0 auto;
  font-family: "Roboto Slab", serif;
  font-size: 16px;
  color: whitesmoke;
 width: 150px;
 height: 30px;
  background-color: rgba(245, 245, 245, 0.157);
  line-height: 30px;
}

.header-salon {
  float: left;
  margin: 0 auto;
  font-family: "Roboto Slab", serif;
  font-size: 16px;
  color: whitesmoke;
  width: 150px;
  text-align: center;
 height: 30px;
  background-color: rgba(245, 245, 245, 0.157);
  line-height: 30px;
  

}

.header-seats {
  float: left;
  margin: 0 auto;
  font-family: "Roboto Slab", serif;
  font-size: 16px;
  color: whitesmoke;
  width: 170px;
  text-align: center;
 height: 30px;
  
  background-color: rgba(245, 245, 245, 0.157);
  line-height: 30px;
}

.header-container {
  width: 700px;
  margin: auto;
  height: 35px;
}

.header-empty {
  height: 30px;
  width: 122px;
  float: left;
  margin: 0 auto;
background-color: rgba(245, 245, 245, 0.157);
}

.film-title {
  height: 100px;
  font-family: "Roboto Slab", serif;
  font-size: 35px;
  color: whitesmoke;
}

</style>