package com.example.quotesTP.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter

@Entity
@Table(name = "authors")
@Data
public class Author extends BaseEntity {

    @Column(name = "pseudo")
    @NotEmpty
    private String pseudo;

    @OneToMany(mappedBy = "author")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
    private List<Quote> quotes;

}