<template>
  <!-- It works. 
  We added v-for to loop through films like we did in 'Filmvisarna.vue'
  and v-if to choose which poster should be displayed. -->
  <div class="detail-container" v-for="film of filmer" :key="film.id">
    <div
      class="movie-container"
      v-bind:style="{ 'background-image': 'url(' + film.backgroundImage + ')' }"
    >
      <div class="gradient-background"></div>

      <div class="detail-posters">
        <img :src="film.posterUrl" />

        <div class="detail-text">
          <h1>{{ film.title }}</h1>
          <br />
          <p>{{ film.genre }} | {{ film.length }} min</p>

          <div class="trailer-button-container">
            <router-link :to="'/biljetter/'">
              <button class="trailer-button">Biljetter</button>
            </router-link>
          </div>
        </div>
      </div>
    </div>

    <div class="movie-info-container">
      <div class="movie-description">
        <p>{{ film.description }}</p>
      </div>

      <div class="movie-director">
        <p>Regi:<br />{{ film.director }}</p>
      </div>

      <div class="movie-actors">
        <p>Skådespelare:<br />{{ film.actors }}</p>
      </div>

      <div class="movie-language">
        <p>Originalspråk:<br />{{ film.language }}</p>
      </div>

      <div class="movie-year">
        <p>Utgivningsår:<br />{{ film.productionYear }}</p>
      </div>

      <div class="screen-container">
        
        <!------- Vueper Slides (Carousel) ------>
     <!-------  // ! Commented out Vueper Slides
     <vueper-slides fade :touchable="false">
          <vueper-slide
            v-for="(slide, i) in slides"
            :key="i"
            :image="slide.image"
            :title="slide.title"
            :content="slide.content"
          />
        </vueper-slides> ------>
     
       <section class="carousel" aria-label="Gallery">
  <ol class="carousel__viewport">
    <li id="carousel__slide1"
        tabindex="0"
        class="carousel__slide">
        <img :src="film.images[0]" />
      <div class="carousel__snapper">
        <a href="#carousel__slide4"
           class="carousel__prev">Go to last slide</a>
        <a href="#carousel__slide2"
           class="carousel__next">Go to next slide</a>
      </div>
    </li>
    <li id="carousel__slide2"
        tabindex="0"
        class="carousel__slide">
      <div class="carousel__snapper"></div>
      <a href="#carousel__slide1"
         class="carousel__prev">Go to previous slide</a>
      <a href="#carousel__slide3"
         class="carousel__next">Go to next slide</a>
    </li>
    <li id="carousel__slide3"
        tabindex="0"
        class="carousel__slide">
      <div class="carousel__snapper"></div>
      <a href="#carousel__slide2"
         class="carousel__prev">Go to previous slide</a>
      <a href="#carousel__slide4"
         class="carousel__next">Go to next slide</a>
    </li>
    <li id="carousel__slide4"
        tabindex="0"
        class="carousel__slide">
      <div class="carousel__snapper"></div>
      <a href="#carousel__slide3"
         class="carousel__prev">Go to previous slide</a>
      <a href="#carousel__slide1"
         class="carousel__next">Go to first slide</a>
    </li>
  </ol>
  <aside class="carousel__navigation">
    <ol class="carousel__navigation-list">
      <li class="carousel__navigation-item">
        <a href="#carousel__slide1"
           class="carousel__navigation-button">Go to slide 1</a>
      </li>
      <li class="carousel__navigation-item">
        <a href="#carousel__slide2"
           class="carousel__navigation-button">Go to slide 2</a>
      </li>
      <li class="carousel__navigation-item">
        <a href="#carousel__slide3"
           class="carousel__navigation-button">Go to slide 3</a>
      </li>
      <li class="carousel__navigation-item">
        <a href="#carousel__slide4"
           class="carousel__navigation-button">Go to slide 4</a>
      </li>
    </ol>
  </aside>
</section>
     
     
     
      </div>

      <div class="trailer-video">
        <section>
          <iframe
            width="560"
            height="315"
            :src="film.youtubeTrailers"
            frameborder="0"
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
            allowfullscreen
          ></iframe>
        </section>
      </div>
    </div>
  </div>
</template>

<script>
// ! Commented out Vueper Slides
// Vueper Slides
//import { VueperSlides, VueperSlide } from "vueperslides";
//import "vueperslides/dist/vueperslides.css";

export default {
// ! Commented out data and Vueper Slides

  /*data: () => ({
    slides: [
      {
         title: 'El Teide Volcano, Spain',
    content: 'Photo by Max Rive',
    // You can also provide a URL for the image.
      image: 'https://variety.com/wp-content/uploads/2020/10/borat-subsequent-moviefilm-Borat_Subsequent_Moviefilm_00038_V2_rgb.jpg'
      },
       
       {

         image: ''
       }
       

    ],
    
  }), */

  components: {
    // ! Commented out Vueper Slides
    //VueperSlides,
    //VueperSlide,
  
  },

  computed: {
    filmer() {
      // Also added this, to get filmes and id
      return this.$store.state.filmer.filter((filmer) => filmer.id == this.id);
    },
    images() {
      return this.$store.state.images.filter((images) => images.id == this.id);
    },
    showtime() {
      return this$store.state.showtime.filter(
        (showtime) => showtime.id == this.id
      );
    },
    id() {
      // get id from url parameter
      return this.$route.params.id;
    },
  },
  /*
  methods: {
    ticketButton: function() {
      window.open("/biljetter", "_self")
    }
  },*/
};
</script>

<style scoped>
div.detail-text {
  background-color: rgba(93, 218, 93, 0);
  width: 400px;
  float: right;
  margin-right: 80px;
  margin-top: 190px;
}

div.detail-text h1 {
  font-weight: bold;
  font-size: 1.6em;
  line-height: 2px;
  color: white;
}

div.detail-text p {
  line-height: 2px;
  color: white;
  font-size: 1em;
}

.trailer-button {
  background-color: rgba(220, 20, 60, 0.877);
  font-size: 1.2em;
  color: white;
  padding: 5px 15px 5px;

  border: 1px solid red;
  cursor: pointer;
}

.trailer-button:hover {
  background-color: rgba(250, 82, 82, 0.787);
}

div.detail-container {
  height: 600px;
  width: 100%;
}

/*div.inner-background img{
  background-color: orange;
  width: 100%;
  z-index: -1;
  overflow: hidden;
}*/

div.movie-container {
  background-color: rgba(137, 43, 226, 0);
  padding-top: 400px;
  /*background-image: url("https://images-ext-1.discordapp.net/external/AcVMep7nNKn5Ow9k52mTpBcZO33J9tI8SamJ0qz8IcQ/https/pics.filmaffinity.com/Blade_Runner-237438038-large.jpg?width=954&height=477");*/
  position: relative;
  background-repeat: no-repeat;
  background-size: cover;
}

/*.movie-container img {
  width: 100%;
}*/

div.gradient-background {
  width: 100%;
  height: 200px;
  position: absolute;
  top: 506px;
  left: 0;
  z-index: 10;
  background-image: linear-gradient(rgba(0, 0, 0, 0), rgb(0, 0, 0));
}

.detail-posters img {
  width: 200px;
  z-index: 10;
  position: relative;
}

.detail-posters {
  background-color: rgba(139, 225, 230, 0);
  width: 700px;
  margin: 0 auto;
  text-align: left;
  z-index: 10;
  position: relative;
}

div.movie-info-container {
  height: 500px;
  text-align: center;
  font-family: "Roboto Slab", serif;
  color: white;
  padding-top: 30px;
  position: absolute;

  /*background-image: linear-gradient(rgb(0, 0, 0), rgba(24, 156, 179, 0.192));*/
}

div.movie-description {
  width: 37%;
  margin: 0 auto;
  text-align: left;
}

div.movie-director {
  width: 37%;
  margin: 0 auto;
  text-align: left;
}

div.movie-actors {
  width: 37%;
  margin: 0 auto;
  text-align: left;
}

div.movie-language {
  width: 37%;
  margin: 0 auto;
  text-align: left;
}

div.movie-year {
  width: 37%;
  margin: 0 auto;
  text-align: left;
}

div.screen-container {
  background-color: rgba(119, 114, 114, 0.171);
  padding: 160px;
}

div.trailer-video {
  margin-top: 150px;
}






@keyframes tonext {
  75% {
    left: 0;
  }
  95% {
    left: 100%;
  }
  98% {
    left: 100%;
  }
  99% {
    left: 0;
  }
}

@keyframes tostart {
  75% {
    left: 0;
  }
  95% {
    left: -300%;
  }
  98% {
    left: -300%;
  }
  99% {
    left: 0;
  }
}

@keyframes snap {
  96% {
    scroll-snap-align: center;
  }
  97% {
    scroll-snap-align: none;
  }
  99% {
    scroll-snap-align: none;
  }
  100% {
    scroll-snap-align: center;
  }
}

body {
  max-width: 37.5rem;
  margin: 0 auto;
  padding: 0 1.25rem;
  font-family: 'Lato', sans-serif;
}

* {
  box-sizing: border-box;
  scrollbar-color: transparent transparent; /* thumb and track color */
  scrollbar-width: 0px;
}

*::-webkit-scrollbar {
  width: 0;
}

*::-webkit-scrollbar-track {
  background: transparent;
}

*::-webkit-scrollbar-thumb {
  background: transparent;
  border: none;
}

* {
  -ms-overflow-style: none;
}

ol, li {
  list-style: none;
  margin: 0;
  padding: 0;
}

.carousel {
  position: relative;
  padding-top: 75%;
  filter: drop-shadow(0 0 10px #0003);
  perspective: 100px;
}

.carousel__viewport {
  position: absolute;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  display: flex;
  overflow-x: scroll;
  counter-reset: item;
  scroll-behavior: smooth;
  scroll-snap-type: x mandatory;
}

.carousel__slide {
  position: relative;
  flex: 0 0 100%;
  width: 100%;
  background-color: #f99;
  counter-increment: item;
}

.carousel__slide:nth-child(even) {
  background-color: #99f;
}

.carousel__slide:before {
  content: counter(item);
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate3d(-50%,-40%,70px);
  color: #fff;
  font-size: 2em;
}

.carousel__snapper {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  scroll-snap-align: center;
}

@media (hover: hover) {
  .carousel__snapper {
    animation-name: tonext, snap;
    animation-timing-function: ease;
    animation-duration: 4s;
    animation-iteration-count: infinite;
  }

  .carousel__slide:last-child .carousel__snapper {
    animation-name: tostart, snap;
  }
}

@media (prefers-reduced-motion: reduce) {
  .carousel__snapper {
    animation-name: none;
  }
}

.carousel:hover .carousel__snapper,
.carousel:focus-within .carousel__snapper {
  animation-name: none;
}

.carousel__navigation {
  position: absolute;
  right: 0;
  bottom: 0;
  left: 0;
  text-align: center;
}

.carousel__navigation-list,
.carousel__navigation-item {
  display: inline-block;
}

.carousel__navigation-button {
  display: inline-block;
  width: 1.5rem;
  height: 1.5rem;
  background-color: #333;
  background-clip: content-box;
  border: 0.25rem solid transparent;
  border-radius: 50%;
  font-size: 0;
  transition: transform 0.1s;
}

.carousel::before,
.carousel::after,
.carousel__prev,
.carousel__next {
  position: absolute;
  top: 0;
  margin-top: 37.5%;
  width: 4rem;
  height: 4rem;
  transform: translateY(-50%);
  border-radius: 50%;
  font-size: 0;
  outline: 0;
}

.carousel::before,
.carousel__prev {
  left: -1rem;
}

.carousel::after,
.carousel__next {
  right: -1rem;
}

.carousel::before,
.carousel::after {
  content: '';
  z-index: 1;
  background-color: #333;
  background-size: 1.5rem 1.5rem;
  background-repeat: no-repeat;
  background-position: center center;
  color: #fff;
  font-size: 2.5rem;
  line-height: 4rem;
  text-align: center;
  pointer-events: none;
}

.carousel::before {
  background-image: url("data:image/svg+xml,%3Csvg viewBox='0 0 100 100' xmlns='http://www.w3.org/2000/svg'%3E%3Cpolygon points='0,50 80,100 80,0' fill='%23fff'/%3E%3C/svg%3E");
}

.carousel::after {
  background-image: url("data:image/svg+xml,%3Csvg viewBox='0 0 100 100' xmlns='http://www.w3.org/2000/svg'%3E%3Cpolygon points='100,50 20,100 20,0' fill='%23fff'/%3E%3C/svg%3E");
}
</style> 