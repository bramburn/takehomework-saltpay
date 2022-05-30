package co.saltpay.Infrastructure.Repository.Driver;

import co.saltpay.Domain.Entity.Employees.Employee;
import org.junit.Test;

import java.net.URL;


public class JsonDriverTest {

    @Test
    public void readFileTestDoesNotThrow() {
        URL path =  getClass().getClassLoader().getResource("Json/EmployeeData.json");
        JsonDriver jd = new JsonDriver();
        //should not throw any errors, its not ideal but quick way to catch all file not found
        // this is because no configuration or the like, we assume this is static for life

        Employee[] employees;
        try {

            employees = jd.readFile(path);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assert (employees.length > 0);
    }

}
