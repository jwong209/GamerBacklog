<template>
    <heading v-bind:pageTitle="pageTitle" v-bind:bgImage="bgImage" />

    <section>

        
    </section>

</template>

<script>
import GameCard from '../components/GameCard.vue';
import Heading from '../components/HeadingComponent.vue';

export default {
    data() {
        return {
            pageTitle: "Games",
            bgImage: 'src/assets/img/george-flowers-blYe0BupDuQ-unsplash.jpg',
        }
    },
    components: {
        Heading,
    }
}

</script>

<style>

</style>