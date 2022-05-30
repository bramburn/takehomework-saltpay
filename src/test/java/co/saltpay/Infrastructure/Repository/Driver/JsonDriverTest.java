package co.saltpay.Infrastructure.Repository.Driver;

import co.saltpay.Domain.Entity.Employees.Employee;
import org.junit.Test;


public class JsonDriverTest {

    @Test
    public void readFileTestDoesNotThrow() {
        JsonDriver jd = new JsonDriver();
        //should not throw any errors, its not ideal but quick way to catch all file not found
        // this is because no configuration or the like, we assume this is static for life

        Employee[] employees = jd.readFile();
        assert (employees.length > 0);
    }

}
