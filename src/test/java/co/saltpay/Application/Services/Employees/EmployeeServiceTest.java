package co.saltpay.Application.Services.Employees;

import co.saltpay.Application.Common.Interface.IEmployeeRepository;
import co.saltpay.Domain.Entity.Employees.Employee;
import co.saltpay.Infrastructure.Repository.Model.EmployeeModel;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeServiceTest {

    @Test
    void CheckAnyDate() {

        IEmployeeRepository repo = new MoqRepository();
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
    void ShouldShowEmpty() {

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

class MoqRepository implements IEmployeeRepository {

    @Override
    public Employee[] GetTodayBirthdays(Date date) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new EmployeeModel("Kaps", "Ramburn", "1988/02/29"));
        employees.add(new EmployeeModel("Kaps", "Ramburn2", "1988/02/28"));
        employees.add(new EmployeeModel("Kaps", "Ramburn", "1987/11/08"));
        return employees.toArray(new Employee[0]);
    }
}

class EmptyMoqRepository implements IEmployeeRepository{

    @Override
    public Employee[] GetTodayBirthdays(Date date) {
        return new Employee[0];
    }
}
