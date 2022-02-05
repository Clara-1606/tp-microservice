package com.example.quotesTP.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.quotesTP.models.Commentaire;
import com.example.quotesTP.services.CommentaireService;


@RestController
@RequestMapping("api/comments")
public class CommentaireController {

	private final CommentaireService commentaireService;

    public CommentaireController(CommentaireService commentaireService) {
        this.commentaireService = commentaireService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Commentaire>> getAllCommentaire()
    {
        return ResponseEntity.ok(commentaireService.getAllCommentaires());
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity createCommentaire(@RequestBody Commentaire commentaire)
    {
        Commentaire newCommentaire = commentaireService.createCommentaire(commentaire);

        if (newCommentaire == null)
            return new ResponseEntity(HttpStatus.BAD_REQUEST);

        return ResponseEntity.ok(newCommentaire);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deleteCommentaire(@PathVariable("id") Long id)
    {
        if (commentaireService.deleteCommentaire(id))
            return  new ResponseEntity(HttpStatus.OK);

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getCommentaireById(@PathVariable("id") Long id)
    {
        Commentaire commentaire = commentaireService.getById(id);
        if (commentaire != null)
            return ResponseEntity.ok(commentaire);

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
