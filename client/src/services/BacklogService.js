import axios from 'axios';

export default {

    getGamesInBacklog() {
        return axios.get('/backlogs/user');
    },

    getBacklogId() {
        return axios.get('/backlogs/user/id');
    },

    addGameToBacklog(backlogId, gameId) {
        return axios.post(`/backlogs/${backlogId}/games/${gameId}`);
    },

    removeGameFromBacklog(backlogId, gameId) {
        return axios.delete(`/backlogs/${backlogId}/games/${gameId}`);
    }


}