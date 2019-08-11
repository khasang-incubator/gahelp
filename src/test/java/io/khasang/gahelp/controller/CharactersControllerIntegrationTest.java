package io.khasang.gahelp.controller;

import io.khasang.gahelp.entity.Characters;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.*;

public class CharactersControllerIntegrationTest {
    private static final String ROOT = "http://localhost:8080/character";
    private static final String ADD = "/add";
    private static final String GET = "/get";
    private static final String DELETE = "/delete";
    private static final String ALL = "/all";
    private static final String UPDATE = "/update";

    @Test
    public void checkCharactersAdd() {
        Characters str = createCharacter();

        RestTemplate template = new RestTemplate();
        ResponseEntity<Characters> responseEntity = template.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                Characters.class,
                str.getId()
        );
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Characters receivedCharacters = responseEntity.getBody();
        assertNotNull(receivedCharacters);
    }

    @Test
    public void checkAllCharacters() {
        createCharacter();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Characters>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Characters>>() {
                }
        );
        List<Characters> characters = responseEntity.getBody();
        assertNotNull(characters);
        assertNotEquals(characters.size(), 0);
    }

    @Test
    public void checkUpdateCharacter() {
        Characters characters = updateCharacter();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<Characters> entity = new HttpEntity<>(characters, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Characters> responseEntity = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.PUT,
                entity,
                Characters.class
        );
        assertNotNull(responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(responseEntity.getBody().getName(), characters.getName());
    }

    @Test
    public void checkDeleteCharacter() {
        Characters characters = createCharacter();
        long deleteID = characters.getId();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Characters> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "/{id}",
                HttpMethod.DELETE,
                null,
                Characters.class,
                deleteID
        );
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    private Characters createCharacter() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Characters characters = preFillCharacter();

        HttpEntity<Characters> entity = new HttpEntity<>(characters, headers);
        RestTemplate restTemplate = new RestTemplate();
        Characters createdCharacters = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                entity,
                Characters.class)
                .getBody();
        assertNotNull(createdCharacters);
        assertEquals("Lightning", createdCharacters.getName());
        return createdCharacters;
    }

    private Characters preFillCharacter() {
        Characters characters = new Characters();
        characters.setName("Lightning");
        characters.setGender("Female");
        characters.setAge(25);
        characters.setPet("Nona");
        characters.setRace("Elf");
        characters.setSpeciality("Assassin");
        characters.setCharisma(11);
        characters.setConstitution(3);
        characters.setStrength(15);
        characters.setDexterity(16);
        characters.setIntelligence(9);
        characters.setWisdom(14);
        return characters;
    }

    private Characters updateCharacter() {
        Characters characters = new Characters();
        characters.setName("Riven");
        characters.setId(44);
        characters.setGender("Female");
        characters.setAge(28);
        characters.setPet("Exiled");
        characters.setRace("Human");
        characters.setSpeciality("Assassin");
        characters.setCharisma(12);
        characters.setConstitution(4);
        characters.setStrength(16);
        characters.setDexterity(17);
        characters.setIntelligence(10);
        characters.setWisdom(15);
        return characters;
    }
}
