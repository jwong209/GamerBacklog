<template>
    <heading v-bind:pageTitle="pageTitle" v-bind:bgImage="bgImage" v-bind:pageDescription="pageDescription" />

    <section>

        <div class="section-heading">
            <h2><i class="fa-solid fa-gamepad"></i>Browse Game Library</h2>
            <div class="section-heading-left">
                <!-- <button id="" class="primary">Get</button> -->
                <button id="" class="secondary" v-on:click="resetSearch">Reset</button>
            </div>
        </div>
        <hr>

        <form v-on:submit.prevent="searchGames" id="game-search-form">
            <label for="search-title">Title</label>
            <input name="search-title" type="text" v-model="searchName" placeholder="  Search by Game Title...">
            <label for="platform-options">Platform</label>
            <select v-model="searchPlatforms" name="platform-options">
                <option value="">All Platforms</option>
                <option v-for="platform in platforms" v-bind:key="platform.id" v-bind:value="platform.id">
                    {{ platform.name }}
                </option>
            </select>
            <label for="genre-options">Genre</label>
            <select v-model="searchGenres" name="genre-options">
                <option value="">All Genres</option>
                <option v-for="genre in genres" v-bind:key="genre.id" v-bind:value="genre.id">
                    {{ genre.name }}
                </option>
            </select>
            <label for="search-metacritic">Metacritic Score</label>
            <input name="search-metacritic" type="text" v-model="searchMetacritic"
                placeholder="  Search by Metacritic Score...">
            <button type="submit">Search</button>
        </form>

        <div class="display-option">
          
            <i class="fa-solid fa-list"></i>
            <!-- <i class="fa-solid fa-grip"></i> -->
            <i class="fa-solid fa-grip-vertical"></i>
        </div>

        <div class="browse-output-container">
            <ul id='returned-game-data-ul'>
                <li v-for="(game, index) in games" v-bind:game="game" v-bind:key="index">
                    <hr>
                    ID: {{ game.id }} | Name: {{ game.name }} | Released: {{ game.released }} | Metacritic: {{
                        game.metacritic }} |
                    User
                    Ratings: {{ game.rating }} | Playtime: {{ game.playtime }}
                </li>
            </ul>
        </div>

        <section class="cards-area">
            <game-card v-for="(game, index) in games" v-bind:game="game" v-bind:key="index" />
        </section>

        <!-- Nav buttons -->
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
import gameService from '../services/GamesService';
import Heading from '../components/HeadingComponent.vue';

export default {
    data() {
        return {
            pageTitle: "Games Library",
            pageDescription: 'Browse from a selection of over 500,000+ titles on 50 platforms ',
            bgImage: 'src/assets/img/george-flowers-blYe0BupDuQ-unsplash.jpg',
            isListVisible: true,
            games: [],
            platforms: [],
            genres: [],
            searchName: '',
            searchPlatforms: '',
            searchGenres: '',
            searchMetacritic: '',
            currentPage: 1,
        }
    },

    components: {
        Heading,
        gameCard,

    },

    methods: {
        searchGames() {
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
                })
                .catch((error) => {
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
            this.games = [];
            this.searchName = '';
            this.searchPlatforms = '';
            this.searchGenres = '';
            this.searchMetacritic = '',
                this.currentPage = 1;
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
        }
    },

    created() {
        this.getPlatforms();
        this.getGenres();
    }
}

</script>

<style scoped>
h1 {
    color: orange;
}

#game-search-form {
    display: flex;
    flex-direction: column;
    row-gap: .4rem;
}

#game-search-form input,
select,
label {
    width: 600px;
}


.display-option {
    display: flex;
    justify-content: flex-end;
    align-items: center;
}

.display-option i {
    margin-right: 1rem;
    font-size: 1.5rem;
    cursor: pointer;
}

#returned-game-data-ul {
    padding: 0;
}

#returned-game-data-ul li {
    list-style: none;
}

.pagination {
    display: flex;
    justify-content: center;
    align-items: center;
}

.pagination span {
    margin: 0 15px;
}
</style>