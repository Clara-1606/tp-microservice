package com.example.quotesTP.models;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

public class Quote extends BaseEntity {
	@Column(name = "texte")
    @NotEmpty
	private String texte;
	
	 @ManyToOne
	 @JoinColumn(name = "autor_id")
	 private Author autor;
}
