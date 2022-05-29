package co.saltpay.Application.Services.Employees;

import co.saltpay.Application.Common.Interface.IEmployeeRepository;
import co.saltpay.Domain.Entity.Employees.Employee;

public class EmployeeService {
    private IEmployeeRepository employeeRepository;

    public EmployeeService(IEmployeeRepository employeeRepository){

        this.employeeRepository = employeeRepository;
    }

    public Employee[] GetAllEmployees(){
       return this.employeeRepository.GetAllEmployees();
    }

    public Employee[] GetTodayBirthdays(){
        return this.employeeRepository.GetTodayBirthdays();
    }
}
