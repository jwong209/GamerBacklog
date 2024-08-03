<template>
    <heading v-bind:pageTitle="pageTitle" v-bind:bgImage="bgImage" v-bind:pageDescription="pageDescription"/>
    <section>
        <h2>Games in COLLECTION: {{ games.length }}</h2>
        <!-- <ul>
            <li v-for="(game, index) in games" v-bind:game="game" v-bind:key="index">
                image url: {{ game.background_image }}
                ID: {{ game.id }} Name: {{ game.name }} Released: {{ game.released }} Metacritic: {{ game.metacritic }}
                UserRatings: {{ game.rating }} Playtime: {{ game.playtime }}
            </li>
        </ul> -->
   
        <div class="section-heading">
            <h2><i class="fa-solid fa-gamepad"></i>...</h2>
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

        <div v-show="isListVisible === true">
            <collection-list-item 
                v-for="(game, index) in games" 
                v-bind:game="game" 
                v-bind:key="index" 
                v-bind:backlogId="backlogId"
                v-bind:collectionId="collectionId" 
            />
        </div>

        <div class="cards-area" v-show="isListVisible === false">
            <collection-game-card 
                v-for="(game, index) in games" 
                v-bind:game="game" 
                v-bind:key="index" 
                v-bind:backlogId="backlogId"
                v-bind:collectionId="collectionId"
                v-on:edit-info="editInfo"
            />
        </div>
       
    </section>

    <modal-collection 
        v-if="showModal && editInfo"  
        v-bind:selectedGameId="selectedGameId" 
        v-bind:collectionId="collectionId"
        v-on:close="showModal = false"
    />
</template>

<script>
import CollectionService from '../services/CollectionService';
import BacklogService from '../services/BacklogService';
import Heading from '../components/HeadingComponent.vue';
import CollectionGameCard from '../components/CollectionGameCard.vue';
import CollectionListItem from '../components/CollectionListItem.vue';
import ModalCollection from '../components/ModalCollection.vue';

export default {
    data() {
        return {
            isListVisible: false,
            pageTitle: "Collection",
            pageDescription: "Manage games you own...",
            bgImage: 'src/assets/img/george-flowers-blYe0BupDuQ-unsplash.jpg',
            games: [],

            backlogId: null,
            collectionId: null,

            showModal: false,
            selectedGameId: null,

        }
    },
    components: {
        Heading,
        CollectionGameCard,
        CollectionListItem,
        ModalCollection,
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