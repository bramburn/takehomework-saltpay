package co.saltpay.Infrastructure.Repository.Driver;

import co.saltpay.Domain.Entity.Employees.Employee;
import co.saltpay.Infrastructure.Common.Interface.IDriverClass;
import co.saltpay.Infrastructure.Repository.Model.EmployeeModel;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

//todo make this is a singleton
public class JsonDriver implements IDriverClass {


    public Employee[] readFile(URL resourcePath)  {
        JSONParser parser = new JSONParser();


        JSONArray obj;
        try {
            obj = (JSONArray) parser.parse(new FileReader(resourcePath.getPath()));
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

        Employee[] employees = new Employee[obj.size()];
        SimpleDateFormat formatter = new SimpleDateFormat("y/MM/dd");

        for (int i = 0; i < obj.size(); i++) {
            JSONArray o = (JSONArray) obj.get(i);
            // assume that the format will be Lastname:string, Firstname:string, dob:date
            Date dob;
            try {
                dob = formatter.parse(o.get(2).toString());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            employees[i] = new EmployeeModel(o.get(1).toString(), o.get(0).toString(), dob);
        }

        return employees;


    }
}
