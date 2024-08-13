<template>
    <div class="item-container">
        <div class="items-left">
            <div class="game-image-list" :style="{ backgroundImage: `url(${game.background_image})` }"></div>
            <div>
                <p>Name: {{ game.name }}</p>
                <p>Released: {{ game.released }}</p>
                <p>Metacritic: {{ game.metacritic }}</p>
                <p>User Ratings: {{ game.rating }}</p>
                <p>Playtime: {{ game.playtime }}</p>
            </div>
        </div>
        <div class="items-right">
            <div class="items-right-top">
                <button class="description-button" v-on:click="addGameToBacklog">Add to Backlog</button>
                <button>Edit information</button>
            </div>
            <div class="items-right-bottom">
                <button id="removeButton" v-on:click="removeFromCollection">
                    <i class="fa-solid fa-trash-can"  ></i> Remove from list
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

    },

    created() {
    }
}

</script>

<style scoped>


</style>