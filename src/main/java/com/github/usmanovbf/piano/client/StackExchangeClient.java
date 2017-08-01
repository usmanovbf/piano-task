package com.github.usmanovbf.piano.client;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.usmanovbf.piano.domain.ResultsResponse;
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
import org.springframework.stereotype.Component;

import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class StackExchangeClient {
    private static final Logger LOGGER = LoggerFactory.getLogger( StackExchangeClient.class );

    @Value("${i.o.exception.message}")
    private String I_O_EXCEPTION_MESSAGE;
    @Value("${client.protocol.exception.message}")
    private String CLIENT_PROTOCOL_EXCEPTION_MESSAGE;
    @Value("${stack.exchange.endpoint}")
    private String STACK_EXCHANGE_ENDPOINT;
    @Value("${not.ok.http.status}")
    private String NOT_OK_HTTP_STATUS;


    public ResultsResponse search( String subTitle, String page, String size ) {


        SearchResponse searchResponse = receiveResponse( subTitle, page, size );

        ResultsResponse response = new ResultsResponse();
        for (Item item : searchResponse.getItems()) {
            SearchResult searchResult = new SearchResult();

            Date date = new Date( item.getCreationDate() * 1000L );
            searchResult.setDateOfQuestion( date );

            searchResult.setTitle( item.getTitle() );

            searchResult.setUsername( item.getOwner().getDisplayName() );

            searchResult.setLink( item.getLink() );

            searchResult.setAnswered( item.getIsAnswered() );
            response.getSearchResults().add( searchResult );
        }

        response.setHasMore( searchResponse.getHasMore() );

        return response;
    }

    private SearchResponse receiveResponse( String subTitle, String page, String size ) {
        SearchResponse searchResponse;
        try {
            HttpClient httpClient = HttpClientBuilder.create().build();

            String url = new StringBuilder().append( STACK_EXCHANGE_ENDPOINT )
                    .append( "search?page=" ).append( page )
                    .append( "&pagesize=" ).append( size )
                    .append( "&order=desc&sort=creation&intitle=" ).append( subTitle )
                    .append( "&site=stackoverflow" ).toString();
            HttpGet getRequest = new HttpGet(
                    url );
            getRequest.addHeader( "accept", MediaType.APPLICATION_JSON );

            HttpResponse response = httpClient.execute( getRequest );

            if (response.getStatusLine().getStatusCode() != 200) {
                String message = NOT_OK_HTTP_STATUS
                        + response.getStatusLine().getStatusCode();

                LOGGER.error( message );
                throw new RuntimeException( message );
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
            LOGGER.error( CLIENT_PROTOCOL_EXCEPTION_MESSAGE );
            throw new RuntimeException( CLIENT_PROTOCOL_EXCEPTION_MESSAGE );
        } catch (IOException e) {
            LOGGER.error( I_O_EXCEPTION_MESSAGE );
            throw new RuntimeException( I_O_EXCEPTION_MESSAGE );
        }
        return searchResponse;

    }

}
