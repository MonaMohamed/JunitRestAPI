package com.example.controller;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import com.example.service.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Implementing a GET method
    // to get the list of all
    // the employees
    @GetMapping(
            value = "/getAllEmployees",
            produces = "application/json")
    public Employees getEmployees() {
        return employeeService.getAllEmployees();
    }

    // Create a POST method
    // to add an employee
    // to the list
    @PostMapping(
            value = "/addEmployee",
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee){
        try
        {
            int id = employeeService.getAllEmployees().getEmployeeList().size() + 1;
            employee.setId(id);
        }catch (Exception e){
            System.out.println(e);
        }

        employeeService.addEmpolyee(employee);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                .buildAndExpand(employee.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
