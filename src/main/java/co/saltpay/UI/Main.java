package co.saltpay.UI;

import co.saltpay.Application.Controller.Employees.EmployeeController;
import co.saltpay.Application.Services.Employees.EmployeeService;
import co.saltpay.Infrastructure.Repository.Driver.JsonDriver;
import co.saltpay.Infrastructure.Repository.EmployeeRepository;
import co.saltpay.UI.Concrete.Views.View;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        if (args.length == 0) {
            throw new RuntimeException("Please provide an absolute path to a formatted json file");
        }
        URL path;
        try {
            File apath = new File(args[0]);
            path = apath.toURI().toURL();

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }


        // assume that we want to test is in this format YYYY/MM/DD
        Date setDate;
        if (args.length == 2) {
            SimpleDateFormat formatter = new SimpleDateFormat("y/MM/dd");
            try {
                setDate = formatter.parse(args[1]);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } else {
            setDate = new Date();
        }

        // todo: some DI would be good
        // Init Infrastructure
        JsonDriver jsonDriver = new JsonDriver();
        EmployeeRepository employeeRepository = new EmployeeRepository(jsonDriver, path);

        // Init Controller/Application
        EmployeeService service = new EmployeeService(employeeRepository); // where infra connects to application
        View view = new View();
        EmployeeController employeeController = new EmployeeController(service, view);

        // Router could be wrapped around this but there is only 1 single point of entry
        employeeController.GetAllBirthdaysForToday(setDate);
    }
}
