<template>
    <button id="back-to-top-button" title="Scroll to top" v-on:click="scrollToTop" v-show="isScrolledPastThreshold">
        <i class="fa-solid fa-angle-up"></i>
    </button>
</template>

<script>

export default {
    data() {
        return {
            isScrolledPastThreshold: true, //change to false default
        };
    },
    computed: {
       
    },
    methods: {
       scrollToTop() {
        window.scrollTo({ top: 0, behavior: 'smooth' });
       }
    },
}

</script>

<style scoped>
#back-to-top-button {
    display: block;
    position: fixed;
    bottom: 50px;
    right: 30px;
    z-index: 100;
    border: none;
    outline: none;
    color: white;
    background-color: #3f3f8a;
    padding: 15px 20px;
    border-radius: 25%;
    font-size: 1rem;
    cursor: pointer;
}

#back-to-top-button:hover {
    background-color: #5a40ed;
    animation: bounce 1.5s ease infinite;
}

@keyframes bounce {
    0%, 20%, 50%, 80%, 100% {
        transform: translateY(0);
    }
    40% {
        transform: translateY(-30px);
    }
    60% {
        transform: translateY(-15px);
    }
}

@media screen and (max-width: 425px) {
    #back-to-top-button {
      bottom: 10px;
      right: 10px;
      z-index: 100;
  }
}
</style>