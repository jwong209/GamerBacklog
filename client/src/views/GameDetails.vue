<template>
    <section class="game-details-section">
        <div class="game-details-left">
            <div class="image-container" :style="{ backgroundImage: `url(${game.background_image})` }"></div>

            <div class="player-status">
                <div class="status-container">
                    <h3 id="header-backlog-status">Collection Status</h3>

                    <div class="status-stats" v-if="currentCollectionGame">
                        <table>
                            <tr>
                                <th>Status:</th>
                                <td>{{ currentCollectionGame?.status }}</td>
                            </tr>
                            <tr>
                                <th>Format:</th>
                                <td>{{ currentCollectionGame?.format }}</td>
                            </tr>
                            <tr>
                                <th>Rating:</th>
                                <td><i id="star-icon" class="fa-solid fa-star"
                                        v-for="(star, index) in currentCollectionGame.rating" v-bind:key="index"></i></td>
                                <!-- v-for="(star, index) in currentCollectionGame?.rating" v-bind:key="index"></i></td> -->
                            </tr>
                            <tr>
                                <th>Notes:</th>
                                <td>{{ currentCollectionGame?.notes }}</td>
                            </tr>
                        </table>
                        <button class="secondary wide-btn">
                            Edit Information<i class="fa-solid fa-pen-to-square"></i>
                        </button>
                        <button class="secondary wide-btn">
                            Remove from Collection<i class="fa-solid fa-trash-can"></i>
                        </button>

                    </div>

                    <div class="status-stats" v-else>
                        <p>Want to add this game to your Collection?</p>
                        <button v-if="!currentCollectionGame" v-on:click="addToCollection" class="secondary wide-btn">
                            Add to Collection
                            <i class="fa-solid fa-layer-group"></i>
                        </button>
                    </div>
                    <!-- <div class="status-stats">
                        <p>Status: {{ currentCollectionGame?.status }}</p>
                        <p>Format: {{ currentCollectionGame?.format }}</p>
                        <p v-if="currentCollectionGame?.rating > 0">Rating: <i id="star-icon" class="fa-solid fa-star"
                                v-for="(star, index) in currentCollectionGame?.rating" v-bind:key="index"></i></p>
                        <p>Notes: {{ currentCollectionGame?.notes }}</p>
                        <button><i class="fa-solid fa-pen-to-square"></i> Edit Info</button>
                    </div> -->

                </div>
                <div class="status-container">
                    <h3 id="header-collection-status">Backlog Status</h3>

                    <div v-if="currentBacklogGame" class="status-stats">

                        <table>
                            <tr>
                                <th>Priority:</th>
                                <td>{{ currentBacklogGame?.priority }}</td>
                            </tr>
                            <tr>
                                <th>Progress:</th>
                                <td>{{ currentBacklogGame?.progress }}</td>
                            </tr>
                        </table>
                        <button class="secondary">
                            <div class="wide-btn">
                                Edit Information<i class="fa-solid fa-pen-to-square"></i>
                            </div>
                        </button>
                        <button class="secondary wide-btn">
                            Remove from Backlog<i class="fa-solid fa-trash-can"></i>
                        </button>

                    </div>

                    <div class="status-stats" v-else>
                        <p>Want to add this game to your Backlog?</p>
                        <button v-if="!currentBacklogGame" v-on:click="addToBacklog" class="secondary wide-btn">
                            Add to Backlog
                            <i class="fa-solid fa-gamepad"></i>
                        </button>
                    </div>
                    <!-- <div class="status-stats">
                        <p>Priority: {{ currentBacklogGame?.priority }}</p>
                        <p>Progress: {{ currentBacklogGame?.progress }}</p>
                        <button><i class="fa-solid fa-pen-to-square"></i> Edit Info</button>
                    </div> -->

                </div>
            </div>

        </div>

        <div class="game-details-right">
            <h1 id="game-title">{{ game?.name }}</h1>

            <div class="details-subsection" id="important-stats" v-if="(game.metacritic > 0) && (game.playtime > 0)">
                <div class="important-stats-item" v-if="game.metacritic > 0">
                    <img src="../assets/icons/icons8-metascore-48.png">
                    <div>
                        <strong>Metacritic score </strong><br> {{ game.metacritic }}
                    </div>
                </div>
                <div class="important-stats-item" v-if="game.playtime > 0">
                    <i class="fa-regular fa-hourglass-half" id="stopwatch-icon"></i>
                    <div>
                        <strong>Average playtime</strong><br> {{ game.playtime }} hrs
                    </div>
                </div>
            </div>

            <div class="details-subsection">
                <div>
                    <h2>Details</h2>
                    <p>{{ game?.description_raw }}</p>
                    <div v-if="game?.website">
                        <strong>Official site</strong> <br>
                        <a :href="game?.website" target="_blank">{{ game.website }}</a>
                    </div>
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

    <div ref="notification" :class="['notification', { visible: showNotification }]">
        <!-- <p>Awesome 🏆</p> -->
        <p><i class="fa-solid fa-circle-check"></i> {{ messagePopup }}</p>

    </div>

    <!-- <button @click="() => debounceInstance()">Notification</button> -->
    <!-- <button @click="() => debounceInstance()">Notification</button> -->
</template>

<script>
import GamesService from '../services/GamesService';
import CollectionService from '../services/CollectionService';
import BacklogService from '../services/BacklogService';

const DEBOUNCE_DELAY_MS = 200;

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

            showNotification: false,
            debounceInstance: this.debounce(DEBOUNCE_DELAY_MS),
            messagePopup: "",
        }
    },

    methods: {
        getGameData() {
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
                    // this.messagePopup = 'Game added to Backlog.'
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
                    console.log('Unable to retrieve collection id');
                    // alert('Unable to retrieve collection id');
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
                    console.log('Unable to retrieve backlogId');
                    // alert('Unable to retrieve backlogId');
                });
        },
        getCollectionGame() {
            CollectionService.getCollectionGame(this.currentCollectionId, this.$route.params.gameId)
                .then((response) => {
                    this.currentCollectionGame = response.data;
                })
                .catch((error) => {
                    console.log('Unable to retrieve collection status info');
                    // alert('Unable to retrieve collection status info');
                });
        },
        getBacklogGame() {
            BacklogService.getBacklogGame(this.currentBacklogId, this.$route.params.gameId)
                .then((response) => {
                    this.currentBacklogGame = response.data;
                })
                .catch((error) => {
                    console.log('Unable to retrieve backlog status info');
                    // alert('Unable to retrieve backlog status info');
                });
        },
        debounce(debounceDelayMs) {
            let timerId = null;

            return () => {
                if (timerId) clearTimeout(timerId);
                timerId = setTimeout(() => this.showNotification = true, debounceDelayMs);
            }
        },

    },

    created() {
        this.getGameData();
        this.getBacklogId();
        this.getCollectionId();
        this.getGameScreenshots();
    },
    mounted() {
        this.getBacklogGame();
        this.getCollectionGame();

        const notificationRef = this.$refs["notification"];
        notificationRef.addEventListener("animationend", (event) => {
            if (event.animationName === "moveout") {
                this.showNotification = false;
            }
        });
    }
}
</script>

<style scoped>
.player-status {
    margin-top: 20px;
}

table th {
    width: 80px;
    text-align: right;
    vertical-align: top;
}

table td {
    padding-left: 15px;
    display: table-cell;
}

.status-container {
    border: 1px grey solid;
    border-radius: 3px;
    margin: 10px auto;
    background-color: white;
}

.status-container h3 {
    margin: 0;
    padding: 10px 20px;
    text-align: center;
}

.status-container p {
    text-align: center;
}

#header-collection-status {
    background-color: rgb(152, 207, 244);
}

#header-backlog-status {
    background-color: rgb(247, 189, 63);
}

.status-stats {
    padding: 10px 20px;
}

.status-stats button {
    width: 100%;
    padding: 5px 35px;
    margin: 5px auto;
}

#important-stats {
    background-color: rgb(219, 219, 242);
    border: 2px rgb(173, 175, 214) solid;
    display: flex;
    column-gap: 1rem;
    justify-content: space-evenly;
}

#stopwatch-icon {
    font-size: 35px;
    color: rgb(64, 45, 131);
}

.important-stats-item {
    display: flex;
    align-items: center;
    column-gap: 8px;
}

.details-subsection {
    padding: 15px 20px;
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
    margin: 10px;
}

.screenshot-container {
    height: 112px;
    width: 200px;
    background-position: center;
    background-size: cover;
    border-radius: 8px;
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

/* ----- NOTIFICATION ----- */
.notification {
    position: fixed;
    top: -2rem;
    left: 50%;
    transform: translate(-50%, -55%);

    padding: 5px 30px;
    width: fit-content;
    background-color: #120ab077;
    color: white;
    border-radius: 10px;
    border: 2px solid rgb(107, 74, 215);
}

.notification i {
    color: greenyellow;
}


.visible {
    /*         name    duration delay timing function direction*/
    animation: movein 0.5s ease forwards,
        moveout 0.5s 2s ease forwards;
}

@keyframes movein {
    from {
        top: -4rem;
        opacity: 0;
    }

    to {
        top: 4rem;
        opacity: 1;
    }
}

@keyframes moveout {
    from {
        top: 4rem;
        opacity: 1;
    }

    to {
        top: -4rem;
        opacity: 0;
    }
}
</style>