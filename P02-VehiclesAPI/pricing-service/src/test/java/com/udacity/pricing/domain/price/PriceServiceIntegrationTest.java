package com.udacity.pricing.domain.price;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PriceServiceIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    public void testGetAllPrices(){
        var response = this.restTemplate.getForEntity(
                "http://localhost:"+port+"/prices", Map.class);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    public void testGetOnePrice(){
        var response = this.restTemplate.getForEntity(
                "http://localhost:"+port+"/prices/1", Map.class);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
