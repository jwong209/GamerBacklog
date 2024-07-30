import axios from 'axios';

export default {

    getGamesInCollection() {
        return axios.get('/collections/user');
    },

    getCollectionId() {
        return axios.get('/collections/user/id');
    },

    addGametoCollection(collectionId, gamesId) {
        return axios.post(`/collections/${collectionId}/games/${gamesId}`);
    },

    removeGameFromCollection(collectionId, gameId) {
        return axios.delete(`/collections/${collectionId}/games/${gameId}`);
    }


}