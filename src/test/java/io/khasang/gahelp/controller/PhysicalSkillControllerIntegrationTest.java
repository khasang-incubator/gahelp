package io.khasang.gahelp.controller;

import io.khasang.gahelp.entity.PhysicalSkill;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PhysicalSkillControllerIntegrationTest {
    private static final String ROOT = "http://localhost:8080/phys-skill";
    private static final String ADD = "/add";
    private static final String GET = "/get";
    private static final String ALL = "/all";
    private static final String DELETE = "/delete";
    private static final String UPDATE = "/update";

    @Test
    public void checkUpdatePhysicalSkillId() {
        RestTemplate template = new RestTemplate();
        PhysicalSkill physicalSkill = createPhisicalSkill();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        physicalSkill.setName("123");
        physicalSkill.setIsLearned(true);
        physicalSkill.setPowerOfSkill(10);
        physicalSkill.setMinLevelCharacter(1);

        HttpEntity<PhysicalSkill> entity = new HttpEntity<>(physicalSkill, headers);

        ResponseEntity<PhysicalSkill> responseEntityUpdate = template.exchange(
                ROOT + UPDATE + "/{id}",
                HttpMethod.PUT,
                entity,
                PhysicalSkill.class,
                physicalSkill.getId()
        );

        assertEquals(HttpStatus.OK, responseEntityUpdate.getStatusCode());

        ResponseEntity<PhysicalSkill> responseEntity = template.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                PhysicalSkill.class,
                physicalSkill.getId()
        );

        PhysicalSkill updatedSkill = responseEntity.getBody();

        assertEquals(physicalSkill.getName(), updatedSkill.getName());
        assertEquals(physicalSkill.getPowerOfSkill(), updatedSkill.getPowerOfSkill());
    }

    @Test
    public void checkDeletePhysicalSkill() {
        RestTemplate template = new RestTemplate();
        List<PhysicalSkill> skillsBefore =  template.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PhysicalSkill>>() {
                }
        ).getBody();

        PhysicalSkill phSkill = createPhisicalSkill();

        ResponseEntity<PhysicalSkill> responseEntity = template.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                PhysicalSkill.class,
                phSkill.getId()
        );
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());

        ResponseEntity<PhysicalSkill> responseEntityDelete = template.exchange(
                ROOT + DELETE + "/{id}",
                HttpMethod.DELETE,
                null,
                PhysicalSkill.class,
                phSkill.getId()
        );

        List<PhysicalSkill> skillsAfter =  template.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PhysicalSkill>>() {
                }
        ).getBody();
        assertEquals(HttpStatus.OK, responseEntityDelete.getStatusCode());
        assertNotNull(skillsBefore);
        assertNotNull(skillsAfter);
        assertEquals(skillsBefore.size(), skillsAfter.size());
    }

    @Test
    public void checkPhysicalSkillAddGet() {
        PhysicalSkill phSkill = createPhisicalSkill();

        RestTemplate template = new RestTemplate();
        ResponseEntity<PhysicalSkill> responseEntity = template.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                PhysicalSkill.class,
                phSkill.getId()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        PhysicalSkill receivedPhSkill = responseEntity.getBody();
        assertNotNull(receivedPhSkill);
    }

    @Test
    public void checkAllPhysicalSkills() {
        RestTemplate template = new RestTemplate();


        List<PhysicalSkill> skillsBefore = template.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PhysicalSkill>>() {
                }
        ).getBody();

        createPhisicalSkill();
        createPhisicalSkill();

        List<PhysicalSkill> skillsAfter = template.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PhysicalSkill>>() {
                }
        ).getBody();

        assertNotNull(skillsBefore);
        assertNotNull(skillsAfter);
        assertEquals(skillsBefore.size() + 2, skillsAfter.size());
    }

    private PhysicalSkill createPhisicalSkill() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        PhysicalSkill physicalSkill = prefillPhisicalSkill();

        HttpEntity<PhysicalSkill> entity = new HttpEntity<>(physicalSkill, headers);
        RestTemplate restTemplate = new RestTemplate();
        PhysicalSkill createdPhysicalSkill = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                entity,
                PhysicalSkill.class
        ).getBody();

        assertNotNull(createdPhysicalSkill);
        assertEquals("Craft", createdPhysicalSkill.getName());
        return createdPhysicalSkill;
    }

    private PhysicalSkill prefillPhisicalSkill() {
        PhysicalSkill physicalSkill = new PhysicalSkill();
        physicalSkill.setName("Craft");
        physicalSkill.setMinLevelCharacter(10);
        physicalSkill.setPowerOfSkill(50);
        physicalSkill.setIsLearned(false);
        return physicalSkill;
    }
}
