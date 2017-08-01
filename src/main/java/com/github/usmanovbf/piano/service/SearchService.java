package com.github.usmanovbf.piano.service;


import com.github.usmanovbf.piano.domain.ResultsResponse;

public interface SearchService {
    ResultsResponse search( String subTitle );


    ResultsResponse search( String subTitle, String page, String size );

    ResultsResponse search( String searchTitle, String page );

}
