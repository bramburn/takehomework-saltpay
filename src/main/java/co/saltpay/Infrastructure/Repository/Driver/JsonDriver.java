package co.saltpay.Infrastructure.Repository.Driver;

import co.saltpay.Domain.Entity.Employees.Employee;
import co.saltpay.Infrastructure.Repository.Model.EmployeeModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class JsonDriver {
    public Employee[] readFile() throws IOException, ParseException, java.text.ParseException {
        JSONParser parser = new JSONParser();
        URL resource = getClass().getClassLoader().getResource("Json/EmployeeData.json");
        JSONArray obj = (JSONArray) parser.parse(new FileReader(resource.getPath()));

        Employee[] employees = new Employee[obj.size() - 1];
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY/MM/dd");

        for (int i = 0; i < obj.size(); i++) {
            List o = (List) obj.get(i);
            // assume that the format will be Lastname:string, Firstname:string, dob:date
            Date dob = formatter.parse(o.get(2).toString());
            employees[i] = new EmployeeModel(o.get(1).toString(), o.get(0).toString(), dob);
        }

        return employees;

    }
}
