package com.example.quotesTP.controllers;

import com.example.quotesTP.models.Author;
import com.example.quotesTP.services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController
{
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Author>> getAllAuthor()
    {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity createAuthor(@RequestBody Author author)
    {
        Author newAuthor = authorService.createAuthor(author);

        if (newAuthor == null)
            return new ResponseEntity(HttpStatus.BAD_REQUEST);

        return ResponseEntity.ok(newAuthor);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deleteAuthor(@PathVariable("id") Long id)
    {
        if (authorService.deleteAuthor(id))
            return  new ResponseEntity(HttpStatus.OK);

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getAuthorById(@PathVariable("id") Long id)
    {
        Author author = authorService.getById(id);
        if (author != null)
            return ResponseEntity.ok(author);

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
