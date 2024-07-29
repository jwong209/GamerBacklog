<template>
  <div id="cart-app">
    <!-- <header></header> -->
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
    <!-- <footer></footer> -->
    <footer-component />
    <back-to-top />
  </div>
</template>

<script setup>
import './assets/main.css';
import HeaderComponent from './components/HeaderComponent.vue';
import FooterComponent from './components/FooterComponent.vue';
import BackToTop from './components/BackToTop.vue';


</script>

<style scoped>

</style>