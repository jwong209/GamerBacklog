<template>
    <heading v-bind:pageTitle="pageTitle" v-bind:bgImage="bgImage" />

    <section class="info">
        <img src="../assets/img/stylized_fun_3d_render_of_a_boy_with_his_video_game_backlog._if_there_are_controllers__they_s_1-removebg-preview.png">
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
    </section>

    <section>

        
    </section>

</template>

<script>
import Heading from '../components/HeadingComponent.vue';

export default {
    data() {
        return {
            pageTitle: "About",
            bgImage: 'src/assets/img/george-flowers-blYe0BupDuQ-unsplash.jpg',
        }
    },
    components: {
        Heading,
    }
}
    

</script>


<style>
.info {
    display: flex;
    align-items: center;

}

.info p {
    font-size: 1.5rem;
    line-height: 2.0rem;
}


</style>