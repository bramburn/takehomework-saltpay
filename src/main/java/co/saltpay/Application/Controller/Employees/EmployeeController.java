package co.saltpay.Application.Controller.Employees;

import co.saltpay.Application.Common.Interface.IEmployeeRepository;
import co.saltpay.Application.Common.Interface.IView;
import co.saltpay.Application.Services.Employees.EmployeeService;
import co.saltpay.Domain.Entity.Employees.Employee;

import java.util.Date;

public class EmployeeController {


    private EmployeeService employeeService;
    private IEmployeeRepository employeeRepository;
    private IView view;


    EmployeeController(EmployeeService employeeService, IView view){
        this.employeeService = employeeService;

        this.view = view;

    }

    public void GetAllBirthdaysForToday(){
        Employee[] data = employeeService.GetTodayBirthdays(new Date());
        view.returnView(data);
    }
}
