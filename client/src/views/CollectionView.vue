<template>
    <heading v-bind:pageTitle="pageTitle" v-bind:bgImage="bgImage" />

    <section class="cards-area">
        <collection-game-card />
        <collection-game-card />
    </section>

    <section>
        <h2>Games in COLLECTION: {{ games.length }}</h2>
        <ul>
            <li v-for="(game, index) in games" v-bind:game="game" v-bind:key="index">
                ID: {{ game.id }} Name: {{ game.name }} Released: {{ game.released }} Metacritic: {{ game.metacritic }}
                UserRatings: {{ game.rating }} Playtime: {{ game.playtime }}
            </li>
        </ul>

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

<style></style>