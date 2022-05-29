package co.saltpay.Application.Controller.Employees;

import co.saltpay.Application.Common.Interface.IEmployeeRepository;
import co.saltpay.Application.Services.Employees.EmployeeService;

public class EmployeeController {


    private EmployeeService employeeService;
    private IEmployeeRepository employeeRepository;


    EmployeeController(IEmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
        this.employeeService = new EmployeeService(this.employeeRepository);
    }

    public void GetAllBirthdaysForToday(){

    }
}
