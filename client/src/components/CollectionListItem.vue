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
                <tr>
                    <th><strong>Status:</strong></th>
                    <td>{{ collectionGame?.status }}</td>
                </tr>
                <tr>
                    <th><strong>Format:</strong></th>
                    <td>{{ collectionGame?.format }}</td>
                </tr>
                <tr>
                    <th><strong>Platform:</strong></th>
                    <td>{{ collectionGame?.platform }}</td>
                </tr>
                <tr>
                    <th><strong>Rating:</strong></th>
                    <td><i id="star-icon" class="fa-solid fa-star" v-for="(star, index) in collectionGame?.rating"
                            v-bind:key="index"></i></td>
                </tr>
                <tr>
                    <th><strong>Notes:</strong></th>
                    <td>{{ collectionGame?.notes }}</td>
                </tr>
            </table>

        </div>

        <div class="items-right">
            <div class="items-right-top">
                <button class="secondary" v-on:click="addGameToBacklog">Add to Backlog<i class="fa-solid fa-gamepad"></i></button>
                <button class="secondary">Edit information <i class="fa-solid fa-pen-to-square"></i></button>
            </div>
            <div class="items-right-bottom">
                <button v-on:click="removeFromCollection" class="secondary">
                    Remove from list<i class="fa-solid fa-trash-can"></i>
                </button>
            </div>

        </div>
    </div>

    <hr>
</template>

<script>
import CollectionService from '../services/CollectionService';
import BacklogService from '../services/BacklogService';

export default {
    data() {
        return {
            gameId: this.game.id,
            backlogGame: {
                "backlogId": this.backlogId,
                "gameId": this.game.id,
                "priority": 3,
                "progress": ""
            },
            collectionGame: null,
        }
    },

    props: ['game', 'collectionId', 'backlogId'],

    methods: {

        removeFromCollection() {
            CollectionService.removeGameFromCollection(this.collectionId, this.gameId)
                .then((response) => {
                    console.log('Successfully deleted game from collection');
                    alert('Successfully removed game from collection');
                    // this.$router.push({ name: 'collection'});
                })
                .catch((error) => {
                    alert('Unable to delete from Collection');
                });
        },
        addGameToBacklog() {
            BacklogService.addGameToBacklog(this.backlogGame)
                .then((response) => {
                    console.log('Added game to backlog');
                    alert('Successfully added to backlog');
                })
                .catch((error) => {
                    alert('Unable to add game to backlog');
                });
        },
        editInfo() {
            this.$emit('edit-info', { gameId: this.gameId, collectionId: this.collectionId });
        },
        getCollectionGame() {
            CollectionService.getCollectionGame(this.collectionId, this.game.id)
                .then((response) => {
                    this.collectionGame = response.data;
                })
                .catch((error) => {
                    console.log('Unable to get collection information');
                    // alert('Unable to get collection information');
                });
        }

    },

    created() {
        this.getCollectionGame();
    }
}

</script>

<style scoped>#star-icon {
    color: rgb(225, 200, 3);
}</style>