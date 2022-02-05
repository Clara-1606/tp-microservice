package com.example.quotesTP.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

}
