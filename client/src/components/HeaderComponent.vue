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
                            <li><router-link v-bind:to="{ name: 'games' }">Browse</router-link></li>
                            <li><router-link v-bind:to="{ name: 'collection' }">Collection</router-link></li>
                            <li><router-link v-bind:to="{ name: 'backlog' }">Backlog</router-link></li>
                            <li><router-link v-bind:to="{ name: 'about' }">About</router-link></li>
                        </ul>
                    </div>
                </div>

                <div class="nav-right">
                    <div v-if="$store.state.token" id="greetings-mess">Hello, {{ $store.state.user.username }}</div>

                    <div class="nav-darkmode">
                        <i class="fa-solid fa-circle-half-stroke" v-on:click="toggleDarkMode"></i>
                    </div>

                    <form action="/action_page.php" id="search-bar">
                        <input type="text" placeholder="Search game library" name="search" class="search-pair-input">
                        <button type="submit" class="search-pair-btn"><i class="fa fa-search"></i></button>
                    </form>

                    <!-- <button class="tertiary" v-on:click="handleLogin">Login</button> -->
                    <button class="tertiary">
                        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token">
                            Logout
                        </router-link>
                        <router-link v-bind:to="{ name: 'login' }" v-else>Login</router-link>
                    </button>
                    <i class="fa-solid fa-bars" v-if="isMobile" v-on:click="$emit('open-nav-menu')"></i>
                    <!-- <button v-if="isMobile" v-on:click="$emit('open-nav-menu')"><i class="fa-solid fa-bars" ></i></button> -->

                </div>
            </nav>
        </div>
    </header>
</template>

<script>
const MOBILE_WIDTH_PX = 425;


export default {
    data() {
        return {
            isDarkMode: false,
            windowWidth: window.innerWidth,

        }
    },

    computed: {
        isMobile() {
            return this.windowWidth < MOBILE_WIDTH_PX;
        }
    },

    methods: {
        toggleDarkMode() {
            this.isDarkMode = !this.isDarkMode;
            document.body.classList.toggle("dark-mode", this.isDarkMode);
        },
        handleLogin() {
            this.$router.push({ name: 'login' })
        },
        setWindowWidth() {
            this.windowWidth = window.innerWidth;
        },


    },
    mounted() {
        /* TODO: Harder option */
        window.addEventListener("resize", this.setWindowWidth);
    },

    unmounted() {
        window.removeEventListener("resize", this.setWindowWidth);
    }
}

</script>

<style>
header {
    background-color: #6666ff;
    width: 100%;
    top: 0;
    z-index: 1000;
}

#greetings-mess {
    color: rgb(160, 237, 248);
}

.navbar {
    display: flex;
    justify-content: space-between;
    align-items: center;
    /* margin: 0 15%; */
    width: 65%;
    max-width: 1300px;
    margin: 0 auto;
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

#search-bar button {
    color: white;
    background-color: rgb(56, 64, 170);
    border: 1px rgb(56, 64, 170) solid;
}

.nav-darkmode i {
    font-size: 20px;
    cursor: pointer;
    color: #1b1ba6;
}

.nav-darkmode i:hover {
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

/* ---------------------------------  DARK MODE SETTINGS  --------------------------------- */
.dark-mode {
    header {
        background-color: #0b041a;
    }

    .nav-darkmode i {
        color: white;
    }
}

/* ---------------------------------  MOBILE SETTINGS  --------------------------------- */
@media only screen and (max-width: 425px) {
    .navbar {
        display: flex;
        /* flex-direction: row; */
        justify-content: space-between;
        align-items: center;
        margin: 0 10px;
    }

    .navbar-links {
        display: none;
    }

    #search-bar {
        display: none;
    }

    #greetings-mess {
        display: none;
    }

}
</style>
