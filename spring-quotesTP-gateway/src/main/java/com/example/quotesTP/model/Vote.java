package com.example.quotesTP.model;
import javax.persistence.*;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "votes")
public class Vote extends BaseEntity {
    @Column(name = "vote")
    private boolean vote;

    @ManyToOne
    private Quote quote;
}

