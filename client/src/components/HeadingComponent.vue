<template> 
    <div v-bind:style="{ backgroundImage: `linear-gradient(rgba(29, 8, 97, 0.8), rgba(126, 96, 216, 0.8)), url(${bgImage})` }">
        <h1>{{ pageTitle }}</h1>
    </div>
  
</template>

<script>
export default {
    props: ['pageTitle', 'bgImage']
}

</script>

<style scoped>
div {
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    display: flex;
    align-items: center;
}

h1 {
    margin-left: 10%;
    color: white;
}

</style>