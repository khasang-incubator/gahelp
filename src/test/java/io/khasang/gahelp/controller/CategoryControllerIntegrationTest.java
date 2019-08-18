package io.khasang.gahelp.controller;

import io.khasang.gahelp.entity.Category;
import io.khasang.gahelp.entity.Product;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CategoryControllerIntegrationTest {
    private static final String ROOT = "http://localhost:8080/category";
    private static final String ADD = "/add";
    private static final String GET = "/get";
    private static final String ALL = "/all";
    private static final String DELETE = "/delete";
    private static final String UPDATE = "/update";

    @Test
    public void checkUpdateCategory() {
        RestTemplate template = new RestTemplate();
        Category category = createCategory();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        category.setName("123");
        category.setType("AC");

        HttpEntity<Category> entity = new HttpEntity<>(category, headers);

        ResponseEntity<Category> responseEntityUpdate = template.exchange(
                ROOT + UPDATE + "/{id}",
                HttpMethod.PUT,
                entity,
                Category.class,
                category.getId()
        );

        assertEquals(HttpStatus.OK, responseEntityUpdate.getStatusCode());

        ResponseEntity<Category> responseEntity = template.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                Category.class,
                category.getId()
        );

        Category updatedCategory = responseEntity.getBody();

        assertEquals(category.getName(), updatedCategory.getName());
        assertEquals(category.getType(), updatedCategory.getType());
    }

    @Test
    public void checkDeleteCategory() {
        RestTemplate template = new RestTemplate();
        List<Category> categoryBefore =  template.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Category>>() {
                }
        ).getBody();

        Category category = createCategory();

        ResponseEntity<Category> responseEntity = template.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                Category.class,
                category.getId()
        );
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());

        ResponseEntity<Category> responseEntityDelete = template.exchange(
                ROOT + DELETE + "/{id}",
                HttpMethod.DELETE,
                null,
                Category.class,
                category.getId()
        );

        List<Category> categoryAfter =  template.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Category>>() {
                }
        ).getBody();
        assertEquals(HttpStatus.OK, responseEntityDelete.getStatusCode());
        assertNotNull(categoryBefore);
        assertNotNull(categoryAfter);
        assertEquals(categoryBefore.size(), categoryAfter.size());
    }

    @Test
    public void checkCategoryAddGet() {
        Category category = createCategory();
        createCategory();

        RestTemplate template = new RestTemplate();
        ResponseEntity<Category> responseEntity = template.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                Category.class,
                category.getId()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Category receivedCategory = responseEntity.getBody();
        assertNotNull(receivedCategory);
    }

    @Test
    public void checkAllCategories() {
        RestTemplate template = new RestTemplate();


        List<Category> categoriesBefore = template.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Category>>() {
                }
        ).getBody();

        createCategory();
        createCategory();

        List<Category> categoriesAfter = template.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Category>>() {
                }
        ).getBody();

        assertNotNull(categoriesBefore);
        assertNotNull(categoriesAfter);
        assertEquals(categoriesBefore.size() + 2, categoriesAfter.size());
    }

    private Category createCategory() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Category category = prefillCategory();

        HttpEntity<Category> entity = new HttpEntity<>(category, headers);
        RestTemplate restTemplate = new RestTemplate();
        Category createdCategory = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                entity,
                Category.class
        ).getBody();

        assertNotNull(createdCategory);
        assertEquals("Motors", createdCategory.getName());
        return createdCategory;
    }

    private Category prefillCategory() {
        Category category = new Category();
        category.setName("Motors");
        category.setType("DC");

        List<Product> products = new ArrayList<>();

        Product product1 = new Product();
        product1.setName("Monitor");
        product1.setDescription("Large 27\"");
        product1.setPrice(1300.5);
        Product product2 = new Product();
        product2.setName("PC");
        product2.setDescription("Very big box!");
        product2.setPrice(8000.0);

        products.add(product1);
        products.add(product2);

        category.setProducts(products);

        return category;
    }
}
