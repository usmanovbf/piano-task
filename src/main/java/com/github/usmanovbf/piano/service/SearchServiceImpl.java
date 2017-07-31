package com.github.usmanovbf.piano.service;

import com.github.usmanovbf.piano.client.StackExchangeClient;
import com.github.usmanovbf.piano.domain.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private StackExchangeClient sEClient;
    @Value("${default.page}")
    private String defaultPage;
    @Value("${default.page.size}")
    private String defaultPageSize;

    @Override
    public List<SearchResult> search( String subTitle ) {
        return sEClient.search( subTitle, defaultPage, defaultPageSize );
    }

    @Override
    public List<SearchResult> search( String subTitle, String page, String size ) {
        return sEClient.search( subTitle, page, size );
    }

    @Override
    public List<SearchResult> search( String searchTitle, String page ) {
        return sEClient.search( searchTitle, page, defaultPageSize );
    }
}
