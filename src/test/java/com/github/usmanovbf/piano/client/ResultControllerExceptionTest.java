package com.github.usmanovbf.piano.client;

import com.github.usmanovbf.piano.controller.SearchController;
import com.github.usmanovbf.piano.domain.SearchForm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:test-application.properties")
@AutoConfigureMockMvc
public class ResultControllerExceptionTest {

    @Value("${stack.exchange.endpoint}")
    private String STACK_EXCHANGE_ENDPOINT;

    @Mock
    private SearchController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void check404Result() throws Exception {
        SearchForm form = new SearchForm();
        mockMvc.perform(post("/results").contentType( MediaType.APPLICATION_FORM_URLENCODED).sessionAttr("form", form )).andExpect( status().isBadRequest() );

    }


}