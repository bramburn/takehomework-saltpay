package co.saltpay.Application.Common;

import co.saltpay.Application.Common.Interface.IEmployeeRepository;
import co.saltpay.Domain.Entity.Employees.Employee;
import co.saltpay.Infrastructure.Repository.Model.EmployeeModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MoqEmployeeRepository implements IEmployeeRepository {

    @Override
    public Employee[] GetTodayBirthdays(Date date) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new EmployeeModel("Kaps", "Ramburn", "1988/02/29"));
        employees.add(new EmployeeModel("Kaps", "Ramburn2", "1988/02/28"));
        employees.add(new EmployeeModel("Kaps", "Ramburn", "1987/11/08"));
        return employees.toArray(new Employee[0]);
    }
}
