import axios from 'axios';

export default {

    getGamesInBacklog() {
        return axios.get('/backlogs/user');
    },

    


}