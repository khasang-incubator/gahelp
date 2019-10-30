package io.khasang.gahelp.controller;

import io.khasang.gahelp.entity.Role;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.*;

public class RoleControllerIntegrationTest {
    private static final String ROOT = "http://localhost:8080/role";
    private static final String ADD = "/add";
    private static final String ALL = "/all";
    private static final String GET = "/get";
    private static final String DELETE = "/delete";
    private static final String UPDATE = "/update";

    @Test
    public void checkRoleAdd() {
        Role role = createRole();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Role> entity = restTemplate.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                Role.class,
                role.getId()
        );
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        Role receivedRole = entity.getBody();
        assertNotNull(receivedRole);
    }

    @Test
    public void checkAllRoles() {
        createRole();
        createRole();

        RestTemplate template = new RestTemplate();
        ResponseEntity<List<Role>> entity = template.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Role>>() {
                }
        );
        List<Role> roles = entity.getBody();
        assertNotNull(roles);
        assertNotEquals(roles.size(), 0);
    }

    @Test
    public void checkUpdateRole() {
        Role updatedRole = updatedRole();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<Role> entity = new HttpEntity<>(updatedRole, headers);

        RestTemplate template = new RestTemplate();
        ResponseEntity<Role> responseEntity = template.exchange(
                ROOT + UPDATE,
                HttpMethod.PUT,
                entity,
                Role.class
        );
        assertNotNull(responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(responseEntity.getBody().getName(), updatedRole.getName());
    }

    @Test
    public void checkDeleteRole() {
        Role newRole = createRole();
        long deleteID = newRole.getId();

        RestTemplate template = new RestTemplate();
        ResponseEntity<Role> responseEntity = template.exchange(
                ROOT + DELETE + "/{id}",
                HttpMethod.DELETE,
                null,
                Role.class,
                deleteID
        );
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    private Role createRole() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Role role = preFillRole();

        HttpEntity<Role> entity = new HttpEntity<>(role, headers);
        RestTemplate restTemplate = new RestTemplate();
        Role createdRole = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                entity,
                Role.class).getBody();
        assertNotNull(createdRole);
        assertEquals("Admin", createdRole.getName());
        return createdRole;
    }


    private Role preFillRole() {
        Role role = new Role();
        role.setName("Admin");
        role.setType("Administration");
        role.setDescription("Role for setting all other roles in");
        return role;
    }

    private Role updatedRole() {
        Role role = new Role();
        role.setId(25);
        role.setName("User");
        role.setType("Casual");
        role.setDescription("Role for having fun");
        return role;
    }
}
