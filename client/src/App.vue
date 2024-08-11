<template>
  <div>
    <header-component v-on:open-nav-menu="showNavMenu" />
    <!-- <nav>
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token">
          Logout
        </router-link>
        <router-link v-bind:to="{ name: 'login' }" v-else>Login</router-link>
    </nav> -->
    <main>
      <router-view />
    </main>
    <footer-component />
    <back-to-top />
  </div>


  <mobile-nav-menu v-if="isNavVisible" v-on:close-nav-menu="closeNavMenu" />
</template>

<script>
const MOBILE_WIDTH_PX = 425;


import './assets/main.css';
import HeaderComponent from './components/HeaderComponent.vue';
import FooterComponent from './components/FooterComponent.vue';
import BackToTop from './components/BackToTop.vue';
import MobileNavMenu from './components/MobileNavMenu.vue'

export default {
  data() {
    return {
      windowWidth: window.innerWidth,
      isNavVisible: false,
    }
  },

  components: {
    HeaderComponent,
    FooterComponent,
    BackToTop,
    MobileNavMenu,
  },

  computed: {
    isMobile() {
      return this.windowWidth < MOBILE_WIDTH_PX;
    }
  },

  methods: {
    setWindowWidth() {
      this.windowWidth = window.innerWidth;
    },
    showNavMenu() {
      console.log('before visible: ' + this.isNavVisible);
      this.isNavVisible = true;
      console.log('after visible: ' + this.isNavVisible);
    },
    closeNavMenu() {
      this.isNavVisible = false;
    }
  },
  mounted() {
    /* TODO: Harder option */
    window.addEventListener("resize", this.setWindowWidth);
  },
  unmounted() {
    window.removeEventListener("resize", this.setWindowWidth);
  }


}

</script>

<style scoped>
@media only screen and (max-width: 425px) {
  mobile-nav-menu {
    position: absolute;
  }
}
</style>