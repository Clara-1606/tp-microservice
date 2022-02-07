package model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.example.quotesTP.models.Author;
import com.example.quotesTP.models.Quote;
import lombok.Getter;
import lombok.Setter;
import model.BaseEntity;

@Getter
@Setter
@Entity
@Table(name = "commentaires")
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