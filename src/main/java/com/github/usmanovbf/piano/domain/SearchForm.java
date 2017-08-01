package com.github.usmanovbf.piano.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;


public class SearchForm {
    @NotBlank(message = "Search substring of title should be present")
    private String searchTitle;

    public String getSearchTitle() {
        return searchTitle;
    }

    public void setSearchTitle( String searchTitle ) {
        this.searchTitle = searchTitle;
    }
}
