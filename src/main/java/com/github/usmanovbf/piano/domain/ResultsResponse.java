package com.github.usmanovbf.piano.domain;

import java.util.ArrayList;
import java.util.List;


/**
 * Data Transfer Object for UI on results page
 */
public class ResultsResponse {
    private Integer currentPage;
    private String searchTitle;
    private boolean hasMore;
    private List<SearchResult> searchResults;

    public ResultsResponse(  ) {
        this.searchResults = new ArrayList<>(  );
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage( Integer currentPage ) {
        this.currentPage = currentPage;
    }

    public List<SearchResult> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults( List<SearchResult> searchResults ) {
        this.searchResults = searchResults;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore( boolean hasMore ) {
        this.hasMore = hasMore;
    }

    public String getSearchTitle() {
        return searchTitle;
    }

    public void setSearchTitle( String searchTitle ) {
        this.searchTitle = searchTitle;
    }
}
