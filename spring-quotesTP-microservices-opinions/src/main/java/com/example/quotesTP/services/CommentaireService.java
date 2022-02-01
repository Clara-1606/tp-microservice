package com.example.quotesTP.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.quotesTP.models.Commentaire;
import com.example.quotesTP.repositories.CommentaireRepository;

@Service
public class CommentaireService {
	private final CommentaireRepository commentaireRepository;

    public CommentaireService(CommentaireRepository commentaireRepository) {
        this.commentaireRepository = commentaireRepository;
    }

    public List<Commentaire> getAllCommentaires()
    {
        return commentaireRepository.findAll();
    }

    public Commentaire createCommentaire(Commentaire commentaire)
    {
        return commentaireRepository.save(commentaire);
    }

    public boolean deleteCommentaire(Long id)
    {
        Optional<Commentaire> commentaire = commentaireRepository.findById(id);
        if (commentaire.isPresent())
            commentaireRepository.delete(commentaire.get());
        return commentaire.isPresent();
    }

    public Commentaire getById(Long id)
    {
        Optional<Commentaire> commentaire = commentaireRepository.findById(id);

        if (commentaire.isPresent())
            return commentaire.get();
        else
            return null;
    }
}
