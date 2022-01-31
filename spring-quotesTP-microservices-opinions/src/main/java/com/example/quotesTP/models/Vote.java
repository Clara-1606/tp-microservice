package com.example.quotesTP.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Vote extends BaseEntity {
	@Column(name = "pseudo")
    @NotEmpty
	private String pseudo;
	
	@Column(name = "vote")
    @NotEmpty
	private boolean vote;
}
