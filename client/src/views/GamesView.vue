<template>
    <heading v-bind:pageTitle="pageTitle" v-bind:bgImage="bgImage" v-bind:pageDescription="pageDescription" />

    <section>
        <form v-on:submit.prevent="searchGames" id="game-search-form">

            <div id="input-area">
                <div class="search-form-inputs">
                    <label for="search-title">Title</label>
                    <input name="search-title" type="text" v-model="searchName" placeholder="  Search by Game Title...">
                </div>
                <div class="search-form-inputs">
                    <label for="search-metacritic">Metacritic Score</label>
                    <input name="search-metacritic" type="text" v-model="searchMetacritic"
                        placeholder="  Search by Metacritic Score...">
                </div>
                <div class="search-form-inputs">
                    <label for="genre-options">Genre</label>
                    <select v-model="searchGenres" name="genre-options">
                        <option value="">--- All Genres ---</option>
                        <option v-for="genre in genres" v-bind:key="genre.id" v-bind:value="genre.id">
                            {{ genre.name }}
                        </option>
                    </select>
                </div>
                <div class="search-form-inputs">
                    <label for="platform-options">Platform</label>
                    <select v-model="searchPlatforms" name="platform-options">
                        <option value="">--- All Platforms ---</option>
                        <option v-for="platform in platforms" v-bind:key="platform.id" v-bind:value="platform.id">
                            {{ platform.name }}
                        </option>
                    </select>
                </div>
            </div>

            <div id="search-controls">
                <button id="" class="secondary" v-on:click="resetSearch">Reset</button>
                <button type="submit" class="primary">Search</button>
            </div>
        </form>

        <div class="section-heading">
            <h2><i class="fa-solid fa-cubes"></i>Browse Game Library</h2>
            <div class="section-heading-left">
                <div class="display-option">
                    <button class="display-button" v-bind:disabled="isListVisible === false"
                        v-on:click="isListVisible = false">
                        <i class="fa-solid fa-grip-vertical"></i>
                    </button>
                    <button class="display-button" v-bind:disabled="isListVisible === true"
                        v-on:click="isListVisible = true">
                        <i class="fa-solid fa-list"></i>
                    </button>
                </div>
            </div>
        </div>

        <hr>

        <loading-spinner v-if="isLoading" v-bind:spin="isLoading" />


        <!-- Pagination buttons -->
        <div class="pagination" v-if="games.length > 0">
            <button v-on:click="previousPage" v-bind:disabled="currentPage <= 1"><i
                    class="fa-solid fa-chevron-left"></i></button>
            <span> Page {{ currentPage }} </span>
            <button v-on:click="nextPage" v-bind:disabled="games.length == 0"><i
                    class="fa-solid fa-chevron-right"></i></button>
        </div>

        <div v-show="isListVisible === true">
            <game-list-item v-for="game in games" v-bind:game="game" v-bind:key="game.id" v-bind:collectionId="collectionId"
                v-bind:backlogId="backlogId" />
        </div>
        <div class="cards-area" v-show="isListVisible === false">
            <game-card v-for="game in games" v-bind:game="game" v-bind:key="game.id" v-bind:collectionId="collectionId"
                v-bind:backlogId="backlogId" v-on:open-options="openDialogModal" 
                v-on:testingButtonOK="handleNotification"
                v-on:gameRemovedSuccess="handleNotification" 
                v-on:gameAddedSuccess="handleNotification" />
        </div>

        <!-- Pagination buttons -->
        <div class="pagination" v-if="games.length > 0">
            <button v-on:click="previousPage" v-bind:disabled="currentPage <= 1"><i
                    class="fa-solid fa-chevron-left"></i></button>
            <span> Page {{ currentPage }} </span>
            <button v-on:click="nextPage" v-bind:disabled="games.length == 0"><i
                    class="fa-solid fa-chevron-right"></i></button>
        </div>
    </section>

    <div ref="notification" :class="['notification', { visible: showNotification }]">
        <p><i class="fa-solid fa-circle-check"></i> {{ messagePopup }}</p>
    </div>
</template>

<script>
import gameCard from '../components/GameCard.vue';
import GameListItem from '../components/GameListItem.vue';
import gameService from '../services/GamesService';
import Heading from '../components/HeadingComponent.vue';
import CollectionService from '../services/CollectionService';
import BacklogService from '../services/BacklogService';
import LoadingSpinner from '../components/LoadingSpinner.vue';

const DEBOUNCE_DELAY_MS = 200;


export default {
    data() {
        return {
            isLoading: false,
            isListVisible: false,
            pageTitle: "Games Library",
            pageDescription: 'Browse from a selection of over 500,000+ titles on 50 platforms ',
            bgImage: 'src/assets/img/wp12922844-game-collection-wallpapers.jpg',
            games: [],
            platforms: [],
            genres: [],
            searchName: '',
            searchPlatforms: '',
            searchGenres: '',
            searchMetacritic: '',
            currentPage: 1,

            collectionId: null,
            backlogId: null,

            dialogRef: null,
            isOptionsVisible: false,

            showNotification: false,
            debounceInstance: this.debounce(DEBOUNCE_DELAY_MS),
            popupText: '',
        }
    },

    components: {
        Heading,
        gameCard,
        GameListItem,
        LoadingSpinner,
    },

    computed: {
        messagePopup() {
            let currentPopupText = this.popupText;
            return currentPopupText;
        }
    },

    methods: {
        searchGames() {
            this.isLoading = true;
            this.games = [];

            const params = {
                name: this.searchName,
                platforms: this.searchPlatforms,
                genres: this.searchGenres,
                metacritic: this.searchMetacritic,
                page: this.currentPage.toString()
            };
            return gameService.searchGames(params)
                .then((response) => {
                    this.games = response.data;
                    this.isLoading = false;
                })
                .catch((error) => {
                    this.isLoading = false;
                    alert('Unable to fetch games');
                });
        },
        nextPage() {
            this.currentPage++;
            this.searchGames();
        },
        previousPage() {
            this.currentPage--;
            this.searchGames();
        },
        resetSearch() {
            this.searchName = '';
            this.searchPlatforms = '';
            this.searchGenres = '';
            this.searchMetacritic = '';
            this.currentPage = 1;
            this.games = [];
        },
        getPlatforms() {
            return gameService.getPlatforms()
                .then((response) => {
                    this.platforms = response.data;
                })
                .catch((error) => {
                    alert('Unable to fetch platforms');
                });
        },
        getGenres() {
            return gameService.getGenres()
                .then((response) => {
                    this.genres = response.data;
                })
                .catch((error) => {
                    alert('Unable to fetch genres');
                });
        },
        getCollectionId() {
            return CollectionService.getCollectionId()
                .then((response) => {
                    this.collectionId = response.data;
                })
                .catch((error) => {
                    // alert('Unable to retrieve collectionId');
                });
        },
        getBacklogId() {
            return BacklogService.getBacklogId()
                .then((response) => {
                    this.backlogId = response.data;
                    console.log('This is the backlogId: ' + this.backlog.id);
                })
                .catch((error) => {
                    // alert('Unable to retrieve backlogId');
                });
        },
        openDialogModal() {
            this.dialogRef?.showModal();
        },
        closeDialogModal() {
            this.dialogRef?.close();
        },
        debounce(debounceDelayMs) {
            let timerId = null;

            return () => {
                if (timerId) clearTimeout(timerId);
                timerId = setTimeout(() => this.showNotification = true, debounceDelayMs);
            }
        },
        handleNotification(payload) {
            this.popupText = payload.popupText;
            this.debounceInstance();
        }

    },

    created() {
        this.getBacklogId()
            .then(() => {
                this.getCollectionId();
                console.log('collectionId promise');
            })
            .then(() => {
                this.getGenres();
                console.log('genres promise');
            })
            .then(() => {
                this.getPlatforms();
                console.log('platforms promise');
            })
            .finally(() => {
                this.searchGames();
            })
            .catch((error) => {
                console.log("Error occurred: " + error);
                alert("Unable to fetch info. Try reloading the page.");
            });
    },

    // Template ref is only available after mount hook
    // https://vuejs.org/guide/essentials/template-refs.html
    mounted() {
        this.dialogRef = this.$refs.dialogTemplateRef;

        const notificationRef = this.$refs["notification"];
        notificationRef.addEventListener("animationend", (event) => {
            console.log('Animation ended:', event.animationName);
            if (event.animationName.includes("moveout")) {
                console.log('Setting showNotification to false');
                this.showNotification = false;
            }
            console.log('showNotification: ' + this.showNotification);
        });
    }
}

</script>

<style scoped>
#game-search-form {
    background-color: rgb(219, 219, 242);
    border-radius: 3px;
    border: 1px rgb(173, 175, 214) solid;
    padding: 15px;
    display: flex;
    flex-direction: column;
    align-items: center;
}

#input-area {
    display: flex;
    flex-wrap: wrap;
    column-gap: 15px;
    margin: 15px;
}

#input-area label {
    font-weight: bold;
    font-size: large;
}

#game-search-form input {
    width: 275px;
}

#game-search-form select {
    padding: 3px;
}

.search-form-inputs {
    display: flex;
    flex-direction: column;
}

#search-controls {
    margin: 10px;
}

#search-controls button {
    margin: 0 5px;
    width: 120px;
}



.pagination {
    display: flex;
    justify-content: center;
    align-items: center;
    margin: 20px auto;
}

.pagination span {
    margin: 0 15px;
}

/* #add-options {
    position: relative;
    display: flex;
    flex-direction: column;
    border: 1px red solid;
    width: 150px;

} */

/* ----- Dialog Modal ----- */
dialog {
    margin: 0 auto;
    top: 50%;
    transform: translateY(-50%);
}

dialog[open] {
    animation: toggle-modal 1s ease-in-out;
}

dialog::backdrop {
    background: slategray;
    opacity: 0.2;
}

@keyframes toggle-modal {
    from {
        opacity: 0;
    }

    to {
        opacity: 1;
    }
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