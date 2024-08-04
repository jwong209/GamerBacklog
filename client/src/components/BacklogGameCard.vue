<template>
    <div class="game-card">
        <div class="game-image-card" :style="{ backgroundImage: `url(${game.background_image})` }"></div>
        <div class="game-data">
            <h3>{{ game.name }}</h3>
            <p><strong>Released: </strong>{{ game.released }}</p>
            <p v-if="game.playtime > 0"><strong>Playtime: </strong>{{ game.playtime }} hrs</p>
            <p v-if="game.metacritic > 0"><strong>Metacritic: </strong>{{ game.metacritic }} </p>
            
            <div v-if="detailsVisible">
                <hr>
                <h4>Backlog Status</h4>
                <p>Priority: {{ backlogGame.priority }}</p>
                <p>Progress: {{ backlogGame.progress }}</p>
                <button v-on:click="editInfo(game.id)">Edit Info</button>
            </div>

            <button v-on:click="detailsVisible = !detailsVisible">Backlog Status</button>


            <button><i class="fa-solid fa-trash-can" v-on:click="removeFromBacklog" id="removeButton"></i></button>
           
        </div>
    </div>
</template>

<script>
import BacklogService from '../services/BacklogService';

export default {
    data() {
        return {
            gameId: this.game.id,
            backlogGame: null,

            detailsVisible: false,
        }
    },

    props: ['game', 'backlogId'],

    methods: {
        removeFromBacklog() {
            BacklogService.removeGameFromBacklog(this.backlogId, this.gameId)
                .then((response) => {
                    console.log('Successfully deleted game from backlog');
                    alert('Successfully removed game from backlog');
                })
                .catch((error) => {
                    alert('Unable to delete from Backlog');
                });
        },
        editInfo() {
            this.$emit('edit-info', { gameId: this.gameId, backlogId: this.backlogId });
        },
        getBacklogGame() {
            BacklogService.getBacklogGame(this.backlogId, this.gameId)
                .then((response) => {
                    this.backlogGame = response.data;
                    console.log('Successfully retrieved backlog info');
                })
                .catch((error) => {
                    alert('Unable to get backlog information');
                });
        }

    },

    created() {
        this.getBacklogGame();

    },

    mounted() {
    }
}

</script>

<style scoped></style>