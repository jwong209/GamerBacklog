import axios from 'axios';

export default {

    getGamesInCollection() {
        return axios.get('/collections/user');
    },

    getCollectionId() {
        return axios.get('/collections/user/id');
    },

    addGameToCollection(collectionId, gameId) {
        return axios.post(`/collections/${collectionId}/games/${gameId}`);
    },

    removeGameFromCollection(collectionId, gameId) {
        return axios.delete(`/collections/${collectionId}/games/${gameId}`);
    },


}