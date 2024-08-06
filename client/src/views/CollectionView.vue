<template>
    <heading v-bind:pageTitle="pageTitle" v-bind:bgImage="bgImage" v-bind:pageDescription="pageDescription" />
    <section>
        <!-- <ul>
            <li v-for="(game, index) in games" v-bind:game="game" v-bind:key="index">
                image url: {{ game.background_image }}
                ID: {{ game.id }} Name: {{ game.name }} Released: {{ game.released }} Metacritic: {{ game.metacritic }}
                UserRatings: {{ game.rating }} Playtime: {{ game.playtime }}
            </li>
        </ul> -->

        <div class="section-heading">
            <h2><i class="fa-solid fa-layer-group"></i>Found {{ filteredList.length }} games</h2>

            <form action="/action_page.php" id="search-list" v-on:submit.prevent="filterByName">
                <input type="text" placeholder="Search this collection" name="search" v-model="searchedName">
                <!-- <button type="submit" class="search-pair-btn"><i class="fa fa-search"></i></button> -->
            </form>

            <div class="section-heading-left">
                <select>
                    <option>Sort by: </option>
                    <option>Name</option>
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
            <filter-options />
            <loading-spinner v-if="isLoading" v-bind:spin="isLoading" />

            <div class="list-area" v-show="isListVisible === true">
                <collection-list-item v-for="(game, index) in games" v-bind:game="game" v-bind:key="index"
                v-bind:backlogId="backlogId" v-bind:collectionId="collectionId" />
            </div>
            
            <div class="cards-area" v-show="isListVisible === false">
                <collection-game-card v-for="(game, index) in filteredList" v-bind:game="game" v-bind:key="index"
                v-bind:backlogId="backlogId" v-bind:collectionId="collectionId" v-on:edit-info="editInfo" />

            </div>
        </div>
            
    </section>

    <modal-collection v-if="showModal" v-bind:selectedGameId="selectedGameId" v-bind:collectionId="collectionId"
        v-on:close="showModal = false" />
</template>

<script>
import '../assets/main.css'
import CollectionService from '../services/CollectionService';
import BacklogService from '../services/BacklogService';
import Heading from '../components/HeadingComponent.vue';
import CollectionGameCard from '../components/CollectionGameCard.vue';
import CollectionListItem from '../components/CollectionListItem.vue';
import ModalCollection from '../components/ModalCollection.vue';
import LoadingSpinner from '../components/LoadingSpinner.vue';
import FilterOptions from '../components/FilterOptions.vue';

export default {
    data() {
        return {
            isLoading: false,
            isListVisible: false,
            pageTitle: "Collection",
            pageDescription: "Keep track of the games you own",
            bgImage: 'src/assets/img/wp12922818-game-collection-wallpapers.jpg',
            games: [],

            backlogId: null,
            collectionId: null,

            showModal: false,
            selectedGameId: null,

            searchedName: '',

        }
    },
    components: {
        Heading,
        CollectionGameCard,
        CollectionListItem,
        ModalCollection,
        LoadingSpinner,
        FilterOptions,
    },

    computed: {
        filteredList() {
            let filteredGames = this.games;

            if (this.searchedName != "") {
                filteredGames = filteredGames.filter((game) => game.name.toLowerCase().includes(this.searchedName.toLowerCase()));
            }

            return filteredGames;
        },
    },

    methods: {
        getCollectionGames() {
            this.isLoading = true;
            CollectionService.getGamesInCollection()
                .then((response) => {
                    this.games = response.data;
                    this.isLoading = false;
                })
                .catch((error) => {
                    this.isLoading = false;
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
        getCollectionId() {
            CollectionService.getCollectionId()
                .then((response) => {
                    this.collectionId = response.data;
                    console.log('This is the GameId:' + this.game.id);
                    console.log('This is the CollectionId:' + this.collectionId);
                })
                .catch((error) => {
                    // alert('Unable to retrieve collection id');
                });
        },
        editInfo({ gameId, collectionId }) {
            this.selectedGameId = gameId;
            this.showModal = true;
        },
       
    },

    created() {
        this.getCollectionGames();
        this.getBacklogId();
        this.getCollectionId();

    }
}


</script>

<style scoped>
h1 {
    color: orange;
}



</style>