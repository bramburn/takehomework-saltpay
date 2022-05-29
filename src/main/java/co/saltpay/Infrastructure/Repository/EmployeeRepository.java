package co.saltpay.Infrastructure.Repository;

import co.saltpay.Application.Common.Interface.IEmployeeRepository;
import co.saltpay.Domain.Entity.Employees.Employee;
import co.saltpay.Infrastructure.Common.Interface.IDriverData;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {

    private IDriverData jsonDriver;


    EmployeeRepository(IDriverData jsonDriver) {
        this.jsonDriver = jsonDriver;
    }

    @Override
    public Employee[] GetTodayBirthdays(Date today) {
        List<Employee> ListToReturn = null;
        try {
            Employee[] employees = this.jsonDriver.readFile();
            boolean calcExtraDay = calcExtraDay(today);
            Date tomorrow = today;
            if (calcExtraDay) {
                Calendar c = Calendar.getInstance();
                c.setTime(today);
                c.add(Calendar.DAY_OF_MONTH, 1);
                tomorrow = c.getTime();
            }

            for (int i = 0; i < employees.length; i++) {
                if (calcExtraDay) {
                    if ((employees[i].dateOfBirth == today) || (employees[i].dateOfBirth == tomorrow)) {
                        ListToReturn.add(employees[i]);
                    }
                } else {
                    if (employees[i].dateOfBirth == today) {
                        ListToReturn.add(employees[i]);
                    }
                }

            }
            return ListToReturn.toArray(Employee[]::new);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    private boolean calcExtraDay(Date date) {
        // had to knick this online
        ZoneId timeZone = ZoneId.systemDefault();
        LocalDate getLocalDate = date.toInstant().atZone(timeZone).toLocalDate();
        int year = getLocalDate.getYear();


        Calendar c = Calendar.getInstance();

        c.set(getLocalDate.getYear(), getLocalDate.getMonthValue() - 1, getLocalDate.getDayOfMonth());

        // if not leap then check and include the 29th
        boolean isLeap = (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
        return (!isLeap && getLocalDate.getMonthValue() == 2 && getLocalDate.getDayOfMonth() == 28);
    }
}
