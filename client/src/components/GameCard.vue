<template>
    <div class="game-card">
        <div class="game-image"></div>
        <div class="game-data">
            <p>Title: {{ game.name }}</p>
            <p>Released: {{ game.released }}</p>
            <p>Playtime: {{ game.playtime }} hrs</p>
            <p>Metacritic: {{ game.metacritic }} </p>
            <p>User Ratings: {{ game.rating }}</p>
            <button class="description-button" v-on:click="addToCollection">Add to Collection</button>
            <button class="description-button" v-on:click="addToBacklog">Add to Backlog</button>
            <p>Here is gameId: {{ game.id }}</p>
            <p>Here is collectionId: {{ collectionId }}</p>
            <p>Here is backlogId: {{ backlogId }}</p>

            <button type="button" class="btn" @click="$emit('open-modal')">Open Modal!</button>
        </div>
    </div>
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

    components: {
    },

    methods: {
        addToCollection() {
            CollectionService.addGameToCollection(this.collectionId, this.gameId)
                .then((response) => {
                    console.log('Successfully added game with id ' + this.gameId);
                    alert('Successfully added to collection');
                })
                .catch((error) => {
                    alert('Unable to add to collection');
                });
        },
        addToBacklog() {
            console.log(this.backlogGame);

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