package io.khasang.gahelp.controller;

import io.khasang.gahelp.entity.Horse;
import io.khasang.gahelp.entity.Mare;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class HorseControllerIntegrationTest {

    private static final String ROOT = "http://localhost:8080/horse";
    private static final String ADD = "/add";
    private static final String GET = "/get";
    private static final String ALL = "/all";
    private static final String DELETE = "/delete";

    @Test
    public void checkHorseAdd() {
        Horse risak = createHorse();

        RestTemplate template = new RestTemplate();
        ResponseEntity<Horse> responseEntity = template.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                Horse.class,
                risak.getId()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Horse receivedHorse = responseEntity.getBody();
        assertNotNull(receivedHorse);
    }

    @Test
    public void checkAllHorses() {
        // h2 - embedded db
        // clear
        createHorse();
        createHorse();

        RestTemplate template = new RestTemplate();
        ResponseEntity<List<Horse>> responseEntity = template.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Horse>>() {
                }
        );

        List<Horse> horses = responseEntity.getBody();
        assertNotNull(horses);
    }

    private Horse createHorse() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Horse horse = prefillHorse();

        HttpEntity<Horse> entity = new HttpEntity<>(horse, headers);
        RestTemplate restTemplate = new RestTemplate();
        Horse createdHorse = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                entity,
                Horse.class
        ).getBody();

        assertNotNull(createdHorse);
        assertEquals("Risak", createdHorse.getName());
        return createdHorse;
    }

    private Horse prefillHorse() {
        Horse horse = new Horse();
        horse.setName("Risak");
        horse.setDescription("Fast");

        Mare mare1 = new Mare();
        mare1.setName("Queen");
        mare1.setDescription("obstinate");

        Mare mare2 = new Mare();
        mare2.setName("Burenka");
        mare2.setDescription("sweet");

        List<Mare> list = new ArrayList<>();
        list.add(mare1);
        list.add(mare2);

        horse.setMares(list);
        return horse;
    }

}
