<template>
    <heading v-bind:pageTitle="pageTitle" v-bind:bgImage="bgImage" />

    <section class="cards-area">
        <collection-game-card />
        <collection-game-card />


    </section>
    
</template>

<script>
import CollectionGameCard from '../components/CollectionGameCard.vue';
import Heading from '../components/HeadingComponent.vue';

export default {
    data() {
        return {
            pageTitle: "Collection",
            bgImage: 'src/assets/img/george-flowers-blYe0BupDuQ-unsplash.jpg',
        }
    },
    components: {
        CollectionGameCard,
        Heading,
    }
}


</script>

<style>

</style>