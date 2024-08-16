<template>
  <section id="hero-section">
    <div id="hero-img">
      <img src="../assets/img/view-3d-video-game-controller.png" alt="header-background">
    </div>
    <div id="hero-text">
      <h1 class="press-start-2p-regular">Welcome to PlayQ</h1>

      <div>
        <h2>Track the games you own, games you wish to play, and games you wish to tackle in the future.</h2>
        <router-link v-bind:to="{ name: 'register' }"><button class="primary">Sign Up</button></router-link>
      </div>
    </div>
  </section>



  <div id="main-content">
    <section id="how-it-works-section">

      <div id="how-it-works-area">
        <h2>Game management made simple so you spend less time deciding and more time gaming. </h2>

        <div class="how-it-works-content">

          <div class="how-it-works-text-container">
            <h3>Collection</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore
              et dolore magna aliqua.</p>
          </div>

          <div class="how-it-works-image-container">
            <img src="../assets/img/stylized_fun_3d_render_of_a_gaming_headset._simple_style-removebg-preview.png" alt="">
          </div>
        </div>

        <div class="how-it-works-content">
          <div class="how-it-works-image-container">
            <img
              src="../assets/img/stylized_fun_3d_render_of_a_retro_style_game_controller._directional_pad_on_left_side_and_4_b_1-removebg-preview.png"
              alt="">
          </div>
          <div class="how-it-works-text-container">
            <h3>Backlog</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do incididunt ut labore
              et dolore magna aliqua.</p>
          </div>
        </div>

        <div class="how-it-works-content">
          <div class="how-it-works-text-container">
            <h3>Heading</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod.</p>
          </div>

          <div class="how-it-works-image-container">
            <img
              src="../assets/img/stylized_fun_3d_render_of_a_retro_style_game_controller._directional_pad_on_left_side_and_4_b_2-removebg-preview.png"
              alt="">
          </div>
        </div>
      </div>
    </section>
  </div>

  <section id="extra-section">
    <div>
      <h2 class="press-start-2p-regular">Thanks for visiting!</h2>
    </div>
  </section>
</template>

<script>

export default {
  data() {
    return {

    }
  },

}

</script>

<style scoped>
section {
  margin: 0 auto;
}

#main-content {
  background-image: linear-gradient(rgba(45, 33, 101, 0.8), rgba(41, 21, 74, 0.8)), url('../assets/img/george-flowers-blYe0BupDuQ-unsplash.jpg');
  background-size: cover;
  background-position: top;
  background-repeat: no-repeat;
  background-attachment: fixed;
}

/* ----------------------  HERO SECTION  ---------------------- */
#hero-section {
  background-image: linear-gradient(rgba(56, 31, 138, 0.9), rgba(140, 64, 191, 0.8)), url('../assets/img/lorenzo-herrera-p0j-mE6mGo4-unsplash.jpg');
  width: 100%;
  max-width: none;
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  background-attachment: fixed;

  background-color: #1b1625;
  display: flex;
  justify-content: center;
  color: white;
  border: none;
  box-shadow: none;
  border-radius: 0;
  padding: 5rem 10rem;
}

#hero-text {
  display: flex;
  flex-direction: column;
  justify-content: center;
  width: 50%;
}

#hero-img {
  width: 500px;
  display: flex;
  align-items: center;
}

#hero-img img {
  width: 100%;
}

#hero-section button {
  font-size: 1.1rem;
  padding: 10px 20px;
}

#hero-section button:hover {
  animation: shake 0.3s;
}

@keyframes shake {
  0% {
    transform: rotate(0deg);
  }
  20% {
    transform: rotate(-4deg);
  }
  50% {
    transform: rotate(0deg);
  }
  70% {
    transform: rotate(4deg);
  }
  100% {
    transform: rotate(0deg);
  }
}


/* ----------------------  HOW IT WORKS SECTION  ---------------------- */
#how-it-works-area {
  /* background-image: linear-gradient(rgba(24, 13, 58, 0.9), rgba(19, 14, 34, 0.9)), url('../assets/img/george-flowers-blYe0BupDuQ-unsplash.jpg'); */
  background-color: rgba(5, 5, 41, 0.6);
  /* background-size: cover;
  background-position: top;
  background-repeat: no-repeat;
  background-attachment: fixed; */
  color: white;
  padding: 30px;
  border-radius: 10px;
}

#how-it-works-area>h2 {
  font-size: 2.0rem;
  width: 75%;
  text-align: center;
  margin: 70px auto;
  color: rgb(57, 213, 249)
}

.how-it-works-content {
  display: flex;
  justify-content: space-evenly;
  align-items: center;
}

.how-it-works-text-container {
  width: 50%;
}

.how-it-works-image-container {
  width: 30%;
  text-align: center;
}

.how-it-works-image-container img {
  width: 70%;
}

#how-it-works-area p {
  font-size: 1.5rem;
  line-height: 2.1rem;
  /* margin-bottom: 1rem; */
}

.how-it-works-text-container p {
  font-size: 19rem;
}

.how-it-works-content h3 {
  font-size: 1.8rem;
  color: orange;
}

/* ----------------------  THANKS FOR VISITING SECTION  ---------------------- */
#extra-section {
  /* background-image: linear-gradient(rgba(14, 5, 46, 0.8), rgba(7, 3, 19, 0.8)), url('../assets/img/pxfuel.jpg'); */
  width: 100%;
  max-width: none;
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  /* background-attachment: fixed; */
  background-color: #1d1448;
  display: flex;
  justify-content: center;
  color: white;
  margin-bottom: 0;
  border-radius: 0;
  padding: 2.5rem 10rem;
}

/* ---------------------------------  MOBILE SETTINGS  --------------------------------- */
@media only screen and (max-width: 425px) {

  #hero-section {
    padding: 20px;
    flex-direction: column;
  }

  #hero-img {
    display: none;
  }


  #hero-section {
    padding: 1.5rem;
  }

  #hero-text {
    width: 100%;
  }

  #hero-img {
    width: 100%;
    display: none;
  }

  #how-it-works-section {
    padding: 0;
  }

  #how-it-works-header {
    margin-left: 10px;
  }

  #how-it-works-section:first-child {
    margin-left: 10px;
    border: 1px blue solid;
  }

  #how-it-works-area {
    border-radius: 0;
  }

  #how-it-works-area>h2 {
    font-size: 1.5rem;
    width: 100%;
    text-align: center;
    margin: 10px auto;
    color: rgb(57, 213, 249);
  }

  .how-it-works-text-container {
    width: 100%;
  }

  .how-it-works-image-container {
    display: none;
  }

  .how-it-works-content h3 {
    font-size: 1.3rem;
  }

  #how-it-works-area p {
    font-size: 1rem;
    line-height: 1.5rem;
  }

}
</style>