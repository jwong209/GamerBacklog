<template>
    <div class="game-card">
        <div class="game-image-card" :style="{ backgroundImage: `url(${game.background_image})` }"></div>
        <div class="game-data">
            <router-link v-bind:to="{ name: 'game', params: { gameId: gameId } }"><h3>{{ game.name }}</h3></router-link>
            <!-- <p>Released: {{ game.released }}</p> -->
            <!-- <p>Genres: </p> -->
            <!-- <p v-if="game.playtime > 0">Avg. Playtime: {{ game.playtime }} hrs</p> -->
            <!-- <p v-if="game.metacritic > 0">Metacritic: {{ game.metacritic }} </p> -->
            <p>Status: {{ collectionGame?.status }}</p>
            <p>Format: {{ collectionGame?.format }}</p>
            <p>Platform: {{ collectionGame?.platform }}</p>
            <p v-if="collectionGame?.rating > 0">Rating: <i id="star-icon" class="fa-solid fa-star" v-for="(star, index) in collectionGame?.rating" v-bind:key="index"></i></p>
            <p>Notes: {{ collectionGame?.notes }}</p>

            <div class="game-options">
                <button v-on:click="editInfo(game.id)"><i class="fa-solid fa-pen-to-square"></i> Edit Info</button>
                <button class="description-button" v-on:click="addGameToBacklog">Add to Backlog</button>
                <i class="fa-solid fa-trash-can" v-on:click="removeGameFromCollection" id="removeButton"></i>

            </div>
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
            collectionGame: null,
        }
    },

    props: ['game', 'collectionId', 'backlogId'],

    methods: {
       
        // removeFromCollection() {
        //     CollectionService.removeGameFromCollection(this.collectionId, this.gameId)
        //         .then((response) => {
        //             console.log('Successfully deleted game from collection');
        //             alert('Successfully removed game from collection');
        //         })
        //         .catch((error) => {
        //             alert('Unable to delete from Collection');
        //         });
        // },
        removeGameFromCollection() {
            this.$store.dispatch('removeGameFromCollection', { collectionId: this.collectionId, currentGameId: this.gameId })
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

<style scoped>
#removeButton:hover {
    cursor: pointer;
}

#star-icon {
    color: rgb(225, 200, 3);
}



</style>