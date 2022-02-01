package com.example.quotesTP.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter

@Entity
@Table(name = "authors")
@Data
public class Author extends BaseEntity {

	@Column(name = "pseudo")
    @NotEmpty
    private String pseudo;

}
