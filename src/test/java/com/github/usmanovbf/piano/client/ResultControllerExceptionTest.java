package com.github.usmanovbf.piano.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations="classpath:test-application.properties")
public class ResultControllerExceptionTest {

    @Autowired
    private TestRestTemplate restTemplate;
//
//    @Test(expected = RuntimeException.class)
//    public void check404Result() throws Exception {
//        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
//        map.add("searchTitle", "java");
//
//
//        ResponseEntity<String> entity = this.restTemplate.postForEntity("/results", map, String.class );
//        assertThat(entity.getStatusCode()).isEqualTo( HttpStatus.NOT_FOUND);
//
//    }



}