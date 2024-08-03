<template>
    <div class="game-card">
        <div class="game-image-card" :style="{ backgroundImage: `url(${game.background_image})` }"></div>
        <div class="game-data">
            <p>Title: {{ game.name }}</p>
            <p>Released: {{ game.released }}</p>
            <p>Platforms: </p>
            <p>Genres: </p>
            <p v-if="game.playtime > 0">Playtime: {{ game.playtime }} hrs</p>
            <p v-if="game.metacritic > 0">Metacritic: {{ game.metacritic }} </p>

            <button v-on:click="editInfo(game.id)">Edit Info</button>
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
        }

    },

    created() {
    }
}

</script>

<style scoped>

</style>