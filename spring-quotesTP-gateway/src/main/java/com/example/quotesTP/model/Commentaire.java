package com.example.quotesTP.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "commentaires")
public
class Commentaire extends BaseEntity {
    @Column(name = "commentaire")
    @NotEmpty
    private String commentaire;

    @ManyToOne
    private Author author;

    @ManyToOne
    private Quote quote;

    /*
     * @ManyToOne
     *
     * @JoinColumn(name = "author_id") private Author author;
     *
     * @ManyToOne
     *
     * @JoinColumn(name = "quote_id") private Quote quote;
     */

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "pet", fetch = FetchType.EAGER)
    //private Set<Visit> visits;
}