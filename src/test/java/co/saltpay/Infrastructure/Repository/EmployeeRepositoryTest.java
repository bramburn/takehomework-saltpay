package co.saltpay.Infrastructure.Repository;

import co.saltpay.Domain.Entity.Employees.Employee;
import co.saltpay.Infrastructure.Common.Interface.IDriverClass;
import co.saltpay.Infrastructure.Repository.Model.EmployeeModel;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;


import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.assertEquals;


public class EmployeeRepositoryTest {

    private URL resourcePath;
    @BeforeAll
    public void setupResource()
    {
        resourcePath =  getClass().getClassLoader().getResource("Json/EmployeeData.json");
    }
    @Test
public void checkMoqDataNonLeap() {
        IDriverClass moqDriver = new MoqDriver();

        EmployeeRepository repo = new EmployeeRepository(moqDriver, resourcePath);

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
        IDriverClass moqDriver = new MoqDriver();
        EmployeeRepository repo = new EmployeeRepository(moqDriver, resourcePath);

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
        IDriverClass moqDriver = new MoqDriver();
        EmployeeRepository repo = new EmployeeRepository(moqDriver, resourcePath);

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
        IDriverClass moqDriver = new MoqDriver();
        EmployeeRepository repo = new EmployeeRepository(moqDriver, resourcePath);

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
class MoqDriver implements IDriverClass {

    @Override
    public Employee[] readFile(URL s) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new EmployeeModel("Kaps","Ramburn","1988/02/29"));
        employees.add(new EmployeeModel("Kaps","Ramburn2","1988/02/28"));
        employees.add(new EmployeeModel("Kaps","Ramburn","1987/11/08"));
        return employees.toArray(new Employee[0]);
    }

}
