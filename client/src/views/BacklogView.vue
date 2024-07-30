<template>
    <heading v-bind:pageTitle="pageTitle" v-bind:bgImage="bgImage" />

    <section class="cards-area">
        <backlog-game-card />
        <backlog-game-card />
        <backlog-game-card />
        <backlog-game-card />
    </section>

    <section>
        <h2>Games in BACKLOG: {{ games.length }}</h2>
        <ul>
            <li v-for="(game, index) in games" v-bind:game="game" v-bind:key="index">
                ID: {{ game.id }} Name: {{ game.name }} Released: {{ game.released }} Metacritic: {{ game.metacritic }}
                UserRatings: {{ game.rating }} Playtime: {{ game.playtime }}
            </li>
        </ul>
    </section>
</template>

<script>
import BacklogService from '../services/BacklogService';
import Heading from '../components/HeadingComponent.vue';
import BacklogGameCard from '../components/BacklogGameCard.vue';

export default {
    data() {
        return {
            games: [],
            pageTitle: "Backlog",
            bgImage: 'src/assets/img/george-flowers-blYe0BupDuQ-unsplash.jpg',
        }
    },

    components: {
        Heading,
        BacklogGameCard,
    },

    methods: {
        getBacklogGames() {
            BacklogService.getGamesInBacklog()
                .then((response) => {
                    this.games = response.data;
                }) 
                .catch((error) => {
                    alert('Unable to fetch backlog');
                });
        }
    },

    created() {
        this.getBacklogGames();
    }
}

</script>

<style>

</style>