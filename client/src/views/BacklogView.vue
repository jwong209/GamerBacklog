<template>
    <heading v-bind:pageTitle="pageTitle" v-bind:bgImage="bgImage" v-bind:pageDescription="pageDescription" />

    <section>
        <h2></h2>

        <div class="section-heading">
            <h2><i class="fa-solid fa-gamepad"></i>Found {{ games.length }} games</h2>

            <form action="/action_page.php" id="search-list">
                <input type="text" placeholder="Search my backlog" name="search" class="search-pair-input">
                <button type="submit" class="search-pair-btn"><i class="fa fa-search"></i></button>
            </form>

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

        <div class="display-area">
            <filter-options />
            <loading-spinner v-if="isLoading" v-bind:spin="isLoading" />


            <!-- <ul>
                <li v-for="(game, index) in games" v-bind:game="game" v-bind:key="index">
                    ID: {{ game.id }} Name: {{ game.name }} Released: {{ game.released }} Metacritic: {{ game.metacritic }}
                    UserRatings: {{ game.rating }} Playtime: {{ game.playtime }}
                </li>
            </ul> -->
            <div class="list-area" v-show="isListVisible === true">
                <backlog-list-item v-for="(game, index) in games" v-bind:game="game" v-bind:key="index"
                    v-bind:backlogId="backlogId" />
            </div>


            <div class="cards-area" v-show="isListVisible === false">
                <!-- <backlog-game-card v-for="(game, index) in games" v-bind:game="game" v-bind:key="index" v-bind:backlogId="backlogId" v-on:edit-info="editInfo = $event; showModal = true" /> -->
                <backlog-game-card v-for="(game, index) in games" v-bind:game="game" v-bind:key="index"
                    v-bind:backlogId="backlogId" v-on:edit-info="editInfo" />
            </div>
        </div>

    </section>

    <modal-backlog v-if="showModal" v-bind:selectedGameId="selectedGameId" v-bind:backlogId="backlogId"
        v-on:close="showModal = false" />
</template>

<script>
import BacklogService from '../services/BacklogService';
import Heading from '../components/HeadingComponent.vue';
import BacklogGameCard from '../components/BacklogGameCard.vue';
import BacklogListItem from '../components/BacklogListItem.vue';
import ModalBacklog from '../components/ModalBacklog.vue';
import LoadingSpinner from '../components/LoadingSpinner.vue';
import FilterOptions from '../components/FilterOptions.vue';


export default {
    data() {
        return {
            isLoading: true,
            isListVisible: false,
            games: [],
            pageTitle: "Backlog",
            pageDescription: "Games that you'll get to later",
            bgImage: 'src/assets/img/pxfuel02.jpg',
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
        LoadingSpinner,
        FilterOptions,

    },

    methods: {
        getBacklogGames() {
            this.isLoading = true;

            BacklogService.getGamesInBacklog()
                .then((response) => {
                    this.games = response.data;
                    this.isLoading = false;
                })
                .catch((error) => {
                    this.isLoading = false;
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