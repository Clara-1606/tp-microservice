package com.example.quotesTP.repositories;

import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quotesTP.models.Vote;
import org.springframework.data.jpa.repository.Query;


public interface VoteRepository extends JpaRepository<Vote, Long>{
	
	 List<Vote> findAll() throws DataAccessException;

	    Vote save(Vote vote) throws DataAccessException;

	    void delete(Vote vote) throws DataAccessException;

		long countByVoteTrueAndQuote_Author_Id(Long authorId) throws DataAccessException;

		long countByVoteFalseAndQuote_Author_Id(Long authorId) throws DataAccessException;

		long countByQuote_Author_Id(Long authorId) throws DataAccessException;

		//select quote_id from vote where vote=1 group by quote_id order by count(*) desc limit 10;
		@Query(value = "SELECT quote_id FROM votes WHERE vote=1 GROUP BY quote_id ORDER BY count(*) DESC LIMIT 10", nativeQuery = true)
		List<Long> findTenMostUpVotedQuotesIds() throws DataAccessException;
}
