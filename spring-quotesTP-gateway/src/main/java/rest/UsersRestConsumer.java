package rest;


import com.example.quotesTP.models.Author;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "users-service")
public interface UsersRestConsumer {
    @GetMapping("/api/authors")
    public ResponseEntity<List<Author>>  getAllAuthors();

    @GetMapping("/api/authors/new")
    public ResponseEntity createAuthor();

    @GetMapping("/api/authors/delete/{id}")
    public ResponseEntity deleteAuthor(@PathVariable("id") Long id);

    @GetMapping("/api/authors/{id}")
    public ResponseEntity getAuthorById(@PathVariable("id") Long id);

}
