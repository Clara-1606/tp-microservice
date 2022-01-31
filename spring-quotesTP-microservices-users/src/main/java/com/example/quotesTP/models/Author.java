package com.example.quotesTP.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Author")
@Data
public class Author
{
    @Id
    @GeneratedValue
    private Long id;

    private String pseudo;

}
