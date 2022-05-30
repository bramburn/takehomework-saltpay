package co.saltpay.Infrastructure.Repository;

import co.saltpay.Domain.Entity.Employees.Employee;
import co.saltpay.Infrastructure.Common.Interface.IDriverData;
import co.saltpay.Infrastructure.Repository.Model.EmployeeModel;
import org.junit.Test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.assertEquals;


public class EmployeeRepositoryTest {

    @Test
public void checkMoqDataNonLeap() {
        IDriverData moqDriver = new MoqDriver();
        EmployeeRepository repo = new EmployeeRepository(moqDriver);

        SimpleDateFormat format = new SimpleDateFormat("y/MM/dd");

        try {
            Date leapYear = format.parse("2022/02/28");
            Employee[] i  =  repo.GetTodayBirthdays(leapYear);
            assertEquals(Arrays.stream(i).count(),2);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
public void checkMoqDataLeap() {
        IDriverData moqDriver = new MoqDriver();
        EmployeeRepository repo = new EmployeeRepository(moqDriver);

        SimpleDateFormat format = new SimpleDateFormat("y/MM/dd");

        try {
            Date leapYear = format.parse("2024/02/28");
            Employee[] i  =  repo.GetTodayBirthdays(leapYear);
            assertEquals(Arrays.stream(i).count(),1);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
public void checkMoqDataLeap29th() {
        IDriverData moqDriver = new MoqDriver();
        EmployeeRepository repo = new EmployeeRepository(moqDriver);

        SimpleDateFormat format = new SimpleDateFormat("y/MM/dd");

        try {
            Date leapYear = format.parse("2024/02/29");
            Employee[] i  =  repo.GetTodayBirthdays(leapYear);
            assertEquals(Arrays.stream(i).count(),1);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
public void CheckNormalDate() {
        IDriverData moqDriver = new MoqDriver();
        EmployeeRepository repo = new EmployeeRepository(moqDriver);

        SimpleDateFormat format = new SimpleDateFormat("y/MM/dd");

        try {
            Date leapYear = format.parse("2022/11/08");
            Employee[] i  =  repo.GetTodayBirthdays(leapYear);
            assertEquals(Arrays.stream(i).count(),1);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    // todo check for future dates


}
class MoqDriver implements IDriverData{

    @Override
    public Employee[] readFile() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new EmployeeModel("Kaps","Ramburn","1988/02/29"));
        employees.add(new EmployeeModel("Kaps","Ramburn2","1988/02/28"));
        employees.add(new EmployeeModel("Kaps","Ramburn","1987/11/08"));
        return employees.toArray(new Employee[0]);
    }

}
