package com.github.usmanovbf.piano.service;


import com.github.usmanovbf.piano.domain.SearchResult;

import java.util.List;

public interface SearchService {
    List<SearchResult> search( String subTitle );


    List<SearchResult> search( String subTitle, String page, String size );

    List<SearchResult> search( String searchTitle, String page );
}
