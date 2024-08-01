<template>
    <div class="game-card">
        <div class="game-image"></div>
        <div class="game-data">
            <p>Title: {{ game.name }}</p>
            <p>Released: {{ game.released }}</p>
            <p>Platforms: </p>
            <p>Genres: </p>
            <p v-if="game.playtime > 0">Playtime: {{ game.playtime }} hrs</p>
            <p v-if="game.metacritic > 0">Metacritic: {{ game.metacritic }} </p>

            <button class="description-button" v-on:click="addGameToBacklog">Add to Backlog</button>
            <!-- <button class="description-button">Description</button> -->
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
            collectionId: null,
            backlogId: null,
            gameId: this.game.id,
        }
    },

    props: ['game'],

    methods: {
        getCollectionId() {
            CollectionService.getCollectionId()
                .then((response) => {
                    this.collectionId = response.data;
                    console.log('This is the GameId:' + this.game.id);
                    console.log('This is the CollectionId:' + this.collectionId);
                })
                .catch((error) => {
                    alert('Unable to retrieve id');
                });
        },
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
            BacklogService.addGameToBacklog() 
                .then((response) => {
                    console.log('Added game to backlog');
                }) 
                .catch((error) => {
                    alert('Unable to add game to backlog');
                });
        },

    },

    created() {
        this.getCollectionId();
    }
}

</script>

<style scoped>
#removeButton:hover {
    cursor: pointer;
}
</style>