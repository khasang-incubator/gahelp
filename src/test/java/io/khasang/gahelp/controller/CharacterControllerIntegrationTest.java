package io.khasang.gahelp.controller;

import io.khasang.gahelp.entity.Character;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.*;

public class CharacterControllerIntegrationTest {
    private static final String ROOT = "http://localhost:8080/character";
    private static final String ADD = "/add";
    private static final String GET = "/get";
    private static final String DELETE = "/delete";
    private static final String ALL = "/all";
    private static final String UPDATE = "/update";

    @Test
    public void checkCharacterAdd() {
        Character str = createCharacter();

        RestTemplate template = new RestTemplate();
        ResponseEntity<Character> responseEntity = template.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                Character.class,
                str.getId()
        );
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Character receivedCharacter = responseEntity.getBody();
        assertNotNull(receivedCharacter);
    }

    @Test
    public void checkAllCharacters() {
        createCharacter();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Character>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Character>>() {
                }
        );
        List<Character> characters = responseEntity.getBody();
        assertNotNull(characters);
        assertNotEquals(characters.size(), 0);
    }

    @Test
    public void checkUpdateCharacter() {
        // Select ID of an object to update
        int updateID = 1;

        Character character = updateCharacter();
        HttpEntity<Character> entity = new HttpEntity<>(character, null);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Character> responseEntity = restTemplate.exchange(
                ROOT + UPDATE + "/{id}",
                HttpMethod.PUT,
                entity,
                Character.class,
                updateID
        );
        assertNotNull(responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(responseEntity.getBody().getName(), character.getName());
    }

    @Test
    public void checkDeleteCharacter() {
        Character character = createCharacter();
        long deleteID = character.getId();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Character> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "/{id}",
                HttpMethod.DELETE,
                null,
                Character.class,
                deleteID
        );
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    private Character createCharacter() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Character character = preFillCharacter();

        HttpEntity<Character> entity = new HttpEntity<>(character, headers);
        RestTemplate restTemplate = new RestTemplate();
        Character createdCharacter = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                entity,
                Character.class)
                .getBody();
        assertNotNull(createdCharacter);
        assertEquals("Strength", createdCharacter.getName());
        return createdCharacter;
    }

    private Character preFillCharacter() {
        Character character = new Character();
        character.setName("Strength");
        character.setAlias("STR");
        character.setDescription("This is just a fake param for testing purposes");
        character.setStat(10);
        return character;
    }

    private Character updateCharacter() {
        Character character = new Character();
        character.setName("Agility");
        character.setAlias("AGI");
        character.setDescription("THis most OP parameter to have in MMO game");
        character.setStat(5);
        return character;
    }
}
