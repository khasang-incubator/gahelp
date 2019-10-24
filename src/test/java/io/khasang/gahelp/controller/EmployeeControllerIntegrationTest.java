package io.khasang.gahelp.controller;

import io.khasang.gahelp.dto.EmployeeDto;
import io.khasang.gahelp.entity.Car;
import io.khasang.gahelp.entity.Employee;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EmployeeControllerIntegrationTest {
    private static final String ROOT = "http://localhost:8080/employee";
    private static final String ADD = "/add";
    private static final String GET = "/get";
    private static final String ALL = "/all";
    private static final String DELETE = "/delete";

    @Test
    public void checkEmployeeAdd() {
        Employee employee = createEmployee();

        RestTemplate template = new RestTemplate();
        ResponseEntity<EmployeeDto> responseEntity = template.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                EmployeeDto.class,
                employee.getId()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        EmployeeDto receivedEmployee = responseEntity.getBody();
        assertNotNull(receivedEmployee);
    }

    @Test
    public void checkAllEmployees() {
        // h2 - embedded db
        // clear
        createEmployee();
        createEmployee();

        RestTemplate template = new RestTemplate();
        ResponseEntity<List<Employee>> responseEntity = template.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Employee>>() {
                }
        );

        List<Employee> employees = responseEntity.getBody();
        assertNotNull(employees);
    }

    private Employee createEmployee() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Employee employee = prefillEmployee();

        HttpEntity<Employee> entity = new HttpEntity<>(employee, headers);
        RestTemplate restTemplate = new RestTemplate();
        Employee createdEmployee = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                entity,
                Employee.class
        ).getBody();

        assertNotNull(createdEmployee);
        assertEquals("Jack", createdEmployee.getName());
        return createdEmployee;
    }

    private Employee prefillEmployee() {
        Employee employee = new Employee();
        employee.setName("Jack");
        employee.setTitle("The Captain");

        Car vaz = new Car();
        vaz.setModel("VAZ");
        vaz.setYear(LocalDate.of(2017, Month.APRIL, 12));

        Car bmw = new Car();
        bmw.setModel("BMW");
        bmw.setYear(LocalDate.of(2005, Month.JANUARY, 11));
        List<Car> cars = new ArrayList<>();
        cars.add(vaz);
        cars.add(bmw);

        employee.setCarList(cars);

        return employee;
    }
}
