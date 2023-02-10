package com.sky.people.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sky.people.dto.PersonReqDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // loads with all your beans
@AutoConfigureMockMvc // Sets up a testing library
public class PersonIntegrationTest {

    @Autowired // tells Spring to inject the mvc object into my tests class
    private MockMvc mvc;
    @Autowired
    private ObjectMapper mapper;
    @Test
    void testCreate() throws Exception {
        // body, method, url, content-type
        PersonReqDTO newPerson = new PersonReqDTO("Steve", 42, "SW eng", "HY667766L");
        String newPersonAsJson = this.mapper.writeValueAsString(newPerson);
        System.out.println("JSON: " + newPersonAsJson);
        RequestBuilder req = MockMvcRequestBuilders.post("/create").content(newPersonAsJson).contentType(MediaType.APPLICATION_JSON);

    }
}
