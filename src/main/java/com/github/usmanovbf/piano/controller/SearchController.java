package com.github.usmanovbf.piano.controller;

import com.github.usmanovbf.piano.domain.SearchForm;
import com.github.usmanovbf.piano.domain.SearchResult;
import com.github.usmanovbf.piano.service.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SearchController {
    private static final Logger LOGGER = LoggerFactory.getLogger( SearchController.class );

    @Autowired
    private SearchService searchService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView getSearch( Model model ) {
        LOGGER.debug( "Received GET request for searching page" );
        return new ModelAndView( "searchPage", "form", new SearchForm() );
    }

    @RequestMapping(value = "/results", method = RequestMethod.POST,
            consumes = "application/x-www-form-urlencoded", produces = "text/html")
    public ModelAndView search( @ModelAttribute("form") SearchForm form ) {
        LOGGER.debug( "Received POST request for searching" + form.getSearchTitle() );
        List<SearchResult> searchResults = searchService.search( form.getSearchTitle() );
        return new ModelAndView( "resultsPage", "searchResults", searchResults );
    }

    @RequestMapping(value = "/results/{page}", method = RequestMethod.POST,
            consumes = "application/x-www-form-urlencoded", produces = "text/html")
    public ModelAndView searchOtherPages( @ModelAttribute("form") SearchForm form,
                                          @PathVariable String page) {
        LOGGER.debug( "Received POST request for searching" + form.getSearchTitle() );
        List<SearchResult> searchResults = searchService.search( form.getSearchTitle(), page );
        return new ModelAndView( "resultsPage", "searchResults", searchResults );
    }
}
