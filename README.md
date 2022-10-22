# Unit Testing Rest Services with Spring Boot and JUnit
We want to create a unit test for EmployeeController which is a Rest Controller.<br/> 
EmployeeController exposes two service methods - one Get and one Post. We will write unit tests for both these service methods.


### In the unit test
We will mock out the Employeeservice using Mockito <br/>
We will use Mock MVC framework to launch only EmployeeController.<br/>
A key part of unit testing is to restrict the scope to a minimum. In this unit test, we want to test only the methods in EmployeeController.<br/>

### Following is the order we do things in this guide:
1- Bootstrap a project using Spring Initializr. <br/>
2- Implement a Business Service for our API - Employeeservice. <br/>
3- Implement the API - using EmployeeController. First we implement the GET methods and then the POST methods. <br/>
4- Unit Test the API. <br/>
