package co.saltpay.unitTest.Domain.Entity.Employees;

import co.saltpay.Domain.Entity.Employees.Employee;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {

    @Test
    void CheckIfEmployeeEntityHasProps() throws NoSuchFieldException {

        Employee emp = new Employee();

        Field firstNameField = emp.getClass().getDeclaredField("firstName");
        Field lastNameField = emp.getClass().getDeclaredField("lastName");
        Field dateOfBirthField = emp.getClass().getDeclaredField("dateOfBirth");

        assertEquals("class java.lang.String", lastNameField.getType().toString());
        assertEquals("class java.lang.String", firstNameField.getType().toString());
        assertEquals("class java.util.Date", dateOfBirthField.getType().toString());


    }
}
