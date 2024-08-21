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


<p>Testing again initial push from new setup</p>

    <!-- <section id="contact-form-section">
        <form>
            <input type="text">
        </form>
    </section> -->

        <div ref="notification" :class="['notification', { visible: showNotification }]">
            <p>Awesome 🏆</p>
        </div>

        <p>showNotification = {{ showNotification }}</p>
        <button @click="() => debounceInstance()">Notification</button>

</template>

<script>
import Heading from '../components/HeadingComponent.vue';

const DEBOUNCE_DELAY_MS = 200;


export default {
    data() {
        return {
            pageTitle: "About Us",
            bgImage: 'src/assets/img/george-flowers-blYe0BupDuQ-unsplash.jpg',
            isModalVisible: false,

            showNotification: false,
            debounceInstance: this.debounce(DEBOUNCE_DELAY_MS)
        }
    },
    components: {
        Heading,

    },

    methods: {
        showModal() {
            this.isModalVisible = true;
        },
        closeModal() {
            this.isModalVisible = false;
        },

        debounce(debounceDelayMs) {
       let timerId = null;

       return () => {
         if(timerId) clearTimeout(timerId);
         timerId = setTimeout(() => this.showNotification = true, debounceDelayMs);
       }
     },
    },

    mounted() {
    const notificationRef = this.$refs["notification"];
    notificationRef.addEventListener("animationend", (event) => {
      if (event.animationName === "moveout") {
        this.showNotification = false;
      }
    });
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


.notification {
  position: fixed;
  top: -2rem;
  left: 50%;
  transform: translate(-50%, -50%);

  padding: 5px;
  width: fit-content;
  background-color: #cba8cb77;
}

.visible {
  /*         name    duration delay timing function direction*/
  animation: movein  0.5s           ease            forwards,
             moveout 0.5s     2s    ease            forwards;
}

@keyframes movein {
  from {
    top: -2rem;
    opacity: 0;
  }
  to {
    top: 2rem;
    opacity: 1;
  }
}

@keyframes moveout {
  from {
    top: 2rem;
    opacity: 1;
  }
  to {
    top: -2rem;
    opacity: 0;
  }
}
</style>
