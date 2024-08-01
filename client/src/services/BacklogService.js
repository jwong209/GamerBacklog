import axios from 'axios';

export default {

    getGamesInBacklog() {
        return axios.get('/backlogs/user');
    },

    getBacklogId() {
        return axios.get('/backlogs/user/id');
    },

    removeGameFromBacklog(backlogId, gameId) {
        return axios.delete(`/backlogs/${backlogId}/games/${gameId}`);
    },

    addGameToBacklog(backlogGame) {
        return axios.post('/backlogs/user', backlogGame);
    },

}