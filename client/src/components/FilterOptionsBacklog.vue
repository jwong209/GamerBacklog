<template>
    <div class="filter-container">

        <div class="filter-card">
            <div class="filter-heading">
                <h4>Priority</h4>
            </div>
            <div class="filter-body non-list-item">
                <select id="priority" name="priority">
                  <option value="3">-----</option>
                  <option value="1">1 (Low)</option>
                  <option value="2">2</option>
                  <option value="3">3 (Medium)</option>
                  <option value="4">4</option>
                  <option value="5">5 (High)</option>
                </select>
            </div>
        </div>

        <div class="filter-card">
            <div class="filter-heading">
                <h4>Metacritic Score</h4>
            </div>
            <div class="filter-body non-list-item">
                <form v-on:submit.prevent>
                    <label>Min Score:</label>
                    <input type="number" id="metacritic-input">
                    <button>></button>
                </form>
            </div>
        </div>

        <div class="filter-card">
            <div class="filter-heading">
                <h4>Platform</h4>
            </div>
            <div class="filter-body">
                <ul>
                    <li>Nintendo Switch</li>
                    <li>PC</li>
                    <li>Playstation 5</li>
                    <li>Playstation 4</li>
                    <li>Xbox Series X/S</li>
                    <li>Xbox One</li>
                </ul>
            </div>
        </div>



        <div class="filter-card">
            <div class="filter-heading">
                <h4>Genre</h4>
            </div>
            <div class="filter-body">
                <ul>
                    <li>Action</li>
                    <li>Indie</li>
                    <li>Adventure</li>
                    <li>RPG</li>
                    <li>Strategy</li>
                    <li>Shooter</li>
                    <li>Casual</li>
                    <li>Simulation</li>
                    <li>Puzzle</li>
                    <li>Arcade</li>
                    <li>Platformer</li>
                    <li>Racing</li>
                    <li>Massively Multiplayer</li>
                    <li>Sports</li>
                    <li>Fighting</li>
                    <li>Family</li>
                    <li>Board Games</li>
                    <li>Educational</li>
                    <li>Card</li>
                </ul>
            </div>
        </div>


    </div>
</template>

<script>

export default {
    data() {
        return {

        }
    }, 

    props: [],
}

</script>

<style scoped>
.filter-card {
    width: 210px;
    border: 1px rgb(173, 175, 214) solid;
    border-radius: 3px;
    margin-bottom: 10px;
}

.filter-heading {
    background-color: rgb(219, 219, 242);
    padding: 8px;
    border-radius: 3px 3px 0 0;
}

.filter-heading h4 {
    margin: 0;
}

ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
}

li {
    width: 100%;
    padding: 3px 8px 3px 8px;
}
.non-list-item {
    padding: 5px 8px 5px 8px;
}

li:hover {
    background-color: rgb(180, 180, 241);
    cursor: pointer;
}

#priority {
    /* width: 50px; */
    margin-left: 5px;
}


#metacritic-input {
    width: 50px;
    margin-left: 5px;
}

.dark-mode {
    .filter-heading {
        background-color: rgb(60, 68, 105);
    }
}
</style>