package com.example.quotesTP.repositories;

import com.example.quotesTP.models.Author;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface AuthorRepository extends JpaRepository<Author, Long>
{
    List<Author> findAll() throws DataAccessException;

    Optional<Author> findById(Long id) throws DataAccessException;

    Author save(Author author) throws DataAccessException;

    void delete(Author author) throws DataAccessException;

    Author findAuthorByPseudo(String pseudo) throws DataAccessException;
}
