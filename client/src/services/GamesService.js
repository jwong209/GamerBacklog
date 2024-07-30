import axios from 'axios';

export default {

    searchGames(params) {
        let queryString = '?';
        if (params.name) queryString += `name=${params.name}&`;
        if (params.platforms) queryString += `platforms=${params.platforms}&`;
        if (params.genres) queryString += `genres=${params.genres}&`;
        if (params.metacritic) queryString += `metacritic=${params.metacritic}&`;
        if (params.page) queryString += `page=${params.page}`;
        return axios.get(`/games${queryString}`);
    },

    getGameById(gameId) {
        return axios.get(`/games/${gameId}`);
    },

    
}