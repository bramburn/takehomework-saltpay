package co.saltpay.unitTest.Application.Interface.Views;

import co.saltpay.Application.Common.Interface.IView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ViewsTest {

    @Test
    void TestInputAndReturnOfView() {
        FakeObj fake = new FakeObj("Fake Name");

        // init the fake view that can either print or do whatever
        MoqView view = new MoqView();
        view.returnView(fake);

        assertEquals("Fake Name",fake.getName());

        // testing if Types work and the data parsed and set by the main class is good.
        // we can create ui specific ones for the specified UI
        assertEquals("Fake Name",view.toString());

    }
}

// created a fake objectk
class FakeObj extends Object {
    private String name = null;

    FakeObj(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


class MoqView implements IView{

    protected FakeObj s;
    @Override
    public void returnView(Object s) {
    this.s = (FakeObj) s;
    }

    @Override
    public String toString() {
        return s.getName();
    }
}
