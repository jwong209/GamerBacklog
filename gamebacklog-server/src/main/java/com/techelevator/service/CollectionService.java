package com.techelevator.service;


import com.techelevator.dao.CollectionDao;
import com.techelevator.dao.CollectionGameDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.*;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CollectionService {

    private final CollectionDao collectionDao;
    private final UserDao userDao;
    private final CollectionGameDao collectionGameDao;

    public CollectionService(CollectionDao collectionDao, UserDao userDao, CollectionGameDao collectionGameDao) {
        this.collectionDao = collectionDao;
        this.userDao = userDao;
        this.collectionGameDao = collectionGameDao;
    }

    public int getCollectionIdByUserId(Principal principal) {
        int collectionId = 0;
        User user = getUser(principal);

        collectionId = collectionDao.getCollectionIdByUserId(user.getId());
        return collectionId;
    }

    public List<Integer> getGameIdsInCollection(Principal principal) {
        List<Integer> results = new ArrayList<>();

        User user = getUser(principal);
        if (user != null) {
            results = collectionGameDao.getGameIdsInCollection(user.getId());
        }

        return results;
    }

//    public void addGameToCollection(int collectionId, int gameId, Principal principal) {
//        User user = getUser(principal);
//        if (user != null) {
//            int currentCollectionId = collectionDao.getCollectionIdByUserId(user.getId());
//
//            // userId is tied to single collectionId; so principals' userId/collectionId must match the collectionId passed into endpoint
//            if (collectionId == currentCollectionId) {
//                collectionGameDao.linkCollectionGame(collectionId, gameId);
//            }
//        }
//    }

    public void addGameToCollection(CollectionGame collectionGame, Principal principal) {
        User user = getUser(principal);
        if (user != null) {
            int currentCollectionId = collectionDao.getCollectionIdByUserId(user.getId());

            // userId is tied to single collectionId; so principals' userId/collectionId must match the collectionId passed into endpoint
            if (collectionGame.getCollectionId() == currentCollectionId) {
                collectionGameDao.linkCollectionGame(collectionGame);
            }
        }
    }

    public boolean removeGameFromCollection(int collectionId, int gameId, Principal principal) {
        boolean gameRemoved = false;

        User user = getUser(principal);
        if (user != null) {
            int currentCollectionId = collectionDao.getCollectionIdByUserId(user.getId());

            if (collectionId == currentCollectionId) {
                int deleteCount = collectionGameDao.unlinkCollectionGame(collectionId, gameId);
                gameRemoved = (deleteCount != 0);
            }

        }

        return gameRemoved;
    }

    public CollectionGame getCollectionGame(int collectionId, int gameId, Principal principal) {
        CollectionGame collectionGame = null;

        User user = getUser(principal);
        if (user != null) {
            collectionGame = collectionGameDao.getCollectionGame(collectionId, gameId);
        }

        return collectionGame;
    }

    public CollectionGame updateCollectionGame(CollectionGame modifiedCollectionGame, Principal principal) {
        CollectionGame collectionGame = null;

        User user = getUser(principal);
        if (user != null) {
            collectionGame = collectionGameDao.updateCollectionGame(modifiedCollectionGame);
        }
        return collectionGame;
    }

    /*
     * Helper method to get the User object from the Principal.
     */
    private User getUser(Principal principal) {
        String username = principal.getName();
        User user = userDao.getUserByUsername(username);
        return user;
    }

}
