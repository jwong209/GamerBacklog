<template>
    <div class="modal-backdrop">
        <div class="navbar-links">
            <button id="close-btn" v-on:click="$emit('close-nav-menu')"><i class="fa-regular fa-rectangle-xmark" ></i></button>
            <ul>
                <li><router-link v-bind:to="{ name: 'games' }">Browse</router-link></li>
                <li><router-link v-bind:to="{ name: 'collection' }">Collection</router-link></li>
                <li><router-link v-bind:to="{ name: 'backlog' }">Backlog</router-link></li>
                <li><router-link v-bind:to="{ name: 'about' }">About</router-link></li>
            </ul>
        </div>
    </div>
</template>

<script>

</script>

<style scoped>
#close-btn {
    background-color: transparent;
    margin-bottom: 20px;
    border: none;
    margin: 10px;
}
#close-btn i {
    font-size: 25px;
    color: white;

}

.modal-backdrop {
    position: fixed;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    background-color: rgba(0, 0, 0, 0.3);
    display: flex;
    justify-content: center;
}

.navbar-links {
    background-color: rgb(24, 30, 67);
    /* width: 100%; */
    display: flex;
    flex-direction: column;
    align-items: flex-end;
    height: 280px;
}

.navbar-links ul {
    margin: 0;
    padding: 0;
    display: flex;
    flex-direction: column;
}

.navbar-links li {
    list-style: none;
    text-align: center;
}

.navbar-links li a {
    text-decoration: none;
    padding: 1rem;
    display: block;
    color: white;
}

.navbar-links li:hover {
    background-color: #4028f5;
}
</style>