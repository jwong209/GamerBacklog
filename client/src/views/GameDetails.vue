<template>
    <heading v-bind:pageTitle="pageTitle" v-bind:bgImage="bgImage" v-bind:pageDescription="pageDescription" />

    <section class="game-details-section">
        <div class="game-details-left">
            <div class="image-container" :style="{ backgroundImage: `url(${game.background_image})` }"></div>
            
            
            <button>Add to Collection</button>
            <button>Add to Backlog</button>
        </div>
        <div class="game-details-right">
            <h2>{{ game.name }}</h2>
            <p>Metacritic score:<br> {{ game.metacritic }}</p>
            <p>Platforms:</p>
            <p>Genres:</p>
            <p>Developer:</p>
            <p>Publisher:</p>
            <p>Released:<br> {{ game.released }}</p>
            <p>Average playtime:<br> {{ game.playtime }} hrs</p>
            
            <h3>About</h3>
            <p>{{ game.description_raw }}</p>
            
            <a :href="game.website" target="_blank">{{ game.website }}</a>

        </div>

    </section>
</template>

<script>
import GamesService from '../services/GamesService';
import Heading from '../components/HeadingComponent.vue';

export default {
    data() {
        return {
            pageTitle: "Game Info",
            pageDescription: "Learn more about your favorite titles",
            bgImage: "src/assets/img/wp12922818-game-collection-wallpapers.jpg",

            game: null,

        }
    },

    components: {
        Heading,
        
    },

    computed: {

    },

    methods: {
        getGamedata() {
            const currentGameId = this.$route.params.gameId;
            GamesService.getGameById(currentGameId)
                .then((response) => {
                    this.game = response.data;
                })
                .catch((error) => {
                    alert('Unable to get game data');
                });
        },
    },

    created() {
        this.getGamedata();
    }
}
</script>

<style scoped>
.game-details-section {
    display: flex;
    column-gap: 40px;

}

.game-details-left {
    display: flex;
    flex-direction: column;
}

.image-container {
    height: 300px;
    width: 450px;
    background-position: center;
    background-size: cover;
    border-radius: 8px;
}
</style>