package com.example.quotesTP.repositories;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.example.quotesTP.models.Commentaire;

public interface CommentaireRepository {
	Collection<Commentaire> findAll() throws DataAccessException;

	void save(Commentaire commentaire) throws DataAccessException;
	
	void delete(Commentaire commentaire) throws DataAccessException;
	
	Commentaire findById(int id);
}
