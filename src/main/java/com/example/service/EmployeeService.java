package com.example.service;

import com.example.model.Employee;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeService {

    private static Employees employeesList = new Employees();

    // This static block is executed
    // before executing the main
    // block
    static {
        employeesList.getEmployeeList().add(new Employee(
                1,
                "Mona",
                "Mohamed",
                "Mona@test.com"
        ));
        employeesList.getEmployeeList().add(new Employee(
                2,
                "Nour",
                "Mohamed",
                "nour@test.com"
        ));
        employeesList.getEmployeeList().add(new Employee(
                3,
                "Islam",
                "Mohmed",
                "Islam@test.com"
        ));
        employeesList.getEmployeeList().add(new Employee(
                4,
                "Ahmed",
                "Mohamed",
                "Ahmed@test.com"
        ));
    }

    public Employees getAllEmployees(){
        return employeesList;
    }

    public Employee addEmpolyee(Employee employee){
        employeesList.getEmployeeList().add(employee);
        return employee;
    }
}
