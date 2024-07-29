<template>
    <header>
        <div class="header">
            <nav class="navbar">
                <div class="nav-left">
                    <div class="brand-title">
                        <router-link v-bind:to="{ name: 'home' }"><img src="../assets/img/site-logo.png"
                                alt="header-site-logo"></router-link>
                    </div>
                    <a href="#" class="toggle-button">
                        <span class="bar"></span>
                        <span class="bar"></span>
                        <span class="bar"></span>
                    </a>

                    <div class="navbar-links">
                        <ul>
                            <li><router-link v-bind:to="{ name: 'collection' }">Collection</router-link></li>
                            <li><router-link v-bind:to="{ name: 'backlog' }">Backlog</router-link></li>
                            <li><router-link v-bind:to="{ name: 'about' }">About</router-link></li>
                            <li></li>
                        </ul>
                    </div>
                </div>


                <div class="nav-right">
                    <div class="nav-darkmode">
                        <i class="fa-solid fa-circle-half-stroke" v-on:click="toggleDarkMode"></i>
                    </div>

                    <form action="/action_page.php">
                        <input type="text" placeholder="Search.." name="search" class="search-pair-input">
                        <button type="submit" class="search-pair-btn"><i class="fa fa-search"></i></button>
                    </form>

                    <!-- <button class="tertiary" v-on:click="handleLogin">Login</button> -->
                    <button class="tertiary">
                        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token">
                            Logout
                        </router-link>
                        <router-link v-bind:to="{ name: 'login' }" v-else>Login</router-link>
                    </button>
                </div>
            </nav>
        </div>
    </header>
</template>

<script>
export default {
    data() {
        return {
            isDarkMode: false,
        }
    },
    methods: {
        toggleDarkMode() {
            this.isDarkMode = !this.isDarkMode;
            document.body.classList.toggle("dark-mode", this.isDarkMode);
        },
        handleLogin() {
            this.$router.push({ name: 'login' })
        }
    }
}

</script>

<style>
header {
    background-color: #6666ff;
    /* position: fixed;   */
    width: 100%;
    top: 0;
    z-index: 1000;
}

.navbar {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin: 0 15%;
}

.navbar-links ul {
    margin: 0;
    padding: 0;
    display: flex;
}

.navbar-links li {
    list-style: none;
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

.toggle-button {
    position: absolute;
    top: .75rem;
    right: 1rem;
    display: none;
    flex-direction: column;
    justify-content: space-between;
    width: 30px;
    height: 21px;
}

.toggle-button .bar {
    height: 3px;
    width: 100%;
    background-color: rgb(255, 255, 255);
    border-radius: 10px;
}

/* ----------------------  NAV LEFT  ---------------------- */
.nav-left {
    display: flex;
    align-items: center;
}

.brand-title {
    display: flex;
    align-items: center;
}

.brand-title img {
    height: 48px;
}

/* ----------------------  NAV RIGHT  ---------------------- */
.nav-right {
    display: flex;
    align-items: center;
    column-gap: 1.5rem;
}

.nav-right button a {
    text-decoration: none;
}

.nav-darkmode i {
    font-size: 20px;
    cursor: pointer;
    color: #1b1ba6;
}

.nav-darkmode i:hover {
    /* animation: super-shake 0.3s; */
    animation: hithere 1s ease infinite;
}


@keyframes hithere {
    30% {
        transform: scale(1.2);
    }

    40%,
    60% {
        transform: rotate(-20deg) scale(1.2);
    }

    50% {
        transform: rotate(20deg) scale(1.2);
    }

    70% {
        transform: rotate(0deg) scale(1.2);
    }

    100% {
        transform: scale(1);
    }
}

@keyframes super-shake {
    0% {
        transform: translate(1px, 1px) rotate(0deg);
    }

    10% {
        transform: translate(-1px, -2px) rotate(-1deg);
    }

    20% {
        transform: translate(-3px, 0px) rotate(1deg);
    }

    30% {
        transform: translate(3px, 2px) rotate(0deg);
    }

    40% {
        transform: translate(1px, -1px) rotate(1deg);
    }

    50% {
        transform: translate(-1px, 2px) rotate(-1deg);
    }

    60% {
        transform: translate(-3px, 1px) rotate(0deg);
    }

    70% {
        transform: translate(3px, 1px) rotate(-1deg);
    }

    80% {
        transform: translate(-1px, -1px) rotate(1deg);
    }

    90% {
        transform: translate(1px, 2px) rotate(0deg);
    }

    100% {
        transform: translate(1px, -2px) rotate(-1deg);
    }
}

/* ---------------------------------  DARK MODE SETTINGS  --------------------------------- */
.dark-mode {
    header {
        background-color: #0b041a;
    }

    .nav-darkmode i {
        color: white;
    }
}
</style>