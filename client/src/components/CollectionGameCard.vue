<template>

    <div class="game-card">
        <div class="game-image"></div>
        <div class="game-data">
            <p>Title: </p>
            <p>Platorm:  </p>
            <p>Genre:  </p>
            <p>Metacritic: </p>
        </div>
        <div class="game-bottom">
            <button class="description-button">Description</button>
            <i class="fa-solid fa-trash-can"></i>
        </div>
    </div>

</template>

<script>

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

@keyframes shake {
    0% {transform: rotate(0deg);}
    20% {transform: rotate(-4deg);}
    50% {transform: rotate(0deg);}
    70% {transform: rotate(4deg);}
    100% {transform: rotate(0deg);}
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