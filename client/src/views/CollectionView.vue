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
import BacklogService from '../services/BacklogService';
import Heading from '../components/HeadingComponent.vue';
import CollectionGameCard from '../components/CollectionGameCard.vue';

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
        Heading,
        CollectionGameCard,
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
        getBacklogId() {
            BacklogService.getBacklogId()
                .then((response) => {
                    this.backlogId = response.data;
                    console.log('This is the backlogId: ' + this.backlog.id);
                })
                .catch((error) => {
                    // alert('Unable to retrieve backlogId');
                });
        },
    },

    created() {
        this.getBacklogId();
        this.getCollectionGames();

    }
}


</script>

<style scoped>
h1 {
    color: orange;
}
</style>