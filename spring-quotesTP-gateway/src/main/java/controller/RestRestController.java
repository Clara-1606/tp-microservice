package controller;

import com.example.quotesTP.models.Author;
import com.example.quotesTP.models.Commentaire;
import com.example.quotesTP.models.Quote;
import com.example.quotesTP.models.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.OpinionsRestConsumer;
import rest.QuotesRestConsumer;
import rest.UsersRestConsumer;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class RestRestController {

    @Autowired
    private UsersRestConsumer uconsumer;

    @GetMapping(value = "/api/authors")
    public ResponseEntity<List<Author>> getAuthors(){
        return uconsumer.getAllAuthors();
    }

    @GetMapping(value = "/api/authors/new")
    public ResponseEntity creationAuthor(){
        return uconsumer.createAuthor();
    }

    @GetMapping("/api/authors/delete/{id}")
    public ResponseEntity suppressAuthor(@PathVariable("id") Long id){
        return uconsumer.deleteAuthor(id);
    }

    @GetMapping("/api/authors/{id}")
    public ResponseEntity findAuthorbyId(@PathVariable("id") Long id){
        return uconsumer.getAuthorById(id);
    }

    @Autowired
    private QuotesRestConsumer qconsumer;

    @GetMapping("api/quotes")
    public ResponseEntity<List<Quote>> findAllQuotes(){
        return qconsumer.getAllQuote();

    }

    @GetMapping("api/quotes/new")
    public ResponseEntity newQuote(@RequestBody Quote quote){
        return qconsumer.createQuote(quote);
    }

    @GetMapping("api/quotes/delete/{id}")
    public ResponseEntity suppressQuote(@PathVariable("id") Long id){
        return qconsumer.deleteQuote(id);
    }

    @GetMapping("api/quotes/{id}")
    public ResponseEntity findQuoteById(@PathVariable("id") Long id){
        return qconsumer.getQuoteById(id);
    }

    @GetMapping("api/quotes/author/{id}")
    public ResponseEntity findQuotesByAuthorId(@PathVariable("id") Long id) { return qconsumer.getQuotesByAuthorId(id); }


    @Autowired
    private OpinionsRestConsumer oconsumer;

    @GetMapping("api/votes")
    public ResponseEntity<List<Vote>> findAllVote(){
        return oconsumer.getAllVote();
    }

    @GetMapping("api/votes/new")
    public ResponseEntity newVote(@RequestBody Vote vote){
        return oconsumer.createVote(vote);
    }

    @GetMapping("api/votes/delete/{id}")
    public ResponseEntity suppressVote(@PathVariable("id") Long id){
        return oconsumer.deleteVote(id);
    }

    @GetMapping("api/votes/{id}")
    public ResponseEntity findVoteById(@PathVariable("id") Long id){
        return oconsumer.getVoteById(id);
    }

    @GetMapping("api/votes/upvoteRatio/author/{id}")
    public ResponseEntity findAuthorUpvoteRatio(@PathVariable("id") Long id) { return oconsumer.getAuthorUpvoteRatio(id); }

    @GetMapping("api/votes/downvoteRatio/author/{id}")
    public ResponseEntity findAuthorDownvoteRatio(@PathVariable("id") Long id) { return oconsumer.getAuthorDownvoteRatio(id); }

    @GetMapping("api/votes/mostUpvotedQuotes")
    public ResponseEntity findMostUpvotedQuotes() { return oconsumer.getMostUpvotedQuotes(); }

    @GetMapping("api/comments")
    public ResponseEntity<List<Commentaire>> findAllCommentaire(){
        return oconsumer.getAllCommentaire();
    }

    @GetMapping("api/comments/new")
    public ResponseEntity newCommentaire(@RequestBody Commentaire commentaire){
        return oconsumer.createCommentaire(commentaire);
    }

    @GetMapping("api/comments/delete/{id}")
    public ResponseEntity suppressCommentaire(@PathVariable("id") Long id){
        return oconsumer.deleteCommentaire(id);
    }

    @RequestMapping("api/comments/{id}")
    public ResponseEntity findCommentaireById(@PathVariable("id") Long id){
        return oconsumer.getCommentaireById(id);
    }




}
