import axios from 'axios';

export default {

    getGamesInCollection() {
        return axios.get('/collections/user');
    },

    getCollectionId() {
        return axios.get('/collections/user/id');
    },

    // addGameToCollection(collectionId, gameId) {
    //     return axios.post(`/collections/${collectionId}/games/${gameId}`);
    // },

    addGameToCollection(collectionGame) {
        return axios.post('/collections/user', collectionGame);
    },

    removeGameFromCollection(collectionId, gameId) {
        return axios.delete(`/collections/${collectionId}/games/${gameId}`);
    },

    getCollectionGame(collectionId, gameId) {
        return axios.get(`/collections/${collectionId}/games/${gameId}`);
    }, 

    updateCollectionGame(collectionId, gameId, collectionGame) {
        return axios.put(`/collections/${collectionId}/games/${gameId}`, collectionGame);
    }

}