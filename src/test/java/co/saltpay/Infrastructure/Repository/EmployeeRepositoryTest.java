package co.saltpay.Infrastructure.Repository;

import co.saltpay.Domain.Entity.Employees.Employee;
import co.saltpay.Infrastructure.Common.Interface.IDriverData;
import co.saltpay.Infrastructure.Repository.Model.EmployeeModel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryTest {

    @Test
    void checkMoqDa() {
        // provide moq data

    }


}
class MoqDriver implements IDriverData{

    @Override
    public Employee[] readFile() {
        List<Employee> employees = null;
        employees.add(new EmployeeModel("Kaps","Ramburn","1988/02/29"));
        return null;
    }

    private void makeDate(int year, int month, int day){

    }
}
