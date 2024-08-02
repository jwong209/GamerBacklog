<template>
    <div class="display-option">
        <button class="display-button" v-bind:disabled="isListVisible === false" v-on:click="isListVisible = false">
            <i class="fa-solid fa-grip-vertical"></i>
        </button>
        <button class="display-button" v-bind:disabled="isListVisible === true" v-on:click="isListVisible = true">
            <i class="fa-solid fa-list"></i>
        </button>
    </div>
</template>

<script>

export default {
    data() {
        return {
        }
    },

    props: ['isListVisible'],

    methods: {

    }
}

</script>

<style scoped>
.display-button {
    width: 50px;
    padding: 4px 0px 1px 12px;
    cursor: pointer;

}
.display-option {
    display: flex;
    justify-content: flex-end;
    align-items: center;
}

.display-option i {
    font-size: 1.5rem;
}
</style>