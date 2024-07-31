<template>
    <heading v-bind:pageTitle="pageTitle" v-bind:bgImage="bgImage" v-bind:pageDescription="pageDescription"/>
    <section>
        <h2>Games in COLLECTION: {{ games.length }}</h2>
        <ul>
            <li v-for="(game, index) in games" v-bind:game="game" v-bind:key="index">
                ID: {{ game.id }} Name: {{ game.name }} Released: {{ game.released }} Metacritic: {{ game.metacritic }}
                UserRatings: {{ game.rating }} Playtime: {{ game.playtime }}
            </li>
        </ul>
    </section>

    <section>
        <div class="cards-area">
            <collection-game-card v-for="(game, index) in games" v-bind:game="game" v-bind:key="index" />
        </div>
        <!-- <div class="pagination" v-if="games.length > 0">
            <button v-on:click="previousPage" v-bind:disabled="currentPage <= 1"><i
                    class="fa-solid fa-chevron-left"></i></button>
            <span> Page {{ currentPage }} </span>
            <button v-on:click="nextPage" v-bind:disabled="games.length == 0"><i
                    class="fa-solid fa-chevron-right"></i></button>
        </div> -->
    </section>
</template>

<script>
import CollectionService from '../services/CollectionService';
import CollectionGameCard from '../components/CollectionGameCard.vue';
import Heading from '../components/HeadingComponent.vue';

export default {
    data() {
        return {
            pageTitle: "Collection",
            pageDescription: "Manage games you own...",
            bgImage: 'src/assets/img/george-flowers-blYe0BupDuQ-unsplash.jpg',
            games: [],

        }
    },
    components: {
        CollectionGameCard,
        Heading,
    },

    methods: {
        getCollectionGames() {
            CollectionService.getGamesInCollection()
                .then((response) => {
                    this.games = response.data;
                })
                .catch((error) => {
                    alert('Unable to fetch collection');
                });
        },
    },

    created() {
        this.getCollectionGames();
    }
}


</script>

<style scoped>
h1 {
    color: orange;
}
</style>