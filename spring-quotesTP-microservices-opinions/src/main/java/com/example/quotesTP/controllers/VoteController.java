package com.example.quotesTP.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.quotesTP.models.Author;
import com.example.quotesTP.models.Quote;
import com.example.quotesTP.models.Vote;
import com.example.quotesTP.repositories.VoteRepository;

@RestController
@RequestMapping("api/votes")
public class VoteController {

	@Autowired
	VoteRepository voteRepository;
	
	@PostMapping("/upvote")
	public ResponseEntity<Vote> addUpVote(@RequestBody Vote vote) {
		
		voteRepository.save(vote);
		return ResponseEntity.status(HttpStatus.CREATED).body(vote);
	}
	
	@PostMapping("/downvote")
	public ResponseEntity<Vote> addDownVote(@RequestBody Vote vote) {
		
		voteRepository.save(vote);
		return ResponseEntity.status(HttpStatus.CREATED).body(vote);
	}
}
