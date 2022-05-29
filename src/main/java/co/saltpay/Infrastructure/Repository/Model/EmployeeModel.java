package co.saltpay.Infrastructure.Repository.Model;

import co.saltpay.Domain.Entity.Employees.Employee;

import java.util.Date;

public class EmployeeModel extends Employee {
    public EmployeeModel(String firstName, String lastName, Date date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = date;
    }


}
