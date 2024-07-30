<template>

    <div class="game-card">
        <div class="game-image"></div>
        <div class="game-data">
            <p>Title: {{ game.name }}</p>
            <p>Released: {{ game.released }}</p>
            <p>Playtime: {{ game.playtime }}</p>
            <p>Metacritic: {{ game.metacritic }} </p>
            <button class="description-button" v-on:click="addToCollection">Add Collection</button>
            <button class="description-button">Add Backlog</button>
        </div>
        <div class="game-bottom">
            
            <!-- <i class="fa-solid fa-trash-can"></i> -->
        </div>
    </div>

</template>

<script>
import CollectionService from '../services/CollectionService';

export default {
    data() {
        return {
            collectionId : null,
            gameId: this.game.id,
        }
    },
    props: ['game'],

    methods: {
        getCollectionId() {
            CollectionService.getCollectionId()
                .then((response) => {
                    // console.log('This is the GameId:' + this.game.id);
                    // console.log('This is the CollectionId:' + this.collectionId);
                    this.collectionId = response.data;
                })
                .catch((error) => {
                    alert('Unable to retrieve id');
                });
        },
        addToCollection(collectionId, gameId) {
            CollectionService.addGametoCollection(this.collectionId, this.gameId)
                .then(() => {
                    console.log('Successfully added game with id ' + this.gameId);
                    alert('Successfully added to collection');
                }) 
                .catch( (error) => {
                    alert('Unable to add to collection');
                });
        }
    },

    created() {
        this.getCollectionId();
    }

    
}

</script>

<style scoped>
/* ----------------------  GAME CARDS  ---------------------- */
/* .game-area-heading {
    display: flex;
    justify-content: space-between;
    align-items: center;
    flex-wrap: wrap;
    margin-bottom: 20px;
} */

.game-card {
    /* width: 23%; */
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
    /* display: flex;
    justify-content: space-between;
    align-items: center; */
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

</style>