package co.saltpay.UI.Concrete.Views;

import co.saltpay.Application.Common.Interface.IView;
import co.saltpay.Domain.Entity.Employees.Employee;

import java.util.Arrays;

public class View implements IView {

    @Override
    public void returnView(Object s) {

        // not going to separate the test print out here as its beyond the scope
        // plus its going to be over complicating it

        Employee[] local = (Employee[]) s;
        System.out.println("Today's list of Birthdays are:");
        for (Employee item : local) {
            System.out.printf("Name: %s %s%n", item.firstName, item.lastName);
        }


    }
}
