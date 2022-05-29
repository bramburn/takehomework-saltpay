package co.saltpay.UI.Concrete.Views;

import co.saltpay.Application.Common.Interface.IView;

public class View implements IView {
    @Override
    public String returnView(Object s) {

        // not going to separate the test print out here as its beyond the scope
        // plus its going to be over complicating it
        // todo: print a loop of employees
        System.out.println("Today's list of Birthdays are:");
        System.out.printf("Name: %s%n");

        return "";
    }
}
