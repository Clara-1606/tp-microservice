package com.example.quotesTP.controllers;

import com.example.quotesTP.models.Quote;
import com.example.quotesTP.services.QuoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/quotes")
public class QuoteController
{
    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Quote>> getAllQuote()
    {
        return ResponseEntity.ok(quoteService.getAllQuotes());
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity createQuote(@RequestBody Quote quote)
    {
        Quote newQuote = quoteService.createQuote(quote);

        if (newQuote == null)
            return new ResponseEntity(HttpStatus.BAD_REQUEST);

        return ResponseEntity.ok(newQuote);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deleteQuote(@PathVariable("id") Long id)
    {
        if (quoteService.deleteQuote(id))
            return  new ResponseEntity(HttpStatus.OK);

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getQuoteById(@PathVariable("id") Long id)
    {
        Quote quote = quoteService.getById(id);
        if (quote != null)
            return ResponseEntity.ok(quote);

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}