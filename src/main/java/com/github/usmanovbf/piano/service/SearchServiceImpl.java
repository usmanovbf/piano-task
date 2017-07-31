package com.github.usmanovbf.piano.service;

import com.github.usmanovbf.piano.client.StackExchangeClient;
import com.github.usmanovbf.piano.domain.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private StackExchangeClient sEClient;;

    @Override
    public List<SearchResult> search( String subTitle ) {
        return sEClient.search(subTitle);
    }
}
