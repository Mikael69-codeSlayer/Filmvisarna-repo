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

          <div class="ticket-button-container">
            <router-link :to="'/movieshowings/' +film.id">
              <button class="ticket-button">Biljetter</button>
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

      <!-------------------------------------- Carousel ------------------------------------>
      <div class="screen-container">
        <section id="screen">
          <div class="container">
            <div class="carousel">
              <input
                type="radio"
                name="slides"
                checked="checked"
                id="slide-1"
              />
              <input type="radio" name="slides" id="slide-2" />
              <input type="radio" name="slides" id="slide-3" />
              <input type="radio" name="slides" id="slide-4" />
              <ul class="carousel__slides">
                <li class="carousel__slide">
                  <figure>
                    <div>
                      <img :src="film.images[0]" alt="" />
                    </div>
                  </figure>
                </li>

                <li class="carousel__slide">
                  <figure>
                    <div>
                      <img :src="film.images[1]" alt="" />
                    </div>
                  </figure>
                </li>
                <li class="carousel__slide">
                  <figure>
                    <div>
                      <img :src="film.images[2]" alt="" />
                    </div>
                  </figure>
                </li>
                <li class="carousel__slide">
                  <figure>
                    <div>
                      <img :src="film.images[3]" alt="" />
                    </div>
                  </figure>
                </li>
              </ul>
              <ul class="carousel__thumbnails">
                <li>
                  <label for="slide-1"
                    ><img :src="film.images[0]" alt=""
                  /></label>
                </li>
                <li>
                  <label for="slide-2"
                    ><img :src="film.images[1]" alt=""
                  /></label>
                </li>
                <li>
                  <label for="slide-3">
                    <img :src="film.images[2]" alt=""
                  /></label>
                </li>
                <li>
                  <label for="slide-4">
                    <img :src="film.images[3]" alt=""
                  /></label>
                </li>
              </ul>
            </div>
          </div>
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
export default {
  computed: {
    filmer() {
      // Also added this, to get filmes and id
      return this.$store.state.filmer.filter((filmer) => filmer.id == this.id);
    },
    images() {
      return this.$store.state.images.filter((images) => images.id == this.id);
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
  },
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

.ticket-button {
  background-color: rgba(220, 20, 60, 0.877);
  font-size: 1.2em;
  color: white;
  padding: 5px 15px 5px;

  border: 1px solid red;
  cursor: pointer;
}

.ticket-button:hover {
  background-color: rgba(250, 82, 82, 0.787);
}

div.detail-container {
  height: 600px;
  width: 100%;
}

div.movie-container {
  background-color: rgba(137, 43, 226, 0);
  padding-top: 400px;
  position: relative;
  background-repeat: no-repeat;
  background-size: cover;
}

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
  background-color: black;

  width: 1000px;
  margin: 0 auto;
}

div.trailer-video {
  margin-top: 150px;
}

/** ----------------------- Carousel ------------------------**/

#section.screen {
  background: #f4f4f4;
  padding: 50px 0;
  width: 850px;
}
.container {
  max-width: 1500px;
  width: 800px;
  margin: 0 auto;
  padding: 0 20px;
}
.carousel {
  display: block;
  text-align: left;
  position: relative;
  margin-bottom: 22px;
}
.carousel > input {
  clip: rect(1px, 1px, 1px, 1px);
  clip-path: inset(50%);
  height: 1px;
  width: 1px;
  margin: -1px;
  overflow: hidden;
  padding: 0;
  position: absolute;
}

.carousel
  > input:nth-of-type(4):checked
  ~ .carousel__slides
  .carousel__slide:first-of-type {
  margin-left: -300%;
}
.carousel
  > input:nth-of-type(3):checked
  ~ .carousel__slides
  .carousel__slide:first-of-type {
  margin-left: -200%;
}
.carousel
  > input:nth-of-type(2):checked
  ~ .carousel__slides
  .carousel__slide:first-of-type {
  margin-left: -100%;
}
.carousel
  > input:nth-of-type(1):checked
  ~ .carousel__slides
  .carousel__slide:first-of-type {
  margin-left: 0%;
}
.carousel
  > input:nth-of-type(1):checked
  ~ .carousel__thumbnails
  li:nth-of-type(1) {
  box-shadow: 0px 0px 0px 3px whitesmoke;
}
.carousel
  > input:nth-of-type(2):checked
  ~ .carousel__thumbnails
  li:nth-of-type(2) {
  box-shadow: 0px 0px 0px 3px whitesmoke;
}
.carousel
  > input:nth-of-type(3):checked
  ~ .carousel__thumbnails
  li:nth-of-type(3) {
  box-shadow: 0px 0px 0px 3px whitesmoke;
}
.carousel
  > input:nth-of-type(4):checked
  ~ .carousel__thumbnails
  li:nth-of-type(4) {
  box-shadow: 0px 0px 0px 3px whitesmoke;
}

.carousel__slides {
  position: relative;
  z-index: 1;
  padding: 0;
  margin: 0;
  overflow: hidden;
  white-space: nowrap;
  box-sizing: border-box;
  display: flex;
}
.carousel__slide {
  position: relative;
  display: block;
  flex: 1 0 100%;
  width: 100%;
  height: 100%;
  overflow: hidden;
  transition: all 300ms ease-out;
  vertical-align: top;
  box-sizing: border-box;
  white-space: normal;
}
.carousel__slide figure {
  display: flex;
  margin: 0;
}
.carousel__slide div {
  position: relative;
  width: 100%;
}
.carousel__slide div:before {
  display: block;
  content: "";
  width: 100%;
  padding-top: 66.6666666667%;
}
.carousel__slide div > img {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  width: 100%;
  height: 100%;
}
.carousel__slide img {
  display: block;
  flex: 1 1 auto;
  object-fit: cover;
}

.carousel__slide .credit {
  margin-top: 1rem;
  color: rgba(0, 0, 0, 0.5);
  display: block;
}
.carousel__slide.scrollable {
  overflow-y: scroll;
}
.carousel__thumbnails {
  list-style: none;
  padding: 0;
  margin: 0;
  display: flex;
  margin: 0 -10px;
}
.carousel__slides + .carousel__thumbnails {
  margin-top: 20px;
}
.carousel__thumbnails li {
  flex: 1 1 auto;
  max-width: calc((100% / 6) - 20px);
  margin: 0 10px;
  transition: all 300ms ease-in-out;
}
.carousel__thumbnails label {
  display: block;
  position: relative;
}
.carousel__thumbnails label:before {
  display: block;
  content: "";
  width: 100%;
  padding-top: 100%;
}
.carousel__thumbnails label > img {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  width: 100%;
  height: 100%;
}
.carousel__thumbnails label:hover,
.carousel__thumbnails label:focus {
  cursor: pointer;
}
.carousel__thumbnails label:hover img,
.carousel__thumbnails label:focus img {
  box-shadow: 0px 0px 0px 1px rgba(0, 0, 0, 0.25);
  transition: all 300ms ease-in-out;
}
.carousel__thumbnails img {
  display: block;
  width: 100%;
  height: 100%;
  object-fit: cover;
}
</style> 