package co.saltpay.Infrastructure.Repository;

import co.saltpay.Application.Common.Interface.IEmployeeRepository;
import co.saltpay.Domain.Entity.Employees.Employee;
import co.saltpay.Infrastructure.Common.Interface.IDriverData;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {

    private IDriverData jsonDriver;


    public EmployeeRepository(IDriverData jsonDriver) {
        this.jsonDriver = jsonDriver;
    }

    @Override
    public Employee[] GetTodayBirthdays(Date today) {

        List<Employee> ListToReturn = new LinkedList<Employee>();
        Employee[] employees = this.jsonDriver.readFile();
        boolean calcExtraDay = calcExtraDay(today);
        Calendar todaysCalendarDay = new Calendar.Builder().setInstant(today).build();


        for (int i = 0; i < employees.length; i++) {

            Calendar EmployeeCalendar = new Calendar.Builder().setInstant(employees[i].dateOfBirth).build();

            if (calcExtraDay) {
                if (((EmployeeCalendar.get(Calendar.DAY_OF_MONTH) == todaysCalendarDay.get(Calendar.DAY_OF_MONTH)) || (EmployeeCalendar.get(Calendar.DAY_OF_MONTH) == 29) && EmployeeCalendar.get(Calendar.MONTH) == todaysCalendarDay.get(Calendar.MONTH)))
                {
                    ListToReturn.add(employees[i]);
                }
            } else {
                if ((EmployeeCalendar.get(Calendar.DAY_OF_MONTH) == todaysCalendarDay.get(Calendar.DAY_OF_MONTH) && EmployeeCalendar.get(Calendar.MONTH) == todaysCalendarDay.get(Calendar.MONTH))) {
                    ListToReturn.add(employees[i]);
                }
            }

        }
        return ListToReturn.toArray(new Employee[0]);


    }

    public boolean calcExtraDay(@NotNull Date date) {


        // todo check if instance of singleton is cleared or needs resetting every use?
        Calendar c = new Calendar.Builder().setInstant(Date.from(date.toInstant())).build();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);


        // if not leap then check and include the 29th
        boolean isLeap;
        if ((((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))) isLeap = true;
        else isLeap = false;
        if (!isLeap) if (month == 1) if (day == 28) return true;
        return false;
    }
}
