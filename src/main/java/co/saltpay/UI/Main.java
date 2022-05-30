package co.saltpay.UI;

import co.saltpay.Application.Common.Interface.IView;
import co.saltpay.Application.Controller.Employees.EmployeeController;
import co.saltpay.Application.Services.Employees.EmployeeService;
import co.saltpay.Infrastructure.Repository.Driver.JsonDriver;
import co.saltpay.Infrastructure.Repository.EmployeeRepository;
import co.saltpay.UI.Concrete.Views.View;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException, java.text.ParseException {
        // todo: some DI would be good
        // Init Infrastructure
        JsonDriver jsonDriver = new JsonDriver();
        EmployeeRepository employeeRepository = new EmployeeRepository(jsonDriver);

        // Init Controller/Application
        EmployeeService service = new EmployeeService(employeeRepository); // where infra connects to application
        View view = new View();
        EmployeeController employeeController = new EmployeeController(service, view);

        // Router could be wrapped around this but there is only 1 single point of entry
        employeeController.GetAllBirthdaysForToday();
    }
}
