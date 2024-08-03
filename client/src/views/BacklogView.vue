<template>
    <heading v-bind:pageTitle="pageTitle" v-bind:bgImage="bgImage" v-bind:pageDescription="pageDescription" />

    <section>
        <h2>Games in BACKLOG: {{ games.length }}</h2>

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
            <ul>
                <li v-for="(game, index) in games" v-bind:game="game" v-bind:key="index">
                    ID: {{ game.id }} Name: {{ game.name }} Released: {{ game.released }} Metacritic: {{ game.metacritic }}
                    UserRatings: {{ game.rating }} Playtime: {{ game.playtime }}
                </li>
            </ul>
            <backlog-list-item 
                v-for="(game, index) in games" 
                v-bind:game="game" 
                v-bind:key="index" 
                v-bind:backlogId="backlogId" 
            />
        </div>

        <div class="cards-area" v-show="isListVisible === false">
            <!-- <backlog-game-card v-for="(game, index) in games" v-bind:game="game" v-bind:key="index" v-bind:backlogId="backlogId" v-on:edit-info="editInfo = $event; showModal = true" /> -->
            <backlog-game-card 
                v-for="(game, index) in games" 
                v-bind:game="game" 
                v-bind:key="index" 
                v-bind:backlogId="backlogId" 
                v-on:edit-info="editInfo" 
            />
        </div>
    </section>

    <modal-backlog 
        v-if="showModal && editInfo" 
        v-bind:selectedGameId="selectedGameId" 
        v-bind:backlogId="backlogId" 
        v-on:close="showModal = false" 
    />
</template>

<script>
import BacklogService from '../services/BacklogService';
import Heading from '../components/HeadingComponent.vue';
import BacklogGameCard from '../components/BacklogGameCard.vue';
import BacklogListItem from '../components/BacklogListItem.vue';
import ModalBacklog from '../components/ModalBacklog.vue';


export default {
    data() {
        return {
            isListVisible: false,
            games: [],
            pageTitle: "Backlog",
            pageDescription: "Games that you'll get to later",
            bgImage: 'src/assets/img/george-flowers-blYe0BupDuQ-unsplash.jpg',
            backlogId: null,

            showModal: false,
            selectedGameId: null,
        }
    },

    components: {
        Heading,
        BacklogGameCard,
        BacklogListItem,
        ModalBacklog,

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
        }, 
        getBacklogId() {
            BacklogService.getBacklogId()
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
    },

    created() {
        this.getBacklogGames();
        this.getBacklogId();
    }
}

</script>

<style></style>