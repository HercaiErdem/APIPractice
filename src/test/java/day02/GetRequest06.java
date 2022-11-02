package day02;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utilities.Authentication;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest06 extends Authentication {

    @Test
    public void test06() {
        String url = "https://www.gmibank.com/api/tp-customers/114351";
        Response response = given().headers("Authorization", "Bearer " + generateToken()).when()
                .get(url);
     //   response.prettyPrint();

        // Matcher Class ile musteri bilgilerini dogrulayin
        // Matcher da esit degil mi? ilk basta actual sonra expected yazilir
        // en cok kullanilan ve tercih edilen Pojo class lardir
        response.then().assertThat().body("firstName", equalTo("Della"),
                "lastName", equalTo("Heaney"),
                "email", equalTo("ricardo.larkin@yahoo.com"),
                "mobilePhoneNumber", equalTo("123-456-7893"),
                "accounts[0].balance", equalTo(11190),
                "accounts[0].accountType", equalTo("CHECKING"),
                "accounts[1].balance", equalTo(69700),
                "accounts[1].accountType", equalTo("CREDIT_CARD"));

        // JsonPath ile musteri bilgilerini dogrulayin
        JsonPath json = response.jsonPath();
        // ilk basta istersek mesaj sonra expected sonra da actual data lari gireriz
        Assert.assertEquals("firstname dogru degil", "Della", json.getString("firstName"));
        Assert.assertEquals("lastName dogru degil", "Heaney", json.getString("lastName"));
        Assert.assertEquals("email dogru degil", "ricardo.larkin@yahoo.com", json.getString("email"));
        Assert.assertEquals("mobilePhoneNumber dogru degil", "123-456-7893", json.getString("mobilePhoneNumber"));
        Assert.assertEquals("balance dogru degil", 11190, json.getInt("accounts[0].balance"));
        Assert.assertEquals("accountType dogru degil", "CHECKING", json.getString("accounts[0].accountType"));
        Assert.assertEquals("balance dogru degil", 69700, json.getInt("accounts[1].balance"));
        Assert.assertEquals("accountType dogru degil", "CREDIT_CARD", json.getString("accounts[1].accountType"));


    }
}
