package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Backlog;

import java.util.List;


public interface BacklogDao {

    Backlog getBacklogById(int backlogId) throws DaoException;

    List<Backlog> getBacklogsByUserId(int userId) throws DaoException;

    Backlog createBacklog(int userId) throws DaoException;

    Backlog updateBacklog(Backlog backlog) throws DaoException;

    int deleteBacklog(int backlogId) throws DaoException;

}
