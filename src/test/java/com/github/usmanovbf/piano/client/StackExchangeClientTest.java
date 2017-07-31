package com.github.usmanovbf.piano.client;

import com.github.usmanovbf.piano.domain.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
public class StackExchangeClientTest {

    @Autowired
    private StackExchangeClient client;

    @Test
    public void search() throws Exception {
        List<SearchResult> results = client.search( "java", "1", "20" );
        assertNotNull( results );
    }

}