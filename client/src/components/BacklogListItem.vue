<template>
    <div class="item-container">
        <div class="items-left">
            <div class="game-image-list" :style="{ backgroundImage: `url(${game.background_image})` }"></div>
        </div>
        <div class="items-mid">
            <router-link v-bind:to="{ name: 'game', params: { gameId: gameId } }">
                <h3>{{ game.name }}</h3>
            </router-link>
            
            <table>
                <tr v-if="game.metacritic > 0">
                    <th><strong>Metacritic:</strong></th><td>{{ game.metacritic }}</td>
                </tr>
                <tr>
                    <th><strong>User Ratings:</strong></th><td> {{ game.rating }}</td>
                </tr>
                <tr>
                    <th><strong>Average Playtime:</strong></th><td>{{ game.playtime }} hrs</td>
                </tr>
                <tr>
                    <th><strong>Priority:</strong></th><td>{{ backlogGame?.priority }}</td>
                </tr>
                <tr>
                    <th><strong>Progress:</strong></th><td class="list-progress-data">{{ backlogGame?.progress }}</td>
                </tr>
            </table>
            <!-- <p>Released: {{ game.released }}</p> -->
            <!-- <div><strong>Metacritic:</strong> {{ game.metacritic }}</div>
            <div><strong>User Ratings:</strong> {{ game.rating }}</div>
            <div><strong>Average Playtime:</strong> {{ game.playtime }} hrs</div>
            <hr>
            <div><strong>Priority:</strong> {{ backlogGame?.priority }}</div>
            <div><strong>Progress:</strong> <br> {{ backlogGame?.progress }}</div> -->
        </div>

        <div class="items-right">
            <div class="items-right-top">
                <button class="secondary">Edit information <i class="fa-solid fa-pen-to-square"></i></button>
                <button class="secondary">Add to Collection <i class="fa-solid fa-layer-group"></i></button>
            </div>
            <div class="items-right-bottom">
                <button v-on:click="removeFromBacklog" class="secondary">
                    Remove from list<i class="fa-solid fa-trash-can" id="removeButton"></i>
                </button>
            </div>
        </div>
    </div>
    
    <hr>

</template>

<script>
import BacklogService from '../services/BacklogService';
import CollectionService from '../services/CollectionService';

export default {
    data() {
        return {
            gameId: this.game.id,
            backlogGame: null,
            collectionGame: {
                "collectionId": this.collectionId,
                "gameId": this.game.id,  // cannot access by gameId, access through the prop 'game'
                "status": "",
                "format": "",
                "platform": "",
                "rating": null,
                "notes": ""
            }
        }
    },

    props: ['game', 'backlogId', 'collectionId'],

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
            BacklogService.getBacklogGame(this.backlogId, this.gameId)
                .then((response) => {
                    this.backlogGame = response.data;
                    console.log('Successfully retrieved backlog info');
                })
                .catch((error) => {
                    alert('Unable to get backlog information');
                });
        },
        addGameToCollection() {
            CollectionService.addGameToCollection(this.collectionGame)
                .then((response) => {
                    // console.log('Added game to collection with collectionId: ' + this.collectionId);
                    alert('Successfully added to collection');
                })
                .catch((error) => {
                    alert('Unable to add game to collection');
                });
        }

    },

    created() {
        this.getBacklogGame();
    }
}
</script>

<style scoped>
</style>