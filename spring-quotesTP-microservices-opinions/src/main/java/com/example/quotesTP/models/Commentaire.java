package com.example.quotesTP.models;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Entity
public class Commentaire extends BaseEntity {
	@Column(name = "commentaire")
    @NotEmpty
	private String commentaire;

	@ManyToOne
	private Author author;

	@ManyToOne
	private Quote quote;
}
