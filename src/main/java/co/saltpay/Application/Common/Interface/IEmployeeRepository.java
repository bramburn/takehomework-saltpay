package co.saltpay.Application.Common.Interface;

import co.saltpay.Domain.Entity.Employees.Employee;

import java.util.Date;

public interface IEmployeeRepository {

    Employee[] GetTodayBirthdays(Date date);
}
