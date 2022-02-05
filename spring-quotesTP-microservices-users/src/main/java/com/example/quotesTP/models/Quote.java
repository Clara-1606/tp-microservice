package com.example.quotesTP.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter

@Entity
@Table(name = "quotes")
@Data
public class Quote extends BaseEntity {

    @Column(name = "quoteText")
    private String quoteText;

    @ManyToOne
    private Author author;

}