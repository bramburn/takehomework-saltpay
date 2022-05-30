package co.saltpay.Infrastructure.Repository.Model;

import co.saltpay.Domain.Entity.Employees.Employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

public class EmployeeModel extends Employee {

    public EmployeeModel(String firstName, String lastName, Date date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = date;
    }

    public EmployeeModel(String firstName, String lastName, String date) {
        this.lastName = lastName;
        this.firstName = firstName;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("y/MM/dd");
            Date date1;

            date1 = formatter.parse(date);
            this.dateOfBirth = date1;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }


}
