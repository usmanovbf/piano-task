package com.github.usmanovbf.piano.controller;

import com.github.usmanovbf.piano.domain.ResultsResponse;
import com.github.usmanovbf.piano.domain.SearchForm;
import com.github.usmanovbf.piano.service.SearchService;
import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@Controller
public class SearchController {
    private static final Logger LOGGER = LoggerFactory.getLogger( SearchController.class );

    @Autowired
    private SearchService searchService;

    @GetMapping(value = "/")
    public String mainPage() {
        LOGGER.debug( "Redirecting from main page" );
        return "redirect:/search";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView getSearch( Model model ) {
        LOGGER.debug( "Received GET request for searching page" );
        return new ModelAndView( "searchPage", "form", new SearchForm() );
    }

    @RequestMapping(value = "/results", method = RequestMethod.POST,
            consumes = "application/x-www-form-urlencoded", produces = "text/html")
    public ModelAndView search( @ModelAttribute("form") @Valid SearchForm form ) {
        return searchOtherPages( form, String.valueOf( 1 ) );
    }

    @RequestMapping(value = "/results/{page}", method = RequestMethod.POST,
            consumes = "application/x-www-form-urlencoded", produces = "text/html")
    public ModelAndView searchOtherPages( @ModelAttribute("form") @Valid SearchForm form,
                                          @PathVariable @NotBlank @Pattern(regexp = "[\\d]+", message = "Page must be digital") String page ) {
        String searchTitle = form.getSearchTitle();
        LOGGER.debug( "Received POST request for searching" + searchTitle );
        ResultsResponse resultsResponse = searchService.search( searchTitle, page );
        resultsResponse.setCurrentPage( Integer.valueOf( page ) );
        resultsResponse.setSearchTitle( searchTitle );
        return new ModelAndView( "resultsPage", "resultsResponse", resultsResponse );
    }
}
