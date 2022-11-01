import io.restassured.response.Response;
import org.junit.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetRequest02 {

    @Test
    public void test02() {
        String url = "https://reqres.in/api/users";
        Response response = given().when().get(url);
      //  response.prettyPrint();

        // Header test
        response.then().assertThat().statusCode(200).
                statusLine("HTTP/1.1 200 OK").
        contentType("application/json; charset=utf-8")
        .header("Server","cloudflare")
        .body("data[0].email",equalTo("george.bluth@reqres.in"),
                "data[0].first_name",equalTo("George"),
                "data[0].last_name",equalTo("Bluth"));


    }


}
