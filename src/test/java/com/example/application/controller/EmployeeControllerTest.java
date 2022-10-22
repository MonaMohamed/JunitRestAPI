package com.example.application.controller;

import com.example.controller.EmployeeController;
import com.example.model.Employee;
import com.example.service.EmployeeService;
import com.example.service.Employees;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = EmployeeController.class)
@WithMockUser
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void getAllEmployeeList() throws Exception{

        Employees employeesList = new Employees();

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

        Mockito.when(employeeService.getAllEmployees()).thenReturn(employeesList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/employees/getAllEmployees")
                        .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

       String expected = "{\"employeeList\":[{\"id\":1,\"firstName\":\"Mona\",\"lastName\":\"Mohamed\",\"email\":\"Mona@test.com\"},{\"id\":2,\"firstName\":\"Nour\",\"lastName\":\"Mohamed\",\"email\":\"nour@test.com\"},{\"id\":3,\"firstName\":\"Islam\",\"lastName\":\"Mohmed\",\"email\":\"Islam@test.com\"},{\"id\":4,\"firstName\":\"Ahmed\",\"lastName\":\"Mohamed\",\"email\":\"Ahmed@test.com\"}]}";

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals(expected,result.getResponse().getContentAsString());

    }

    @Test
    public void addEmployee() throws Exception{

        Employee mockEmployee = new Employee(5,"MockFirstName","MockLastName","MockUser@test.com");

        String mockEmployeeJson = "{\"id\":5,\"firstName\":\"MockFirstName\",\"lastName\":\"MockLastName\",\"email\":\"MockUser@test.com\"}";

        Mockito.when(employeeService.addEmpolyee(Mockito.any(Employee.class))).thenReturn(mockEmployee);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/employees/addEmployee")
                .accept(MediaType.APPLICATION_JSON)
                .content(mockEmployeeJson).contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }
}
