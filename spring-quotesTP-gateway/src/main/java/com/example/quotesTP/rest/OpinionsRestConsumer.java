package com.example.quotesTP.rest;


import com.example.quotesTP.model.Commentaire;
import com.example.quotesTP.model.Vote;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "opinions-service")
public interface OpinionsRestConsumer {

        @GetMapping("api/votes")
        public ResponseEntity<List<Vote>> getAllVote();

        @GetMapping("api/votes/new")
        public ResponseEntity createVote(@RequestBody Vote vote);

        @GetMapping("api/votes/delete/{id}")
        public ResponseEntity deleteVote(@PathVariable("id") Long id);

        @GetMapping("api/votes/{id}")
        public ResponseEntity getVoteById(@PathVariable("id") Long id);

        @GetMapping("/api/votes/upvoteRatio/author/{id}")
        public ResponseEntity getAuthorUpvoteRatio(@PathVariable("id") Long id);

        @GetMapping("/api/votes/downvoteRatio/author/{id}")
        public ResponseEntity getAuthorDownvoteRatio(@PathVariable("id") Long id);

        @GetMapping("api/votes/mostUpvotedQuotes")
        public ResponseEntity getMostUpvotedQuotes();

        @GetMapping("api/comments")
        public ResponseEntity<List<Commentaire>> getAllCommentaire();

        @GetMapping("api/comments/new")
        public ResponseEntity createCommentaire(@RequestBody Commentaire commentaire);

        @GetMapping("api/comments/delete/{id}")
        public ResponseEntity deleteCommentaire(@PathVariable("id") Long id);

        @RequestMapping("api/comments/{id}")
        public ResponseEntity getCommentaireById(@PathVariable("id") Long id);

        }
