package co.saltpay.Employees;

import co.saltpay.Domain.Entity.Employees.Employee;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class EmployeeTest {

    @Test
    public void CheckIfEmployeeEntityHasProps() throws NoSuchFieldException {

        Employee emp = new Employee();

        Field firstNameField = emp.getClass().getDeclaredField("firstName");
        Field lastNameField = emp.getClass().getDeclaredField("lastName");
        Field dateOfBirthField = emp.getClass().getDeclaredField("dateOfBirth");

        assertEquals("class java.lang.String", lastNameField.getType().toString());
        assertEquals("class java.lang.String", firstNameField.getType().toString());
        assertEquals("class java.util.Date", dateOfBirthField.getType().toString());


    }
}
