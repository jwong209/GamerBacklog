<template>
    <heading v-bind:pageTitle="pageTitle" v-bind:bgImage="bgImage" v-bind:pageDescription="pageDescription" />

    <section>
        <h2>Games in BACKLOG: {{ games.length }}</h2>
        <div v-show="isListVisible === true">
            <ul>
                <li v-for="(game, index) in games" v-bind:game="game" v-bind:key="index">
                    ID: {{ game.id }} Name: {{ game.name }} Released: {{ game.released }} Metacritic: {{ game.metacritic }}
                    UserRatings: {{ game.rating }} Playtime: {{ game.playtime }}
                </li>
            </ul>
        </div>

        <div class="cards-area" v-show="isListVisible === false">
            <backlog-game-card v-for="(game, index) in games" v-bind:game="game" v-bind:key="index" />
        </div>

    </section>
</template>

<script>
import BacklogService from '../services/BacklogService';
import Heading from '../components/HeadingComponent.vue';
import BacklogGameCard from '../components/BacklogGameCard.vue';

export default {
    data() {
        return {
            isListVisible: false,
            games: [],
            pageTitle: "Backlog",
            pageDescription: "Games that you'll get to later",
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

<style></style>