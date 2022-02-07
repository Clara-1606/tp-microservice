package rest;


import com.example.quotesTP.models.Quote;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "quotes-service")
public interface QuotesRestConsumer {

        @GetMapping("api/quotes")
        public ResponseEntity<List<Quote>> getAllQuote();

        @GetMapping("api/quotes/new")
        public ResponseEntity createQuote(@RequestBody Quote quote);

        @GetMapping("api/quotes/delete/{id}")
        public ResponseEntity deleteQuote(@PathVariable("id") Long id);

        @GetMapping("api/quotes/{id}")
        public ResponseEntity getQuoteById(@PathVariable("id") Long id);
}
