<template>
    <heading v-bind:pageTitle="pageTitle" v-bind:bgImage="bgImage" v-bind:pageDescription="pageDescription" />

    <section>
        <form v-on:submit.prevent="searchGames" id="game-search-form">

            <div class="search-form-inputs">
                <label for="search-title">Title</label>
                <input name="search-title" type="text" v-model="searchName" placeholder="  Search by Game Title...">
                <label for="platform-options">Platform</label>
                <select v-model="searchPlatforms" name="platform-options">
                    <option value="">-- All Platforms --</option>
                    <option v-for="platform in platforms" v-bind:key="platform.id" v-bind:value="platform.id">
                        {{ platform.name }}
                    </option>
                </select>
            </div>
            <div class="search-form-inputs">
                <label for="genre-options">Genre</label>
                <select v-model="searchGenres" name="genre-options">
                    <option value="">-- All Genres --</option>
                    <option v-for="genre in genres" v-bind:key="genre.id" v-bind:value="genre.id">
                        {{ genre.name }}
                    </option>
                </select>
                <label for="search-metacritic">Metacritic Score</label>
                <input name="search-metacritic" type="text" v-model="searchMetacritic"
                    placeholder="  Search by Metacritic Score...">
            </div>

            <div id="search-controls">
                <button type="submit" class="primary">Search</button>
                <button id="" class="secondary" v-on:click="resetSearch">Reset</button>
            </div>
        </form>

        <div class="section-heading">
            <h2><i class="fa-solid fa-gamepad"></i>Browse Game Library</h2>
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
            <game-list-item v-for="(game, index) in games" v-bind:game="game" v-bind:key="index"
                v-bind:collectionId="collectionId" v-bind:backlogId="backlogId" />
        </div>
        <div class="cards-area" v-show="isListVisible === false">
            <game-card v-for="(game, index) in games" v-bind:game="game" v-bind:key="index"
                v-bind:collectionId="collectionId" v-bind:backlogId="backlogId" />
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
</template>

<script>
import gameCard from '../components/GameCard.vue';
import GameListItem from '../components/GameListItem.vue';
import gameService from '../services/GamesService';
import Heading from '../components/HeadingComponent.vue';
import CollectionService from '../services/CollectionService';
import BacklogService from '../services/BacklogService';
import LoadingSpinner from '../components/LoadingSpinner.vue';


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
        }
    },

    components: {
        Heading,
        gameCard,
        GameListItem,
        LoadingSpinner,

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
            gameService.searchGames(params)
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
            gameService.getPlatforms()
                .then((response) => {
                    this.platforms = response.data;
                })
                .catch((error) => {
                    alert('Unable to fetch platforms');
                });
        },
        getGenres() {
            gameService.getGenres()
                .then((response) => {
                    this.genres = response.data;
                })
                .catch((error) => {
                    alert('Unable to fetch genres');
                });
        },
        getCollectionId() {
            CollectionService.getCollectionId()
                .then((response) => {
                    this.collectionId = response.data;
                })
                .catch((error) => {
                    // alert('Unable to retrieve collectionId');
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

    },

    created() {
        this.getPlatforms();
        this.getGenres();
        this.getBacklogId();
        this.getCollectionId();
        this.searchGames();
    }
}

</script>

<style scoped>
.display-button {
    width: 50px;
    padding: 4px 0px 1px 12px;
    cursor: pointer;

}

#game-search-form {
    display: flex;
    row-gap: .5rem;
    background-color: rgb(200, 200, 200);
    border-radius: 5px;
    padding: 15px;

}

#game-search-form input,
select,
label {
    width: 500px;
}

.search-form-inputs {
    border: 1px dotted purple;
    display: flex;
    flex-direction: column;
}

#search-controls button {
    margin: 0 5px;
    width: 120px;
}

.display-option {
    display: flex;
    justify-content: flex-end;
    align-items: center;
}

.display-option i {
    font-size: 1.5rem;
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


</style>