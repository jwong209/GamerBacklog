package com.techelevator.service;


import com.techelevator.dao.CollectionDao;
import com.techelevator.dao.CollectionGameDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Game;
import com.techelevator.model.User;
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

    public void addGameToCollection(int collectionId, int gameId, Principal principal) {
        User user = getUser(principal);
        if (user != null) {
            collectionGameDao.linkCollectionGame(collectionId, gameId);
        }
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
