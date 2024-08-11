package com.techelevator.dao;

import com.techelevator.model.CollectionGame;
import com.techelevator.model.Game;

import java.util.List;

public interface CollectionGameDao {

//    void linkCollectionGame(int collectionId, int gameId);
    void linkCollectionGame(CollectionGame collectionGame);

    int unlinkCollectionGame(int collectionId, int gameId);

    List<Integer> getGameIdsInCollection(int userId);

    CollectionGame getCollectionGame(int collectionId, int gameId);

    CollectionGame updateCollectionGame(CollectionGame collectionGame);

}
