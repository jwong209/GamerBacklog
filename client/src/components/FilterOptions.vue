<template>
    <div class="filter-container">

        <div class="filter-card">
            <div class="filter-heading">
                <h4>Format</h4>
            </div>
            <ul>
                <li>Digital</li>
                <li>Physical</li>
            </ul>
        </div>

        <div class="filter-card">
            <div class="filter-heading">
                <h4>Genre</h4>
            </div>
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
</template>

<script>

</script>

<style scoped>
.filter-card {
    width: 230px;
    border: 1px solid grey;
    border-radius: 3px;
    margin-bottom: 10px;
}

.filter-heading {
    background-color: rgb(202, 202, 202);
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

li:hover {
    background-color: rgb(226, 226, 226);
    cursor: pointer;
}

.dark-mode {
    .filter-heading {
        background-color: rgb(60, 68, 105);
    }
}
</style>