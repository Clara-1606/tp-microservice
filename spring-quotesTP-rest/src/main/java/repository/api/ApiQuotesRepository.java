package repository.api;

import model.Quote;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.List;

@FeignClient(url = "http://localhost:8082/api/quotes/", name = "quotes-api")
interface ApiQuotesRepository {

	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
    void save(Quote quote);

	@RequestMapping(value = "/find-by-author-name/{QuoteId}", method = RequestMethod.GET, produces = "application/json")
    List<Quote> findByAuthorName(@PathVariable("AuthorName") Integer AuthorName);
    
	@RequestMapping(value = "/{QuoteId}", method = RequestMethod.GET, produces = "application/json")
	Quote findById(@PathVariable("QuoteId") int id);
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	Collection<Quote> findAll();

	@RequestMapping(value = "/{QuoteId}", method = RequestMethod.DELETE, produces = "application/json")
	void delete(@PathVariable("QuoteId") int id);
	
}
