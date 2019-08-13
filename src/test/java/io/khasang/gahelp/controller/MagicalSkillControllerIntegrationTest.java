package io.khasang.gahelp.controller;

import io.khasang.gahelp.entity.MagicalSkill;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MagicalSkillControllerIntegrationTest {
    private static final String ROOT = "http://localhost:8080/mag-skill";
    private static final String ADD = "/add";
    private static final String GET = "/get";
    private static final String ALL = "/all";
    private static final String DELETE = "/delete";
    private static final String UPDATE = "/update";

    @Test
    public void checkUpdateMagicalSkillId() {
        RestTemplate template = new RestTemplate();
        MagicalSkill magicalSkill = createMagicalSkill();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        magicalSkill.setName("123");
        magicalSkill.setDescription("very fastest");
        magicalSkill.setPowerOfSkill(10);

        HttpEntity<MagicalSkill> entity = new HttpEntity<>(magicalSkill, headers);

        ResponseEntity<MagicalSkill> responseEntityUpdate = template.exchange(
                ROOT + UPDATE + "/{id}",
                HttpMethod.PUT,
                entity,
                MagicalSkill.class,
                magicalSkill.getId()
        );

        assertEquals(HttpStatus.OK, responseEntityUpdate.getStatusCode());

        ResponseEntity<MagicalSkill> responseEntity = template.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                MagicalSkill.class,
                magicalSkill.getId()
        );

        MagicalSkill updatedSkill = responseEntity.getBody();

        assertEquals(magicalSkill.getName(), updatedSkill.getName());
        assertEquals(magicalSkill.getPowerOfSkill(), updatedSkill.getPowerOfSkill());
    }

    @Test
    public void checkDeleteMagicalSkill() {
        RestTemplate template = new RestTemplate();
        List<MagicalSkill> skillsBefore =  template.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<MagicalSkill>>() {
                }
        ).getBody();

        MagicalSkill phSkill = createMagicalSkill();

        ResponseEntity<MagicalSkill> responseEntity = template.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                MagicalSkill.class,
                phSkill.getId()
        );
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());

        ResponseEntity<MagicalSkill> responseEntityDelete = template.exchange(
                ROOT + DELETE + "/{id}",
                HttpMethod.DELETE,
                null,
                MagicalSkill.class,
                phSkill.getId()
        );

        List<MagicalSkill> skillsAfter =  template.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<MagicalSkill>>() {
                }
        ).getBody();
        assertEquals(HttpStatus.OK, responseEntityDelete.getStatusCode());
        assertNotNull(skillsBefore);
        assertNotNull(skillsAfter);
        assertEquals(skillsBefore.size(), skillsAfter.size());
    }

    @Test
    public void checkMagicalSkillAddGet() {
        MagicalSkill phSkill = createMagicalSkill();

        RestTemplate template = new RestTemplate();
        ResponseEntity<MagicalSkill> responseEntity = template.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                MagicalSkill.class,
                phSkill.getId()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        MagicalSkill receivedPhSkill = responseEntity.getBody();
        assertNotNull(receivedPhSkill);
    }

    @Test
    public void checkAllMagicalSkills() {
        RestTemplate template = new RestTemplate();


        List<MagicalSkill> skillsBefore = template.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<MagicalSkill>>() {
                }
        ).getBody();

        createMagicalSkill();
        createMagicalSkill();

        List<MagicalSkill> skillsAfter = template.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<MagicalSkill>>() {
                }
        ).getBody();

        assertNotNull(skillsBefore);
        assertNotNull(skillsAfter);
        assertEquals(skillsBefore.size() + 2, skillsAfter.size());
    }

    private MagicalSkill createMagicalSkill() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        MagicalSkill magicalSkill = prefillMagicalSkill();

        HttpEntity<MagicalSkill> entity = new HttpEntity<>(magicalSkill, headers);
        RestTemplate restTemplate = new RestTemplate();
        MagicalSkill createdMagicalSkill = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                entity,
                MagicalSkill.class
        ).getBody();

        assertNotNull(createdMagicalSkill);
        assertEquals("Craft", createdMagicalSkill.getName());
        return createdMagicalSkill;
    }

    private MagicalSkill prefillMagicalSkill() {
        MagicalSkill magicalSkill = new MagicalSkill();
        magicalSkill.setName("Craft");
        magicalSkill.setDescription("fast");
        magicalSkill.setPowerOfSkill(50);
        return magicalSkill;
    }
}
