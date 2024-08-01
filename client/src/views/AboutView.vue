<template>
    <heading v-bind:pageTitle="pageTitle" v-bind:bgImage="bgImage" />

    <section class="info">
        <img
            src="../assets/img/stylized_fun_3d_render_of_a_boy_with_his_video_game_backlog._if_there_are_controllers__they_s_1-removebg-preview.png">
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore
            magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
            consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
            pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est
            laborum.</p>
    </section>
    <i class="fa-solid fa-trash-can" v-on:click="removeFromCollection" id="removeButton"></i>

    <button type="button" class="btn" @click="showModal">Open Modal!</button>
    <modal-add-backlog v-show="isModalVisible" @close="closeModal" />

    <section id="contact-form-section">
        <form>
            <input type="text">
        </form>

    </section>
</template>

<script>
import Heading from '../components/HeadingComponent.vue';
import ModalAddBacklog from '../components/ModalAddBacklog.vue';

export default {
    data() {
        return {
            pageTitle: "About Us",
            bgImage: 'src/assets/img/george-flowers-blYe0BupDuQ-unsplash.jpg',
            isModalVisible: false,
        }
    },
    components: {
        Heading,
        ModalAddBacklog,
    },

    methods: {
        showModal() {
            this.isModalVisible = true;
        },
        closeModal() {
            this.isModalVisible = false;
        }
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

#contact-form-section {
    border: 1px solid red;
}

#contact-form-section form {
    width: 80%;
    border: 1px blue solid;
}
</style>