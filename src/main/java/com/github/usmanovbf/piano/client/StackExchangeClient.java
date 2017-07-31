package com.github.usmanovbf.piano.client;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.usmanovbf.piano.domain.SearchResult;
import com.github.usmanovbf.piano.domain.json.Item;
import com.github.usmanovbf.piano.domain.json.SearchResponse;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class StackExchangeClient {
    private static final Logger LOGGER = LoggerFactory.getLogger( StackExchangeClient.class );

    private String stackExchangeEndpoint = "http://api.stackexchange.com/2.2/";

    public List<SearchResult> search( String subTitle ) {
        List<SearchResult> results = new ArrayList<>();

        SearchResponse searchResponse = receiveResponse( subTitle );
        for (Item item : searchResponse.getItems()) {
            SearchResult searchResult = new SearchResult();

            Date date = new Date( item.getCreationDate() * 1000L );
            searchResult.setDateOfQuestion( date );

            searchResult.setTitle( item.getTitle() );

            searchResult.setUsername( item.getOwner().getDisplayName() );

            searchResult.setLink( item.getLink() );

            searchResult.setAnswered( item.getIsAnswered() );
            results.add( searchResult );
        }

        return results;
    }

    private SearchResponse receiveResponse( String subTitle ) {
        SearchResponse searchResponse = null;
        try {
            HttpClient httpClient = HttpClientBuilder.create().build();

            String url = stackExchangeEndpoint + "search?page=1&pagesize=20&order=desc&sort=creation&intitle=" + subTitle + "&site=stackoverflow";
            HttpGet getRequest = new HttpGet(
                    url );
            getRequest.addHeader( "accept", "application/json" );

            HttpResponse response = httpClient.execute( getRequest );

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException( "Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode() );
            }

            BufferedReader br = new BufferedReader(
                    new InputStreamReader( ( response.getEntity().getContent() ) ) );

            StringBuilder resultString = new StringBuilder();
            String line;
            while (( line = br.readLine() ) != null) {
                resultString.append( line );
            }

            ObjectMapper mapper = new ObjectMapper();

            searchResponse = mapper.readValue( resultString.toString(), SearchResponse.class );

        } catch (ClientProtocolException e) {
            LOGGER.error( "Error in the HTTP protocol while connecting to stackexhange.com" );
        } catch (IOException e) {
            LOGGER.error( "I/O exception while reading response response" );
        }
        return searchResponse;

    }

}
