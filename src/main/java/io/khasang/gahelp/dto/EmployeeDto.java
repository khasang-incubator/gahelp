package io.khasang.gahelp.dto;

import io.khasang.gahelp.entity.Car;
import io.khasang.gahelp.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDto {

    List<CarDto> carDtoList = new ArrayList<>();
    private long id;
    private String name;
    private String title;

    public EmployeeDto getEmployeeDto(Employee employee) {
        List<CarDto> carDtos = new ArrayList<>();
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setTitle(employee.getTitle());

        getCarDtoFromCar(employee, carDtos);

        employeeDto.setCarDtoList(carDtos);
        return employeeDto;
    }

    private void getCarDtoFromCar(Employee employee, List<CarDto> carDtos) {
        for (Car car : employee.getCarList()) {
            CarDto carDto = new CarDto();
            carDto.setId(car.getId());
            carDto.setModel(car.getModel());
            carDto.setYear(car.getYear());

            carDtos.add(carDto);
        }
    }

    public List<CarDto> getCarDtoList() {
        return carDtoList;
    }

    public void setCarDtoList(List<CarDto> carDtoList) {
        this.carDtoList = carDtoList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
