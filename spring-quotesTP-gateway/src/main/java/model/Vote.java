package model;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.example.quotesTP.models.Quote;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "votes")
class Vote extends BaseEntity {
    @Column(name = "vote")
    private boolean vote;

    @ManyToOne
    private Quote quote;
}

