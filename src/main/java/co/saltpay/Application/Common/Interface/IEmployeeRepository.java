package co.saltpay.Application.Common.Interface;

import co.saltpay.Domain.Entity.Employees.Employee;

public interface IEmployeeRepository {

    Employee[] GetTodayBirthdays();
}
