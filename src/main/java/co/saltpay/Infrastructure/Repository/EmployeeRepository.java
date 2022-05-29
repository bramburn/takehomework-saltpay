package co.saltpay.Infrastructure.Repository;

import co.saltpay.Application.Common.Interface.IEmployeeRepository;
import co.saltpay.Domain.Entity.Employees.Employee;

public class EmployeeRepository implements IEmployeeRepository {


    @Override
    public Employee[] GetTodayBirthdays() {
        return new Employee[0];
    }
}
