package com.example.quotesTP.models;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Author extends BaseEntity {
	@Column(name = "pseudo")
    @NotEmpty
	private String pseudo;
}