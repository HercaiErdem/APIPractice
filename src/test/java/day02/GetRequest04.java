package day02;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetRequest04 {
    /*
    http://dummy.restapiexample.com/api/v1/employees  url’ine
    GET request’i yolladigimda gelen response’un
    status kodunun 200 ve content type’inin “application/json”
    ve employees sayisinin 24
    ve employee’lerden birinin “Ashton Cox”
    ve gelen yaslar icinde 21, 61, ve 23 degerlerinden birinin oldugunu test edin
     */


    @Test
    public void test04() {
        //First Step:Set the Url
        String url = "http://dummy.restapiexample.com/api/v1/employees";

        //Second Step:Set The Expected Data
        //Third Step:Send The Request and Get The Response
        Response response = given().when().get(url);

        //Fourt Step:Do Assertion
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
        response.then().assertThat().body("data.id",hasSize(24),
                "data.employee_name", hasItem("Ashton Cox"),
                "data.employee_age", hasItems(21, 61, 23));



    }
}
