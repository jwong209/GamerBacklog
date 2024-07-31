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
        </div>
        <div class="game-bottom">
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
                    console.log('This is the GameId:' + this.game.id);
                    console.log('This is the backlogId:' + this.backlogId);
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

<style>
/* ----------------------  GAME CARDS  ---------------------- */
.game-area-heading {
    display: flex;
    justify-content: space-between;
    align-items: center;
    flex-wrap: wrap;
    margin-bottom: 20px;
}

.game-card {
    width: 23%;
    border-radius: 8px;
    box-shadow: 0px 0px 3px rgba(0, 0, 0, 0.3), 0px 11px 14px rgba(0, 0, 0, 0.1);
    background-color: rgb(255, 255, 255);
    /* display: flex; */
    /* column-gap: 1rem; */
    position: relative;
}

#game-card-area {
    display: flex;
    justify-content: center;
    gap: 20px;
    flex-flow: row wrap;
    border: 1px red dotted;
}


/* ---------- Game Image ----------*/
.game-image {
    height: 275px;
    background-color: #7a7a7a;
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    border-radius: 8px 8px 0 0;
}

/* ---------- Game Data ----------*/
.game-data-heading {
    margin: 0;
}

.game-data-area p {
    margin-top: 0;
}

.game-data-area {
    margin-top: 0;
    padding: 0 15px 50px 15px;
}

/* ---------- Game Bottom ----------*/
.game-bottom {
    width: 100%;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 15px;
    /* margin-top: 10px; */
    position: absolute;
    bottom: 0;
}

.description-button {
    cursor: pointer;
    padding: 5px 10px;
    background-color: transparent;
    color:purple;
    border: 1px solid purple;

    border-radius: 25px;
}

.description-button:hover {
    background-color: purple;
    color: white;
}

.trash-icon {
    cursor: pointer;
    font-size: 20px;
}

.trash-icon:hover {
    color: orange;
}

</style>