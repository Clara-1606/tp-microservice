package com.example.quotesTP.services;

import com.example.quotesTP.models.Quote;
import com.example.quotesTP.repositories.QuoteRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class QuoteService
{
    private final QuoteRepository quoteRepository;

    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public List<Quote> getAllQuotes()
    {
        return quoteRepository.findAll();
    }

    public Quote createQuote(Quote quote)
    {
        if (quote.getQuoteText() == null)
            return null;

        return quoteRepository.save(quote);
    }

    public boolean deleteQuote(Long id)
    {
        Optional<Quote> quote = quoteRepository.findById(id);
        if (quote.isPresent())
            quoteRepository.delete(quote.get());
        return quote.isPresent();
    }

    public Quote getById(Long id)
    {
        Optional<Quote> quote = quoteRepository.findById(id);

        if (quote.isPresent())
            return quote.get();
        else
            return null;
    }

    public List<Quote> getQuotesByAuthorId(Long authorId)
    {
        return quoteRepository.findAllByAuthor_Id(authorId);
    }

}