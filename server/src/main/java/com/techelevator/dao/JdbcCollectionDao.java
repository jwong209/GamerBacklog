package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Collection;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class JdbcCollectionDao implements CollectionDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcCollectionDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int getCollectionIdByUserId(int userId) {
        Collection collection = null;

        String sql = "SELECT * FROM collection " +
                "WHERE user_id = ?;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            if (results.next()) {
                collection = mapRowToCollection(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        int collectionId = collection.getCollectionId();
        return collectionId;
    }


    private Collection mapRowToCollection(SqlRowSet results) {
        Collection collection = new Collection();
        collection.setCollectionId(results.getInt("collection_id"));
        collection.setUserId(results.getInt("user_id"));
        return collection;
    }
}
