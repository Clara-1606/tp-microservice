package com.example.quotesTP.controllers;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.quotesTP.models.Vote;
import com.example.quotesTP.services.VoteService;

@RestController
@RequestMapping("api/votes")
public class VoteController {

	private final VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Vote>> getAllVote()
    {
        return ResponseEntity.ok(voteService.getAllVotes());
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity createVote(@RequestBody Vote vote)
    {
        Vote newVote = voteService.createVote(vote);

        if (newVote == null)
            return new ResponseEntity(HttpStatus.BAD_REQUEST);

        return ResponseEntity.ok(newVote);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deleteVote(@PathVariable("id") Long id)
    {
        if (voteService.deleteVote(id))
            return  new ResponseEntity(HttpStatus.OK);

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getVoteById(@PathVariable("id") Long id)
    {
        Vote vote = voteService.getById(id);
        if (vote != null)
            return ResponseEntity.ok(vote);

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/upvoteRatio/author/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getAuthorUpvoteRatio(@PathVariable("id") Long id)
    {
        float ratio = voteService.getAuthorUpvoteRatio(id);

        if(ratio != 0)
            return ResponseEntity.ok(ratio);

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/downvoteRatio/author/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getAuthorDownvoteRatio(@PathVariable("id") Long id)
    {
        float ratio = voteService.getAuthorDownvoteRatio(id);

        if(ratio != 0)
            return ResponseEntity.ok(ratio);

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
