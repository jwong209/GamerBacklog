<template>
 
    <div class="item-container">
        
        <div class="items-left">
            <div class="game-image-list" :style="{ backgroundImage: `url(${game.background_image})` }"></div>
        </div>

        <div class="items-mid">
            <h3>{{ game.name }}</h3>
            <p><strong>Released: </strong>{{ game.released }}</p>
            <p><strong>Metacritic: </strong>{{ game.metacritic }}</p>
            <p><strong>User Ratings: </strong>{{ game.rating }}</p>
            <p><strong>Playtime: </strong>{{ game.playtime }}</p>
        </div>

        <div class="items-right">
            <div class="items-right-top">
                <button class="secondary" v-on:click="addToCollection">
                    Add to Collection<i class="fa-solid fa-layer-group"></i> 
                </button>
                <button class="secondary" v-on:click="addToBacklog"> 
                    Add to Backlog<i class="fa-solid fa-gamepad"></i>
                </button>
            </div>
            <div class="items-right-bottom">
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
    }

}
</script>

<style scoped></style>