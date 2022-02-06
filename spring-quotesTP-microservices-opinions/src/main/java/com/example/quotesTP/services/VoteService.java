package com.example.quotesTP.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.quotesTP.models.Vote;
import com.example.quotesTP.repositories.VoteRepository;

@Service
public class VoteService {
	private final VoteRepository voteRepository;

    public VoteService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    public List<Vote> getAllVotes()
    {
        return voteRepository.findAll();
    }

    public Vote createVote(Vote vote)
    {
        return voteRepository.save(vote);
    }

    public boolean deleteVote(Long id)
    {
        Optional<Vote> vote = voteRepository.findById(id);
        if (vote.isPresent())
            voteRepository.delete(vote.get());
        return vote.isPresent();
    }

    public Vote getById(Long id)
    {
        Optional<Vote> vote = voteRepository.findById(id);

        if (vote.isPresent())
            return vote.get();
        else
            return null;
    }

    public float getAuthorVoteRatio(Long authorId)
    {
        Long upvotes = voteRepository.countByVoteTrueAndQuote_Author_Id(authorId);

        Long downvotes = voteRepository.countByVoteFalseAndQuote_Author_Id(authorId);

        float ratio = upvotes;
        if (downvotes > 0)
            ratio = upvotes / downvotes;

        return ratio;
    }
}
