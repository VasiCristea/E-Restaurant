package Models;

import Enums.EmployeeRole;

import java.util.UUID;

public class Employee {

    private UUID Id;
    private String Firstname;
    private String Lastname;
    private EmployeeRole Role;

    public Employee() {
    }

    public Employee(String firstname, String lastname, EmployeeRole role) {
        Firstname = firstname;
        Lastname = lastname;
        Role = role;
    }

    public Employee updateBy(Employee employee) {
        this.setId(employee.getId());
        return this;
    }
    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public EmployeeRole getRole() {
        return Role;
    }

    public void setRole(EmployeeRole role) {
        Role = role;
    }


}
