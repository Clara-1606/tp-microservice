package repository.api;

import model.Author;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@FeignClient(url = "http://localhost:8081/api/Author/", name = "Authors-api")
interface ApiAuthorRepository {

	@RequestMapping(value = "/*/lastname/{lastName}", method = RequestMethod.GET, produces = "application/json")
	Collection<Author> findByLastName(@PathVariable("lastName") String lastName);
	
	@RequestMapping(value = "/{AuthorId}", method = RequestMethod.GET, produces = "application/json")
	Author findById(@PathVariable("AuthorId") int id);
	
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	void save(@RequestBody Author Author);
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	Collection<Author> findAll();
	
	@RequestMapping(value = "/{AuthorId}", method = RequestMethod.DELETE, produces = "application/json")
	void delete(@PathVariable("AuthorId") int AuthorId);
	
	@RequestMapping(value = "/*/Author/{AuthorName}", method = RequestMethod.GET, produces = "application/json")
	Collection<Author> findByAuthor_Name(@PathVariable("AuthorName") String petName);
	
}
