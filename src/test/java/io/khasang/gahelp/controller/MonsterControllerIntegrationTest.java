package io.khasang.gahelp.controller;

import io.khasang.gahelp.entity.Monster;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MonsterControllerIntegrationTest {

    private static final String ROOT = "http://localhost:8080/monster";
    private static final String ADD = "/add";
    private static final String GET = "/get";
    private static final String ALL = "/all";
    private static final String DELETE = "/delete";
    private static final String UPDATE = "/update";

    @Test
    public void checkMonsterAdd() {
        Monster monster = createMonster();

        RestTemplate template = new RestTemplate();
        ResponseEntity<Monster> responseEntity = template.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                Monster.class,
                monster.getId()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Monster receivedMonster = responseEntity.getBody();
        assertNotNull(receivedMonster);
    }

    @Test
    public void checkAllMonster() {
        // h2 - embedded db
        // clear
        createMonster();
        createMonster();

        RestTemplate template = new RestTemplate();
        ResponseEntity<List<Monster>> responseEntity = template.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Monster>>() {
                }
        );

        List<Monster> monsters = responseEntity.getBody();
        assertNotNull(monsters);
    }

    @Test
    public void checkDeleteMonster() {
        Monster troll = createMonster();
        RestTemplate template = new RestTemplate();
        ResponseEntity<Monster> responseEntity = template.exchange(
                ROOT + DELETE + "/{id}",
                HttpMethod.DELETE,
                null,
                Monster.class,
                troll.getId()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Monster receivedMonster = responseEntity.getBody();
        assertNotNull(receivedMonster);
    }

    @Test
    public void checkUpdateMonster() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Monster monster = createMonster();
        System.out.println("Monster with id =" + monster.getId() + " has OLD hp: --> "+monster.getHealthPoint());
        int newMonsterHealthPoint = monster.getHealthPoint() + getRandomIntForHpAdd();
        System.out.println("Monster with id =" + monster.getId() + " has HEW hp: --> " + newMonsterHealthPoint);
        monster.setHealthPoint(newMonsterHealthPoint);
        HttpEntity<Monster> entity = new HttpEntity<>(monster, headers);

        RestTemplate template = new RestTemplate();
        ResponseEntity<Monster> responseEntity = template.exchange(
                ROOT + UPDATE,
                HttpMethod.PUT,
                entity,
                Monster.class
        );

        RestTemplate restTemplate2 = new RestTemplate();
        Monster getMonster = restTemplate2.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                Monster.class,
                monster.getId()
        ).getBody();

        assertEquals(newMonsterHealthPoint, getMonster.getHealthPoint());

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Monster receivedMonster = responseEntity.getBody();
        assertNotNull(receivedMonster);
    }

    private int getRandomIntForHpAdd() {
        return new Random().nextInt(95);
    }

    private Monster createMonster() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Monster monster = profileMonster();

        HttpEntity<Monster> entity = new HttpEntity<>(monster, headers);
        RestTemplate restTemplate = new RestTemplate();
        Monster createdMonster = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                entity,
                Monster.class
        ).getBody();

        assertNotNull(createdMonster);
        assertEquals("troll", createdMonster.getType());
        return createdMonster;
    }

    private Monster profileMonster() {
        Monster monster = new Monster();
        monster.setType("troll");
        monster.setHealthPoint(6);
        monster.setMana(3);
        monster.setStrength(7);
        monster.setIntelligence(1);
        monster.setAgility(5);
        monster.setEndurance(9);
        monster.setLevel(1);
        monster.setIntuition(10);
        return monster;
    }
}
