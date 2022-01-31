package com.example.quotesTP.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "authors")
public class Author extends BaseEntity {
	@Column(name = "pseudo")
    @NotEmpty
	private String pseudo;
}