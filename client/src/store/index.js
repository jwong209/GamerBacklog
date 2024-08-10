import { createStore as _createStore } from 'vuex';
import axios from 'axios';

import CollectionService from '../services/CollectionService';
import BacklogService from '../services/BacklogService';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},
      // Additional state
      _collectionGames: [],
      _backlogGames: []
    },
    mutations: {
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem('token', token);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
      },
      SET_USER(state, user) {
        state.user = user;
        localStorage.setItem('user', JSON.stringify(user));
      },
      LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        state.token = '';
        state.user = {};
        axios.defaults.headers.common = {};
      }
    },
    // computed properties for the store variables
    // and are ~REACTIVE~!
    getters: {
      retrieveCollectionGames(state) {
        return state._collectionGames;
      },
      retrieveBacklogGames(state) {
        return state._backlogGames;
      }
    },
    // async methods + commits for the store
    actions: {

      getCollectionGames(context) {
        return CollectionService.getGamesInCollection()
          .then((response) => {
            if (response.status === 200) {
              context.state._collectionGames = response.data;
            }
            return response;
          })
          
      },
      getBacklogGames(context) {
        return BacklogService.getGamesInBacklog()
          .then((response) => {
            if (response.status === 200) {
              context.state._backlogGames = response.data;
            }
            return response;
          })
      },
      removeGameFromCollection(context, { collectionId, currentGameId }) {
        return CollectionService.removeGameFromCollection(collectionId, currentGameId)
          .then((response) => {
            
            if(response.status === 204) {
              // what am I removing here?
              context.state._collectionGames = context.state._collectionGames.filter(game => game.id !== currentGameId);
            }

            return response;
          })
      }, 
      removeGameFromBacklog(context, { backlogId, currentGameId }) {
        return BacklogService.removeGameFromBacklog( backlogId, currentGameId )
          .then((response) => {
            if (response.status === 204) {
              context.state._backlogGames = context.state._backlogGames.filter(game => game.id !== currentGameId);
            }

            return response;
          })
  
      }

    }

  })
  return store;
}