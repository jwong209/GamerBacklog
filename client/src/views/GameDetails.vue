<template>
    <!-- <heading v-bind:pageTitle="pageTitle" v-bind:bgImage="bgImage" v-bind:pageDescription="pageDescription" /> -->

    <section class="game-details-section">
        <div class="game-details-left">
            <div class="image-container" :style="{ backgroundImage: `url(${game.background_image})` }"></div>

            <div class="list-options">
                <button v-if="!currentCollectionGame" v-on:click="addToCollection"><i class="fa-solid fa-layer-group"></i> Add to Collection</button>
                <button v-if="!currentBacklogGame" v-on:click="addToBacklog"><i class="fa-solid fa-gamepad"></i> Add to Backlog</button>
            </div>

            <div class="player-status">
                <div v-if="currentCollectionGame" class="status-container">
                    <h3>Collection Status</h3>
                    <p>Status: {{ currentCollectionGame?.status }}</p>
                    <p>Format: {{ currentCollectionGame?.format }}</p>
                    <p v-if="currentCollectionGame?.rating > 0">Rating: <i id="star-icon" class="fa-solid fa-star" v-for="(star, index) in currentCollectionGame?.rating" v-bind:key="index"></i></p>
                    <p>Notes: {{ currentCollectionGame?.notes }}</p>
                    <button><i class="fa-solid fa-pen-to-square"></i> Edit Info</button>

                </div>
                <div v-if="currentBacklogGame" class="status-container">
                    <h3>Backlog Status</h3>
                    <p>Priority: {{ currentBacklogGame?.priority }}</p>
                    <p>Progress: {{ currentBacklogGame?.progress }}</p>
                    <button><i class="fa-solid fa-pen-to-square"></i> Edit Info</button>
                </div>
            </div>

        </div>

        <div class="game-details-right">
            <h1 id="game-title">{{ game?.name }}</h1>
            <div class="details-subsection" id="details-stats">
                <div v-if="game.metacritic > 0"><strong>Metacritic score: </strong> {{ game.metacritic }}</div>
                <div><strong><i class="fa-solid fa-stopwatch"></i> Average playtime: </strong>   {{ game.playtime }} hrs</div>
            </div>
            <div class="details-subsection">

                <div>
                    <h2>Details</h2>
                    <p>{{ game?.description_raw }}</p>
                    <strong>Official site</strong> <br>
                    <a :href="game?.website" target="_blank">{{ game.website }}</a>
                </div>

                <div id="game-info">
                    <div><strong>Platforms</strong> <br> {{ game.platforms.map(wrapper => wrapper.platform.name).join(', ')
                    }}</div>
                    <div><strong>Genres</strong> <br> {{ game.genres.map(genre => genre.name).join(', ') }}</div>
                    <div><strong>Developers</strong> <br> {{ game.developers.map(developer => developer.name).join(', ') }}
                    </div>
                    <div><strong>Publishers</strong> <br> {{ game.publishers.map(publisher => publisher.name).join(', ') }}
                    </div>
                    <div><strong>Released</strong> <br> {{ game.released }}</div>
                    <div v-if="game.esrb_rating"><strong>ESRB</strong> <br> {{ game.esrb_rating.name }}</div>
                </div>
            </div>

            <div class="details-subsection">
                <h2>Screenshots</h2>
                <div class="screenshot-area">
                    <div v-for="item in screenshots" v-bind:key="item.id">
                        <div class="screenshot-container" :style="{ backgroundImage: `url(${item.image})` }"></div>
                    </div>
                </div>
            </div>
        </div>

    </section>

    <dialog>
        <button>Button 1</button>
        <button>Button 2</button>
    </dialog>
</template>

<script>
import GamesService from '../services/GamesService';
import CollectionService from '../services/CollectionService';
import BacklogService from '../services/BacklogService';

export default {
    data() {
        return {
            pageTitle: "Game Info",
            pageDescription: "Learn more about your favorite titles",
            bgImage: "src/assets/img/wp12922818-game-collection-wallpapers.jpg",

            game: null,
            screenshots: [],

            backlogGame: {
                "backlogId": null,
                "gameId": this.$route.params.gameId,
                "priority": 3,
                "progress": ""
            },
            collectionGame: {
                "collectionId": null,
                "gameId": this.$route.params.gameId,
                "status": "",
                "format": "",
                "platform": "",
                "rating": null,
                "notes": ""
            },

            currentGameId: this.$route.params.gameId,
            currentBacklogId: null,
            currentCollectionId: null,
            currentBacklogGame: null,
            currentCollectionGame: null,
        }
    },

    components: {

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
        },
        addToCollection() {
            CollectionService.addGameToCollection(this.collectionGame)
                .then((response) => {
                    console.log('Successfully added game with id ' + this.gameId);
                    alert('Successfully added to collection');
                })
                .catch((error) => {
                    alert('Unable to add to collection');
                });
        },
        addToBacklog() {
            console.log(this.backlogGame);

            BacklogService.addGameToBacklog(this.backlogGame)
                .then((response) => {
                    console.log('Added game to backlog');
                    alert('Successfully added to backlog');
                })
                .catch((error) => {
                    alert('Unable to add game to backlog');
                });
        },
        getCollectionId() {
            CollectionService.getCollectionId()
                .then((response) => {
                    this.collectionGame.collectionId = response.data;
                    this.currentCollectionId = response.data;
                    // console.log('This is the GameId:' + this.game.id);
                    console.log('This is the CollectionId:' + this.collectionId);
                })
                .catch((error) => {
                    alert('Unable to retrieve collection id');
                });
        },
        getBacklogId() {
            BacklogService.getBacklogId()
                .then((response) => {
                    this.backlogGame.backlogId = response.data;
                    this.currentBacklogId = response.data;
                    console.log('This is the backlogId: ' + this.backlogId);
                })
                .catch((error) => {
                    alert('Unable to retrieve backlogId');
                });
        },
        getCollectionGame() {
            CollectionService.getCollectionGame(this.currentCollectionId, this.$route.params.gameId)
                .then((response) => {
                    this.currentCollectionGame = response.data;
                })
                .catch((error) => {
                    alert('Unable to retrieve collection status info');
                });
        },
        getBacklogGame() {
            BacklogService.getBacklogGame(this.currentBacklogId, this.$route.params.gameId)
                .then((response) => {
                    this.currentBacklogGame = response.data;
                })
                .catch((error) => {
                    alert('Unable to retrieve backlog status info');
                });
        }

    },

    created() {
        this.getGamedata();
        this.getBacklogId();
        this.getCollectionId();
        this.getGameScreenshots();
    },
    mounted() {
        this.getBacklogGame();
        this.getCollectionGame();
    }
}
</script>

<style scoped>
.status-container {
    border: 1px grey solid;
    border-radius: 3px;
    padding: 10px 20px;
    margin-bottom: 10px;
}

.details-subsection {
    padding: 20px 20px;
    background-color: white;
    margin-bottom: 15px;
    border-radius: 3px;
}

.details-subsection h2 {
    margin: 0;
}

#details-stats {
    display: flex;
    justify-content: space-evenly;
    column-gap: 1rem;
    background-color: rgb(105, 108, 251);
    padding: 5px 100px;
    color: white;
}

#game-title {
    color: black;
    margin: 0;
}

#game-info {
    display: flex;
    flex-wrap: wrap;
    justify-content: flex-start;
    column-gap: 1rem;
}

#game-info div {
    width: 48%;
    margin: 10px 0;
}

.game-details-section {
    display: flex;
    column-gap: 40px;
    margin-top: 50px;

}

.game-details-left {
    display: flex;
    flex-direction: column;
}

.game-details-right {
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

.list-options {
    display: flex;
    justify-content: center;
    column-gap: 10px;
    margin: 10px 0;
}

.list-options button {
    padding: 5px 10px;
}

#star-icon {
    color: rgb(225, 200, 3);
}
</style>