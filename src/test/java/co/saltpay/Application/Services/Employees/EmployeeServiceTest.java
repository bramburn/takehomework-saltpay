package co.saltpay.Application.Services.Employees;

import co.saltpay.Application.Common.Interface.IEmployeeRepository;
import co.saltpay.Application.Common.MoqEmployeeRepository;
import co.saltpay.Domain.Entity.Employees.Employee;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.assertEquals;


public class EmployeeServiceTest {

    @Test
public void CheckAnyDate() {

        IEmployeeRepository repo = new MoqEmployeeRepository();
        EmployeeService service = new EmployeeService(repo);


        SimpleDateFormat format = new SimpleDateFormat("y/MM/dd");
        // assumed all logic for data filtering is left on infrastructure repository.
        // nothing is in service to process data.
        try {
            Date leapYear = format.parse("2024/02/29");
            Employee[] i = service.GetTodayBirthdays(leapYear);
            assertEquals(Arrays.stream(i).count(), 3);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
public void ShouldShowEmpty() {

        IEmployeeRepository repo = new EmptyMoqRepository();
        EmployeeService service = new EmployeeService(repo);


        SimpleDateFormat format = new SimpleDateFormat("y/MM/dd");
        // assumed all logic for data filtering is left on infrastructure repository.
        // nothing is in service to process data.
        try {
            Date leapYear = format.parse("2024/02/29");
            Employee[] i = service.GetTodayBirthdays(leapYear);
            assertEquals(Arrays.stream(i).count(), 0);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    // test count test from repo
}

class EmptyMoqRepository implements IEmployeeRepository{

    @Override
    public Employee[] GetTodayBirthdays(Date date) {
        return new Employee[0];
    }
}
