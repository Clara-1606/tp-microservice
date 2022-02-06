
package com.example.quotesTP.repositories;

import com.example.quotesTP.models.Quote;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;


public interface QuoteRepository extends JpaRepository<Quote, Long>
{
    List<Quote> findAll() throws DataAccessException;

    Quote save(Quote quote) throws DataAccessException;

    void delete(Quote quote) throws DataAccessException;

    List<Quote> findAllByAuthor_Id(Long authorId) throws DataAccessException;


}