package com.example.quotesTP.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "commentaires")
public class Commentaire extends BaseEntity {
	@Column(name = "commentaire")
    @NotEmpty
	private String commentaire;

	@ManyToOne
	private Author author;

	@ManyToOne
	private Quote quote;
}
