<template>
  <section id="hero-section">
    <div id="hero-img">
      <img src="../assets/img/view-3d-video-game-controller.png" alt="header-background">
    </div>
    <div id="hero-text">
      <h1 class="press-start-2p-regular">Welcome to PlayQ</h1>

      <div>
        <h2>Track the games you own, games you wish to play, and games in your backlog.</h2>
        <router-link v-bind:to="{ name: 'register' }"><button class="primary">Sign Up</button></router-link>
      </div>
    </div>
  </section>

  <section id="how-it-works-section">

    <h2 id="how-it-works-header"><i class="fa-brands fa-space-awesome"></i> How it works</h2>

    <div id="how-it-works-area">
      <h2>PlayQ is a place to virtually track your game collection. Keep your backlog updated, rate the games you've
        played and add those upcoming to your wishlist. </h2>

      <div class="how-it-works-content">

        <div class="how-it-works-text-container">
          <h3>Heading</h3>
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
          <h3>Heading</h3>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore
            et dolore magna aliqua.</p>
        </div>
      </div>

      <div class="how-it-works-content">
        <div class="how-it-works-text-container">
          <h3>Heading</h3>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore
            et dolore magna aliqua.</p>
        </div>

        <div class="how-it-works-image-container">
          <img
            src="../assets/img/stylized_fun_3d_render_of_a_retro_style_game_controller._directional_pad_on_left_side_and_4_b_2-removebg-preview.png"
            alt="">
        </div>
      </div>
    </div>
  </section>

  <section>
    <p>filler</p>

  </section>

  

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

  components: {
  },

  methods: {
   
  },

  created() {
   
  }

}

</script>

<style>
/* ----------------------  HERO SECTION  ---------------------- */
#hero-section {
  background-image: linear-gradient(rgba(29, 8, 97, 0.8), rgba(126, 96, 216, 0.8)), url('../assets/img/lorenzo-herrera-p0j-mE6mGo4-unsplash.jpg');
  width: 100%;
  max-width: none;
  /* height: 500px; */
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  /* background-attachment: fixed; */
  background-color: #1b1625;
  display: flex;
  justify-content: center;
  /* column-gap: 5rem; */
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
  width: 60%;
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
  background-image: linear-gradient(rgba(24, 13, 58, 0.9), rgba(19, 14, 34, 0.9)), url('../assets/img/george-flowers-blYe0BupDuQ-unsplash.jpg');
  background-size: cover;
  background-position: top;
  background-repeat: no-repeat;
  background-attachment: fixed;
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
  width: 40%;
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
  background-image: linear-gradient(rgba(14, 5, 46, 0.8), rgba(7, 3, 19, 0.8)), url('../assets/img/pxfuel.jpg');
  width: 100%;
  max-width: none;
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  /* background-attachment: fixed; */
  background-color: #1b1625;
  display: flex;
  justify-content: center;
  color: white;
  margin-bottom: 0;
  border-radius: 0;
  padding: 5rem 10rem;
}
</style>