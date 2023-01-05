package utilities;

import io.restassured.builder.*;
import io.restassured.specification.*;
import org.junit.*;

public class GMIBankBaseURL extends Authentication{

    protected RequestSpecification spec01;

    @Before
    public void setUp() {

      spec01 = new RequestSpecBuilder().setBaseUri("http://www.gmibank.com/api/").build();

    }


}
