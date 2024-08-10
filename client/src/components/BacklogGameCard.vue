<template>
    <div class="game-card">
        <div class="game-image-card" :style="{ backgroundImage: `url(${game.background_image})` }"></div>
        <div class="game-data">
            <router-link v-bind:to="{ name: 'game', params: { gameId: gameId } }"><h3>{{ game.name }}</h3></router-link>
            <p v-if="game.playtime > 0"><strong>Average Playtime: </strong>{{ game.playtime }} hrs</p>
            <p v-if="game.metacritic > 0"><strong>Metacritic: </strong>{{ game.metacritic }} </p>
            <p><strong>Priority:</strong> {{ backlogGame?.priority }}</p>
            <p v-if="backlogGame.progress != ''"><strong>Progress:</strong> <br>{{ backlogGame?.progress }}</p>

            <div class="game-options">
                <button v-on:click="editInfo(game.id)"><i class="fa-solid fa-pen-to-square"></i></button>
                <button><i class="fa-solid fa-trash-can" v-on:click="removeGameFromBacklog" id="removeButton"></i></button>
            </div>

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
        // removeFromBacklog() {
        //     BacklogService.removeGameFromBacklog(this.backlogId, this.gameId)
        //         .then((response) => {
        //             console.log('Successfully deleted game from backlog');
        //             alert('Successfully removed game from backlog');
        //         })
        //         .catch((error) => {
        //             alert('Unable to delete from Backlog');
        //         });
        // },
        removeGameFromBacklog() {
            this.$store.dispatch('removeGameFromBacklog', { backlogId: this.backlogId, currentGameId: this.gameId })
                .then((resposne) => {
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
            BacklogService.getBacklogGame(this.backlogId, this.game.id)
                .then((response) => {
                    this.backlogGame = response.data;
                    console.log('Successfully retrieved backlog info');
                })
                .catch((error) => {
                    console.log('Unable to get collection information');
                    // alert('Unable to get backlog information');
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