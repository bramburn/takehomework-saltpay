package co.saltpay.Application.Controller.Employees;

import co.saltpay.Application.Common.Interface.IEmployeeRepository;
import co.saltpay.Application.Common.Interface.IView;
import co.saltpay.Application.Services.Employees.EmployeeService;
import co.saltpay.Application.Common.MoqEmployeeRepository;
import co.saltpay.Domain.Entity.Employees.Employee;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeControllerTest {

    @Test
    void getAllBirthdaysForToday() {

        assertAll(() -> {
            IEmployeeRepository repo = new MoqEmployeeRepository();
            EmployeeService service = new EmployeeService(repo);
            IView MoqViewForController = new MoqViewForController();
            EmployeeController employeeController = new EmployeeController(service, MoqViewForController);
            employeeController.GetAllBirthdaysForToday();
        });
    }

    @Test
    void checkCount() {
        IEmployeeRepository repo = new MoqEmployeeRepository();
        EmployeeService service = new EmployeeService(repo);
        MoqViewForController MoqViewForController = new MoqViewForController();
        EmployeeController employeeController = new EmployeeController(service, MoqViewForController);
        employeeController.GetAllBirthdaysForToday();

        assertEquals(3, MoqViewForController.getTotalCount());
    }
}

class MoqViewForController implements IView {
    private int TotalCount;

    @Override
    public void returnView(Object s) {
        Employee[] e = (Employee[]) s;
        this.TotalCount = (int) Arrays.stream(e).count();
    }


    public int getTotalCount() {
        return TotalCount;
    }
}
