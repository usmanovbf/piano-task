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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.List;

@Controller
public class SearchController {
    private static final Logger LOGGER = LoggerFactory.getLogger( SearchController.class );

    @Autowired
    private SearchService searchService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView getSearch(Model model) {
        LOGGER.info( "Received GET request for searching page" );
        return new ModelAndView("searchPage", "form", new SearchForm());
    }

    @RequestMapping(value = "/results", method = RequestMethod.POST,
            consumes = "application/x-www-form-urlencoded", produces = "text/html")
    public ModelAndView search( @ModelAttribute("form") SearchForm form ) {
        LOGGER.info( "Received POST request for searching" + form.getSearchTitle() );
        List<SearchResult> searchResults = searchService.search( form.getSearchTitle() );
        return new ModelAndView( "resultsPage", "searchResults", searchResults );
    }
}
