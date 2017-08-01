package com.github.usmanovbf.piano.client;

import com.github.usmanovbf.piano.domain.ResultsResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StackExchangeClientTest {
    @Autowired
    private StackExchangeClient client;

    @Test
    public void searchFrom1To20() throws Exception {
        ResultsResponse results = client.search( "java", "1", "20" );
        assertTrue( results.getSearchResults().size() > 1 );
    }

    @Test
    public void searchFrom21To40() throws Exception {
        ResultsResponse results = client.search( "java", "2", "20" );
        assertTrue( results.getSearchResults().size() > 1 );
    }

}