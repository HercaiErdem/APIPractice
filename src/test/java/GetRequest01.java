import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01 {

    @Test
    public void test01() {

        String url = "https://restful-booker.herokuapp.com/booking";

        Response response = given().when().get(url);
        //given().when.get(url) end point e gondermek icin request olusturduk
        //Response response -> api tarafindan donen response (cevap)

        // response.prettyPrint(); // response daki body i yazdirir

        //   response.prettyPeek(); // response daki her seyi yazdirir (headers vs)

        // response.peek();

        //response.print();     //string olarak dataye verir

        // [{"bookingid":1215},{"bookingid":844},{"bookingid":87},{"bookingid":747}, ...]

        System.out.println(response.statusCode());
        System.out.println(response.statusLine());
        System.out.println(response.contentType());

        // 1) JUnit Assertleri ile API Assertion yapariz
        Assert.assertEquals("Status Code hatali",200,response.getStatusCode());
        Assert.assertEquals("HTTP/1.1 200 OK", response.statusLine());
        Assert.assertEquals("application/json; charset=utf-8", response.getContentType());

        // 2. assertthat ile
        response.then().assertThat().statusCode(200)
                .statusLine("HTTP/1.1 200 OK").contentType("application/json; charset=utf-8");


        //assertthat soft assert mu? hard assert mu? ==> hard assert dur
    }
}
