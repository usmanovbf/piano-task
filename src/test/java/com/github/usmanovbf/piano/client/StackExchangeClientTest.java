package com.github.usmanovbf.piano.client;

import com.github.usmanovbf.piano.domain.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StackExchangeClientTest {

    @Autowired
    private StackExchangeClient client;

    @Test
    public void search() throws Exception {
        List<SearchResult> results = client.search( "java", "1", "20" );
        assertTrue( results .size()>1);
    }

}