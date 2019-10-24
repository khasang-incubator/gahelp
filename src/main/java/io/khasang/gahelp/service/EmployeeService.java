package io.khasang.gahelp.service;

import io.khasang.gahelp.dto.EmployeeDto;
import io.khasang.gahelp.entity.Employee;

import java.util.List;

public interface EmployeeService {
    /**
     * service for adding employee
     *
     * @param employee for adding
     * @return added employee
     */
    Employee add(Employee employee);

    /**
     * service for getting employee by id
     *
     * @param id - employee's id
     * @return specific employee by id
     */
    EmployeeDto getById(long id);

    /**
     * service for getting all employee
     *
     * @return all employees
     */
    List<Employee> getAll();

    /**
     * service for deletion employee
     *
     * @param id - employee's id for delete
     * @return deleted employee
     */
    Employee delete(long id);

    /**
     * service for updating employee
     *
     * @param employee for update
     * @return updated employee
     */
    Employee update(Employee employee);
}
