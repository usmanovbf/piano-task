package com.github.usmanovbf.piano.service;


import com.github.usmanovbf.piano.domain.ResultsResponse;


public interface SearchService {
    /**
     * Search among titles with showing results where
     * count of items corresponds to defaultPage and defaultPageSize
     * from .property files
     * @param subTitle title to search
     * @return info about each result
     */
    ResultsResponse search( String subTitle );

    /**
     * Search among titles with showing results
     * @param subTitle title to search
     * @param page custom page
     * @param size custom size of items on a page
     * @return info about each result
     */
    ResultsResponse search( String subTitle, String page, String size );

    /**
     * Search among titles with showing results
     * @param searchTitle title to search
     * @param page custom page
     * @return info about each result
     */
    ResultsResponse search( String searchTitle, String page );

}
