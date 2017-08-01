package com.github.usmanovbf.piano.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations="classpath:messages.properties")
public class SearchControllerTest {

    @Value( "${form.welcome.message}" )
    private String FORM_WELCOME_MESSAGE;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void checkOkSearchPage() throws Exception {
        ResponseEntity<String> entity = this.restTemplate.getForEntity("/search", String.class);
        assertThat(entity.getStatusCode()).isEqualTo( HttpStatus.OK);

        assertThat(entity.getBody()).contains(FORM_WELCOME_MESSAGE);
    }



}