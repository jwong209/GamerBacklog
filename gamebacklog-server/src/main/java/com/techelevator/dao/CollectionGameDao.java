package com.techelevator.dao;

import com.techelevator.model.Game;

import java.util.List;

public interface CollectionGameDao {

    void linkCollectionGame(int collectionId, int gameId);

    int unlinkCollectionGame(int collectionId, int gameId);

    List<Integer> getGameIdsInCollection(int userId);


}
