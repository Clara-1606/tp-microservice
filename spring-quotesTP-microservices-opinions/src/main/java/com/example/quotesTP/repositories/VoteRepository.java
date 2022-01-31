package com.example.quotesTP.repositories;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import com.example.quotesTP.models.Vote;

public interface VoteRepository {
	
	Collection<Vote> findAll() throws DataAccessException;

	void save(Vote vote) throws DataAccessException;
	
	void delete(Vote vote) throws DataAccessException;
}
