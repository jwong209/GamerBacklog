<template>
    <!-- <heading v-bind:pageTitle="pageTitle" v-bind:bgImage="bgImage" v-bind:pageDescription="pageDescription" /> -->

    <h2>{{ game.name }}</h2>
    <section class="game-details-section">
        <div class="game-details-left">
            <div class="image-container" :style="{ backgroundImage: `url(${game.background_image})` }"></div>
            <div>
                <button>Add to Collection</button>
                <button>Add to Backlog</button>
            </div>
            <p>Metacritic score:<br> {{ game.metacritic }}</p>
            <p>Platforms:</p>
            <p>Genres:</p>
            <p>Developer:</p>
            <p>Publisher:</p>
            <p>Released:<br> {{ game.released }}</p>
            <p>Average playtime:<br> {{ game.playtime }} hrs</p>

            
        </div>
        <div class="game-details-right">
            

            <h3>About</h3>
            <p>{{ game.description_raw }}</p>

            <a :href="game.website" target="_blank">{{ game.website }}</a>

            <h3>Screenshots</h3>
            <div class="screenshot-area">
                <div v-for="item in screenshots" v-bind:key="item.id">
                    <div class="screenshot-container" :style="{ backgroundImage: `url(${item.image})` }"></div>
                </div>
            </div>
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
            screenshots: [],

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
        getGameScreenshots() {
            const currentGameId = this.$route.params.gameId;
            GamesService.getGameScreenshots(currentGameId)
                .then((response) => {
                    this.screenshots = response.data;
                })
                .catch((error) => {
                    alert('Unable to get screenshots');
                });
        }
    },

    created() {
        this.getGamedata();
        this.getGameScreenshots();
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

.game-details-right {
    display: flex;
    flex-direction: column;
    border: 1px dotted blue;
}

.image-container {
    height: 300px;
    width: 450px;
    background-position: center;
    background-size: cover;
    border-radius: 8px;
}

.screenshot-area {
    display: flex;
    flex-wrap: wrap;
    gap: 10px;
}

.screenshot-container {
    height: 150px;
    width: 225px;
    background-position: center;
    background-size: cover;
    /* border-radius: 8px; */
}
</style>