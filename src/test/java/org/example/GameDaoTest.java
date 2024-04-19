package org.example;

import org.example.dao.GameDao;
import org.example.dao.JdbcGameDao;
import org.example.model.Game;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GameDaoTest extends BaseDaoTests{

    private GameDao gameDao;

    private static final Game GAME_1 = new Game(1, "Title_1", "2023-04-18", "Developer1", "Summary1", "Platform1", "Genre1", "4.0", "Plays1", "Playing1", "Backlogs1", "Wishlist1", "Lists1", "Reviews1");
    private static final Game GAME_6 = new Game(6, "Title_6", "1997-03-13", "Developer3", "Summary3", "Platform3", "Genre3", "3.6", "Plays3", "Playing3", "Backlogs3", "Wishlist3", "Lists3", "Reviews3");
    private static final int INVALID_GAME_ID = -1;


    @Before
    public void setup() {
        gameDao = new JdbcGameDao(dataSource);
    }

    @Test
    public void getGameById_returns_correct_game() {
        Game game = gameDao.getGameById(GAME_1.getGameId());

        assertGamesMatch(GAME_1, game);
    }

    @Test
    public void getGameById_with_invalid_gameId_returns_null() {
        Game game = gameDao.getGameById(INVALID_GAME_ID);

        Assert.assertNull(null, game);
    }

    @Test
    public void getGames_returns_correct_number_of_games() {
        List<Game> allGames = gameDao.getGames();
        int actualSize = allGames.size();

        Assert.assertEquals(6, actualSize);
    }

   @Test
   public void searchGamesByPlatformGenreRatingTitle_returns_correct_games() {
        //act
       List<Game> foundGames = gameDao.searchGamesByPlatformGenreRatingTitle("platform", "1", "4", "1");
       int actualSize = foundGames.size();

        //assert
        Assert.assertEquals(1, actualSize);
        assertGamesMatch(GAME_1, foundGames.get(0));
   }



    private void assertGamesMatch(Game expected, Game actual) {
        Assert.assertEquals(expected.getGameId(), actual.getGameId());
        Assert.assertEquals(expected.getTitle(), actual.getTitle());
        Assert.assertEquals(expected.getReleaseDate(), actual.getReleaseDate());
        Assert.assertEquals(expected.getDevelopers(), actual.getDevelopers());
        Assert.assertEquals(expected.getSummary(), actual.getSummary());
        Assert.assertEquals(expected.getPlatforms(), actual.getPlatforms());
        Assert.assertEquals(expected.getGenres(), actual.getGenres());
        Assert.assertEquals(expected.getRating(), actual.getRating());
        Assert.assertEquals(expected.getPlays(), actual.getPlays());
        Assert.assertEquals(expected.getPlaying(), actual.getPlaying());
        Assert.assertEquals(expected.getBacklogs(), actual.getBacklogs());
        Assert.assertEquals(expected.getWishlist(), actual.getWishlist());
        Assert.assertEquals(expected.getLists(), actual.getLists());
        Assert.assertEquals(expected.getReviews(), actual.getReviews());
    }
}
