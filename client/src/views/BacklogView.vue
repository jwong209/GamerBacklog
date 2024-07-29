<template>
    <heading v-bind:pageTitle="pageTitle" v-bind:bgImage="bgImage" />

    <section class="cards-area">
        <backlog-game-card />
        <backlog-game-card />
        <backlog-game-card />
        <backlog-game-card />
    </section>
</template>

<script>
import Heading from '../components/HeadingComponent.vue';
import BacklogGameCard from '../components/BacklogGameCard.vue';

export default {
    data() {
        return {
            pageTitle: "Backlog",
            bgImage: 'src/assets/img/george-flowers-blYe0BupDuQ-unsplash.jpg',
        }
    },
    components: {
        Heading,
        BacklogGameCard,
    }
}

</script>

<style>

</style>