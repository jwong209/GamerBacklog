<template>
  <div id="cart-app">
    <header-component />
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
</template>

<script>
import './assets/main.css';
import HeaderComponent from './components/HeaderComponent.vue';
import FooterComponent from './components/FooterComponent.vue';
import BackToTop from './components/BackToTop.vue';

export default {
  components: {
    HeaderComponent,
    FooterComponent,
    BackToTop,
  }
}

</script>

<style scoped>

</style>