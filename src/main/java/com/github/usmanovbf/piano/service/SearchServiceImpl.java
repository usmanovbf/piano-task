package com.github.usmanovbf.piano.service;

import com.github.usmanovbf.piano.client.StackExchangeClient;
import com.github.usmanovbf.piano.domain.ResultsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private StackExchangeClient sEClient;
    @Value("${default.page}")
    private String defaultPage;
    @Value("${default.page.size}")
    private String defaultPageSize;

    @Override
    public ResultsResponse search( String subTitle ) {
        return sEClient.search( subTitle, defaultPage, defaultPageSize );
    }

    @Override
    public ResultsResponse search( String subTitle, String page, String size ) {
        return sEClient.search( subTitle, page, size );
    }

    @Override
    public ResultsResponse search( String searchTitle, String page ) {
        return sEClient.search( searchTitle, page, defaultPageSize );
    }


}
