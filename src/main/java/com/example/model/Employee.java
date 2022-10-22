package com.example.model;

public class Employee {

    private int id;
    private final String firstName;

    private final String lastName;

    private  String email;

    public Employee(int id ,String firstName, String lastName, String email){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Overriding the toString method
    // to find all the values
    @Override
    public String toString()
    {

        return "Employee [id="
                + id + ", firstName="
                + firstName + ", lastName="
                + lastName + ", email="
                + email + "]";
    }

    // Getters and setters of
    // the properties
    public int getId()
    {

        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getFirstName()
    {

        return firstName;
    }

    public String getLastName()
    {

        return lastName;
    }

    public String getEmail()
    {

        return email;
    }

    public void setEmail(String email)
    {

        this.email = email;
    }

}
