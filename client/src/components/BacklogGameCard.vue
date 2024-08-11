<template>
    <div class="game-card">
        <div class="game-image-card" :style="{ backgroundImage: `url(${game.background_image})` }"></div>
        <div class="game-data">
            <router-link v-bind:to="{ name: 'game', params: { gameId: gameId } }">
                <h3>{{ game.name }}</h3>
            </router-link>
            <div class="status-item" v-if="game.playtime > 0"><strong>Average Playtime: </strong>{{ game.playtime }} hrs
            </div>
            <div class="status-item" v-if="game.metacritic > 0"><strong>Metacritic: </strong>{{ game.metacritic }} </div>
            <hr>
            <div class="status-item">
                <strong>Priority:</strong> {{ backlogGame?.priority }}
            </div>
            <div v-if="backlogGame?.progress != ''">
                <strong>Progress:</strong>
                <br>
                <div class="card-status-notes">{{ backlogGame?.progress }}</div>
            </div>

            <div class="game-options">
                <button v-on:click="editInfo(game.id)"><i class="fa-solid fa-pen-to-square"></i></button>
                <button title="Add to collection" class="description-button" v-on:click="addGameToCollection"><i
                        class="fa-solid fa-layer-group"></i>
                </button>
                <button><i class="fa-solid fa-trash-can" v-on:click="removeGameFromBacklog" id="removeButton"></i></button>
            </div>

        </div>
    </div>
</template>

<script>
import BacklogService from '../services/BacklogService';
import CollectionService from '../services/CollectionService';

export default {
    data() {
        return {
            gameId: this.game.id,
            backlogGame: null,

            detailsVisible: false,

            collectionGame: {
                "collectionId": this.collectionId,
                "gameId": this.gameId,
                "status": "",
                "format": "",
                "platform": "",
                "rating": null,
                "notes": ""
            }
        }
    },

    props: ['game', 'collectionId', 'backlogId'],

    methods: {
        // removeFromBacklog() {
        //     BacklogService.removeGameFromBacklog(this.backlogId, this.gameId)
        //         .then((response) => {
        //             console.log('Successfully deleted game from backlog');
        //             alert('Successfully removed game from backlog');
        //         })
        //         .catch((error) => {
        //             alert('Unable to delete from Backlog');
        //         });
        // },
        removeGameFromBacklog() {
            this.$store.dispatch('removeGameFromBacklog', { backlogId: this.backlogId, currentGameId: this.gameId })
                .then((response) => {
                    alert('Successfully removed game from backlog');
                })
                .catch((error) => {
                    alert('Unable to delete from Backlog');
                });
        },
        editInfo() {
            this.$emit('edit-info', { gameId: this.gameId, backlogId: this.backlogId });
        },
        getBacklogGame() {
            BacklogService.getBacklogGame(this.backlogId, this.game.id)
                .then((response) => {
                    this.backlogGame = response.data;
                    console.log('Successfully retrieved backlog info');
                })
                .catch((error) => {
                    console.log('Unable to get backlog information');
                    // alert('Unable to get backlog information');
                });
        },
        addGameToCollection() {
            CollectionService.addGameToCollection(this.collectionGame)
                .then((response) => {
                    console.log('Added game to collection with ' + this.collectionId);
                    alert('Successfully added to collection');
                })
                .catch((error) => {
                    alert('Unable to add game to collection');
                });
        }

    },

    created() {
        this.getBacklogGame();

    },

    mounted() {
    }
}

</script>

<style scoped></style>