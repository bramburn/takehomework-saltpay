package co.saltpay.unitTest.Application.Services.Employee;

import co.saltpay.Application.Common.Interface.IEmployeeRepository;
import co.saltpay.Application.Services.Employees.EmployeeService;
import co.saltpay.Domain.Entity.Employees.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class EmployeeServiceTest {

}

class MoqRepository implements IEmployeeRepository {

    @Override
    public Employee[] GetAllEmployees() {
        return new Employee[0];
    }

    @Override
    public Employee[] GetTodayBirthdays() {
        return new Employee[0];
    }
}
