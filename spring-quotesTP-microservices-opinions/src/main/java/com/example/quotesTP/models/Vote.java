package com.example.quotesTP.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Vote extends BaseEntity {
	@Column(name = "vote")
	private boolean vote;

	@ManyToOne
	private Quote quote;
}
