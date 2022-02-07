package com.example.quotesTP.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Getter
@Setter

@Entity
@Table(name = "quotes")
@Data
public class Quote extends BaseEntity {

    @Column(name = "quote_text")
    private String quoteText;

    @ManyToOne
    private Author author;

}