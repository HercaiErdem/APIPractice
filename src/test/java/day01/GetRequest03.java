package day01;

import io.restassured.response.*;
import org.junit.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class GetRequest03 {
/* Matchers ile dataları doğrulayınız
       // url = "https://reqres.in/api/users"
       //statusCode,
       // statusLine,
       //contentType,
             "id": 5,
            "email": "charles.morris@reqres.in",
            "first_name": "Charles",
            "last_name": "Morris",
            "avatar": "https://reqres.in/img/faces/5-image.jpg"
     */

    @Test
    public void get03() {
        // set the url
        String url = "https://reqres.in/api/users";

        //Set rthe ex data
        //Request data
        Response response = given().when().get(url);
        // response.prettyPrint();

        // Do Assertion
        response.then().assertThat().statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .contentType("application/json")
                .body("data[4].email", equalTo("charles.morris@reqres.in"),
                        "data[4].first_name", equalTo("Charles"),
                        "data[4].last_name", equalTo("Morris"),
                        "data[4].avatar", equalTo("https://reqres.in/img/faces/5-image.jpg"));


    }

    // "support": {
    //        "url": "https://reqres.in/#support-heading",
    //        "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
    //    }


    @Test
    public void get03b() {
        // set the url
        String url = "https://reqres.in/api/users";

        //Set rthe ex data
        //Request data
        Response response = given().when().get(url);
        // response.prettyPrint();

        // Do Assertion
        assertEquals(200, response.getStatusCode());
        assertEquals("HTTP/1.1 200 OK", response.getStatusLine());
        assertEquals("application/json; charset=utf-8", response.contentType());
        response.then().assertThat().body("support.url"
                , equalTo("https://reqres.in/#support-heading"), "support.text"
                , equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));


    }
}
