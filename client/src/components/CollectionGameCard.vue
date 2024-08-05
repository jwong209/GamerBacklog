<template>
    <div class="game-card">
        <div class="game-image-card" :style="{ backgroundImage: `url(${game.background_image})` }"></div>
        <div class="game-data">
            <p>{{ game.name }}</p>
            <p>Released: {{ game.released }}</p>
            <p>Platform: </p>
            <!-- <p>Genres: </p> -->
            <p v-if="game.playtime > 0">Playtime: {{ game.playtime }} hrs</p>
            <p v-if="game.metacritic > 0">Metacritic: {{ game.metacritic }} </p>
            <button v-on:click="editInfo(game.id)">Edit Info</button>
            <button class="description-button" v-on:click="addGameToBacklog">Add to Backlog</button>
            <i class="fa-solid fa-trash-can" v-on:click="removeFromCollection" id="removeButton"></i>
        </div>
    </div>
</template>

<script>
import CollectionService from '../services/CollectionService';
import BacklogService from '../services/BacklogService';
import '../assets/main.css'

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
        }

    },

    created() {
    }
}

</script>

<style scoped>
#removeButton:hover {
    cursor: pointer;
}
</style>