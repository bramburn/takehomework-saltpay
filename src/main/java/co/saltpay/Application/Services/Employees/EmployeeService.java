package co.saltpay.Application.Services.Employees;

import co.saltpay.Application.Common.Interface.IEmployeeRepository;
import co.saltpay.Domain.Entity.Employees.Employee;

import java.util.Date;

public class EmployeeService {
    private IEmployeeRepository employeeRepository;

    public EmployeeService(IEmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    public Employee[] GetTodayBirthdays(Date date) {
        return this.employeeRepository.GetTodayBirthdays(date);
    }
}
