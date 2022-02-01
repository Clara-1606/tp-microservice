package com.example.quotesTP.repositories;

import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quotesTP.models.Vote;


public interface VoteRepository extends JpaRepository<Vote, Long>{
	
	 List<Vote> findAll() throws DataAccessException;

	    Vote save(Vote vote) throws DataAccessException;

	    void delete(Vote vote) throws DataAccessException;
}
