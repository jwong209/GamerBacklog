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

            <button>Edit Info</button>
            <i class="fa-solid fa-trash-can" v-on:click="removeFromBacklog"></i>
        </div>
    </div>
</template>

<script>
import BacklogService from '../services/BacklogService';

export default {
    data() {
        return {
            backlogId: null,
            gameId: this.game.id,
        }
    },

    props: ['game'],

    methods: {
        getBacklogId() {
            BacklogService.getBacklogId()
                .then((response) => {
                    this.backlogId = response.data;
                    // console.log('This is the GameId:' + this.game.id);
                    // console.log('This is the backlogId:' + this.backlogId);
                })
                .catch((error) => {
                    alert('Unable to retrieve id');
                });
        },

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
        this.getBacklogId();
    }
}

</script>

<style scoped></style>