package com.example.quotesTP.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter

@Entity
@Table(name = "quotes")
@Data
public class Quote extends BaseEntity {

	@Column(name = "quote_text")
    @NotEmpty
    private String quoteText;

    @ManyToOne
    private Author author;
}