<template>
    <heading v-bind:pageTitle="pageTitle" v-bind:bgImage="bgImage" v-bind:pageDescription="pageDescription" />

    <section>
        <div class="section-heading">
            <h2><i class="fa-solid fa-gamepad"></i>Found {{ filteredList.length }} games</h2>

            <form action="/action_page.php" id="search-list">
                <input type="text" placeholder="Search my backlog" name="search" v-model="searchedName">
            </form>

            <div class="section-heading-left">
                <select name="sort-select" v-model="sortBySelection">
                    <option value="">Sort by: </option>
                    <option value="Name A-Z">Name (A-Z)</option>
                    <option value="Name Z-A">Name (Z-A)</option>
                    <option>Release date</option>
                    <option>Metacritic Score</option>
                    <option>User Score</option>
                    <option>Playtime</option>
                </select>
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

        <div class="display-area">
            <filter-options-backlog />
            <loading-spinner v-if="isLoading && filteredList.length === 0" v-bind:spin="isLoading" />

            <div class="list-area" v-show="isListVisible === true">
                <backlog-list-item v-for="game in filteredList" v-bind:game="game" v-bind:key="game.id"
                    v-bind:backlogId="backlogId" v-bind:collectionId="collectionId"/>
            </div>

            <div class="cards-area" v-show="isListVisible === false">
                <backlog-game-card v-for="game in filteredList" v-bind:game="game" v-bind:key="game.id"
                    v-bind:backlogId="backlogId" v-bind:collectionId="collectionId" v-on:edit-info="editInfo"
                    v-on:testingButtonOK="handleNotification" v-on:gameRemovedSuccess="handleNotification"
                    v-on:gameAddedSuccess="handleNotification" />
            </div>
        </div>

    </section>

    <modal-backlog v-if="showModal" v-bind:selectedGameId="selectedGameId" v-bind:backlogId="backlogId"
        v-on:close="showModal = false" v-on:updateGameSuccess="handleNotification" />

    <div ref="notification" :class="['notification', { visible: showNotification }]">
        <p><i class="fa-solid fa-circle-check"></i> {{ messagePopup }}</p>
    </div>
</template>

<script>
import BacklogService from '../services/BacklogService';
import Heading from '../components/HeadingComponent.vue';
import BacklogGameCard from '../components/BacklogGameCard.vue';
import BacklogListItem from '../components/BacklogListItem.vue';
import ModalBacklog from '../components/ModalBacklog.vue';
import LoadingSpinner from '../components/LoadingSpinner.vue';
import CollectionService from '../services/CollectionService';
import GamesService from '../services/GamesService';
import FilterOptionsBacklog from '../components/FilterOptionsBacklog.vue';


const DEBOUNCE_DELAY_MS = 200;

export default {
    data() {
        return {
            isLoading: true,
            isListVisible: false,
            pageTitle: "Backlog",
            pageDescription: "Keep tabs on the games that you'll get to later",
            bgImage: 'src/assets/img/pxfuel02.jpg',

            backlogId: null,
            collectionId: null,
            platforms: [],

            showModal: false,
            selectedGameId: null,

            searchedName: '',
            sortBySelection: '',

            showNotification: false,
            debounceInstance: this.debounce(DEBOUNCE_DELAY_MS),
            popupText: '',
        }
    },

    components: {
        Heading,
        BacklogGameCard,
        BacklogListItem,
        ModalBacklog,
        LoadingSpinner,
        FilterOptionsBacklog,

    },

    computed: {
        filteredList() {
            let filteredGames = this.$store.getters.retrieveBacklogGames;

            // ----------------- FILTER Conditions  -----------------
            if (this.searchedName != "") {
                filteredGames = filteredGames.filter((game) => game.name.toLowerCase().includes(this.searchedName.toLowerCase()));
            }

            // ----------------- SORTING Conditions  -----------------
            if (this.sortBySelection === 'Name A-Z') {
                filteredGames = filteredGames.sort((a, b) => {
                    const nameA = a.name.toLowerCase();
                    const nameB = b.name.toLowerCase();
                    if (nameA < nameB) {
                        return -1;        // A comes before B
                    }
                    if (nameA > nameB) {
                        return 1;         // A comes after B
                    }
                    return 0;            // no change
                })
            }
            if (this.sortBySelection === 'Name Z-A') {
                filteredGames = filteredGames.sort((a, b) => {
                    const nameA = a.name.toLowerCase();
                    const nameB = b.name.toLowerCase();
                    if (nameA < nameB) {
                        return -1;
                    }
                    if (nameA > nameB) {
                        return 1;
                    }
                    return 0;
                }).reverse();
            }

            return filteredGames;
        },
        messagePopup() {
            let currentPopupText = this.popupText;
            return currentPopupText;
        }
    },

    methods: {
        // getBacklogGames() {
        //     this.isLoading = true;

        //     BacklogService.getGamesInBacklog()
        //         .then((response) => {
        //             this.games = response.data;
        //             this.isLoading = false;
        //         })
        //         .catch((error) => {
        //             this.isLoading = false;
        //             alert('Unable to fetch backlog');
        //         });
        // },
        getBacklogGames() {
            this.isLoading = true;
            return this.$store.dispatch('getBacklogGames')
                .then((response) => {
                    // this.games = response.data;
                    // this.isLoading = false;

                })
                .catch((error) => {
                    // this.isLoading = false;
                    alert('Unable to fetch backlog');
                })
                .finally(() => {
                    this.isLoading = false;
                });
        },
        getBacklogId() {
            return BacklogService.getBacklogId()
                .then((response) => {
                    this.backlogId = response.data;
                    // console.log('This is the GameId:' + this.game.id);
                    // console.log('This is the backlogId:' + this.backlogId);
                })
                .catch((error) => {
                    alert('Unable to retrieve id');
                });
        },
        editInfo({ gameId, backlogId }) {
            this.selectedGameId = gameId;
            this.showModal = true;
        },
        getCollectionId() {
            return CollectionService.getCollectionId()
                .then((response) => {
                    this.collectionId = response.data;
                })
                .catch((error) => {
                    console.log('Unable to retrieve collection id');
                    // alert('Unable to retrieve id');
                });
        },
        getPlatforms() {
            return GamesService.getPlatforms() //added 'return' so that promise chaining succeeds
                .then((response) => {
                    this.platforms = response.data;
                    console.log('Platforms successfully retrieved');
                })
                .catch((error) => {
                    alert('Unable to fetch platforms');
                });
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
                console.log('collectionId promise with ' + this.collectionId);
            })
            .then(() => {
                this.getPlatforms();
                console.log('platforms promise')
            })
            .then(() => {
                this.getBacklogGames();
                console.log('finally backlogGames promise');
                console.log('For collectionGame, this is the collectionId: ' + this.collectionId);
                console.log('For collectionGame, this is the backlogId: ' + this.backlogId);
            })
            .catch((error) => {
                console.log("Error occurred: " + error);
                alert("Unable to fetch info. Try reloading the page.");
            });

        // Promise.all([
        //     this.getBacklogId(),
        //     this.getCollectionId(),
        //     this.getPlatforms(),
        //     this.getBacklogGames()
        // ])
        //     .then(([backlogIdResponse, collectionIdResponse, platformsResponse]) => {
        //         this.backlogId = backlogIdResponse.data;
        //         this.collectionId = collectionIdResponse.data;
        //         this.platforms = platformsResponse.data;
               
        //     })
        //     .then(backlogGamesResponse => {
        //         this.games = backlogGamesResponse.data;

        //         console.log('For collectionGame, this is the collectionId: ' + this.collectionId);
        //         console.log('For collectionGame, this is the backlogId: ' + this.backlogId);
        //     })
        //     .catch((error) => {
        //         console.log("Error occurred: " + error);
        //         alert("Unable to fetch info. Try reloading the page.");
        //     });
    },

    mounted() {
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