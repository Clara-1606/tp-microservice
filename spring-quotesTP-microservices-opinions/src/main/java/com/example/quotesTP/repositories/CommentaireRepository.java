package com.example.quotesTP.repositories;

import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quotesTP.models.Commentaire;



public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
	 List<Commentaire> findAll() throws DataAccessException;

	    Commentaire save(Commentaire commentaire) throws DataAccessException;

	    void delete(Commentaire commentaire) throws DataAccessException;

}
