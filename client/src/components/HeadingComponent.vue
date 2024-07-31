<template>
    <div class="outer-container"
        v-bind:style="{ backgroundImage: `linear-gradient(rgba(29, 8, 97, 0.8), rgba(126, 96, 216, 0.8)), url(${bgImage})` }">
        <div class="inner-container">
            <h1 class="press-start-2p-regular">{{ pageTitle }}</h1>
            <p> {{ pageDescription }} </p>
        </div>
    </div>
</template>

<script>
export default {
    props: ['pageTitle', 'bgImage', 'pageDescription']
}

</script>

<style scoped>
.outer-container {
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    display: flex;
    flex-direction: column;
    padding: 20px;
}

.inner-container {
    margin-left: 15%;
}

p {
    color: white;
    font-size: 1.5rem;
}</style>