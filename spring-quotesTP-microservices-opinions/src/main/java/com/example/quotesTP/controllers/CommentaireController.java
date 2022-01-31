package com.example.quotesTP.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.quotesTP.models.Commentaire;
import com.example.quotesTP.repositories.CommentaireRepository;


@RestController
@RequestMapping("api/commentaires")
public class CommentaireController {

	@Autowired
	CommentaireRepository commentaireRepository;
	
	@PostMapping("/")
	public ResponseEntity<Commentaire> addCommentaire(@RequestBody Commentaire commentaire) {
		
		commentaireRepository.save(commentaire);
		return ResponseEntity.status(HttpStatus.CREATED).body(commentaire);
	}
	
	@RequestMapping(value = "/delete/{commentaireId}", method = RequestMethod.DELETE, produces = "application/json")
    @Transactional
    public ResponseEntity<Void> deleteCommentaire(@PathVariable("commentaireId") int commentaireId) {
		Commentaire commentaire = commentaireRepository.findById(commentaireId);
        if (commentaire == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        commentaireRepository.delete(commentaire);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
