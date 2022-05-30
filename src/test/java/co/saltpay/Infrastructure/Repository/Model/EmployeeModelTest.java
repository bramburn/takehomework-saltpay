package co.saltpay.Infrastructure.Repository.Model;

import co.saltpay.Domain.Entity.Employees.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeModelTest {

    @Test
    void CheckBuildModelisOkFromString(){
        String Name = "kaps";
        Employee model = new EmployeeModel(Name,"lastName here","1980/05/30");

        assertEquals(model.firstName, Name);

    }

    @Test
    void CheckBuildModelisOk(){
        String Name = "kaps";
        Employee model = new EmployeeModel(Name,"lastName here","1980/05/30");

        assertEquals(model.firstName, Name);

    }


    @Test
    void ShouldThrowErrorWithWrongStringIn(){
        String Name = "kaps";
        assertThrows(Exception.class,()->new EmployeeModel(Name,"lastName here","%1231£9802/05/30"));

    }

}
