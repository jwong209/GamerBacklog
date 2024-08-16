<template>
    <div class="game-card">
        <div class="game-image-card" :style="{ backgroundImage: `url(${game.background_image})` }"></div>
        <div class="game-data">
            <router-link v-bind:to="{ name: 'game', params: { gameId: gameId } }">
                <h3>{{ game.name }}</h3>
            </router-link>
            <div class="status-item" v-if="game.playtime > 0"><strong>Average Playtime: </strong>{{ game.playtime }} hrs</div>
            <div class="status-item" v-if="game.metacritic > 0"><strong>Metascore: </strong>{{ game.metacritic }} </div>
            <div class="status-item"><strong>User Rating: </strong>{{ game.rating }} / 5</div>
            <div class="status-item"><strong>Released: </strong>{{ game.released }}</div>
            <!-- <button class="description-button" v-on:click="addToCollection"><i class="fa-solid fa-layer-group"></i> Add to
                Collection</button>
            <button class="description-button" v-on:click="addToBacklog"><i class="fa-solid fa-gamepad"></i> Add to
                Backlog</button> -->

            <div class="game-options">
                <button title="Add to collection" class="description-button" v-on:click="addToCollection"><i class="fa-solid fa-layer-group"></i>
                </button>
                <button title="Add to backlog" class="description-button" v-on:click="addToBacklog"><i class="fa-solid fa-gamepad"></i>
                </button>
                <button v-on:click="testing"><i class="fa-solid fa-heart"></i></button>

            </div>
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
            collectionGame: {
                "collectionId": this.collectionId,
                "gameId": this.game.id,
                "status": "",
                "format": "",
                "platform": "",
                "rating": null,
                "notes": ""
            }
        }
    },
    props: ['game', 'collectionId', 'backlogId'],

    components: {
    },

    methods: {
        addToCollection() {
            this.$emit('gameAddedSuccess', { popupText:'Game successfully added to Collection.' });

            CollectionService.addGameToCollection(this.collectionGame)
                .then((response) => {
                    console.log('Successfully added game with id ' + this.gameId);
                    // alert('Successfully added to collection');
                })
                .catch((error) => {
                    alert('Unable to add to collection');
                });
        },
        addToBacklog() {
            console.log(this.backlogGame);
            this.$emit('gameAddedSuccess', { popupText:'Game successfully added to Backlog.' });


            BacklogService.addGameToBacklog(this.backlogGame)
                .then((response) => {
                    console.log('Added game to backlog');
                    // alert('Successfully added to backlog');

                })
                .catch((error) => {
                    alert('Unable to add game to backlog');
                });
        },
        testing() {
            this.$emit('testingButtonOK', {popupText: ' Testing this popup'});
        }

    },

}
</script>

<style scoped>

</style>