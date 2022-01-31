package com.example.quotesTP.models;

import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Commentaire extends BaseEntity {
	@Column(name = "commentaire")
    @NotEmpty
	private String commentaire;
	
	 @ManyToOne
	 @JoinColumn(name = "author_id")
	 private Author author;
	 
	 @ManyToOne
	 @JoinColumn(name = "quote_id")
	 private Quote quote;

	    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "pet", fetch = FetchType.EAGER)
	    //private Set<Visit> visits;
}
