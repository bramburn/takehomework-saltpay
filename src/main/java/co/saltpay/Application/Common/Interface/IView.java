package co.saltpay.Application.Common.Interface;

import java.util.Collection;

public interface IView {

    <T extends Object> void returnView(T s);

}
