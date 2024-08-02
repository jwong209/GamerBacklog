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
                <button>Edit Info</button>
            </div>
            <div class="items-right-bottom">
                <button v-on:click="removeFromBacklog"><i class="fa-solid fa-trash-can" id="removeButton"></i> Delete</button>
            </div>
            
        </div>
    </div>

    <hr>
</template>

<script>
import BacklogService from '../services/BacklogService';

export default {
    data() {
        return {
            // backlogId: null,
            gameId: this.game.id,
        }
    },

    props: ['game', 'backlogId'],

    methods: {
        // getBacklogId() {
        //     BacklogService.getBacklogId()
        //         .then((response) => {
        //             this.backlogId = response.data;
        //             // console.log('This is the GameId:' + this.game.id);
        //             // console.log('This is the backlogId:' + this.backlogId);
        //         })
        //         .catch((error) => {
        //             alert('Unable to retrieve id');
        //         });
        // },

        removeFromBacklog() {
            BacklogService.removeGameFromBacklog(this.backlogId, this.gameId)
                .then((response) => {
                    console.log('Successfully deleted game from backlog');
                    alert('Successfully removed game from backlog');
                })
                .catch((error) => {
                    alert('Unable to delete from Backlog');
                });
        }

    },

    created() {
        // this.getBacklogId();
    }
}

</script>

<style scoped>

</style>