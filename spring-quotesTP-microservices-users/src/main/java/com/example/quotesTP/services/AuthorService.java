package com.example.quotesTP.services;

import com.example.quotesTP.models.Author;
import com.example.quotesTP.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService
{
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors()
    {
        return authorRepository.findAll();
    }

    public Author createAuthor(Author author)
    {
        if (author.getPseudo() == null || authorRepository.findAuthorByPseudo(author.getPseudo()) != null)
            return null;

        return authorRepository.save(author);
    }

    public boolean deleteAuthor(Long id)
    {
        Optional<Author> author = authorRepository.findById(id);
        if (author.isPresent())
            authorRepository.delete(author.get());
        return author.isPresent();
    }

    public Author getById(Long id)
    {
        Optional<Author> author = authorRepository.findById(id);

        if (author.isPresent())
            return author.get();
        else
            return null;
    }
}
