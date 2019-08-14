package io.khasang.gahelp.controller;

import io.khasang.gahelp.dto.EmployeeDto;
import io.khasang.gahelp.entity.Employee;
import io.khasang.gahelp.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    // for pull request example
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.add(employee);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    //    @Secured(value = "ROLE_ADMIN")
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public EmployeeDto getEmployeeById(@PathVariable("id") long id) {
        return employeeService.getById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getAll() {
        return employeeService.getAll();
    }
}
