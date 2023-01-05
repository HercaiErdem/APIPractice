package utilities;

import io.restassured.http.*;
import io.restassured.path.json.*;
import io.restassured.response.*;
import java.util.*;
import static io.restassured.RestAssured.*;

public class Authentication {
    /*
    public static void main(String[] args) {
        String guncelToken = generateToken();
        System.out.println(guncelToken);
    }
*/
    public static String generateToken(){

        String username = "Batch81";
        String password = "Batch81+";
        /*
        {
            "password": "string",
            "rememberMe": true,
            "username": "string"
        }
         */
        Map<String, Object> postBody = new HashMap<>();
        postBody.put("username", username);
        postBody.put("password", password);
        postBody.put("rememberMe", true);

        // "password": "Batch81+",
        //    "rememberMe": true,
        //    "username": "Batch81"


        String endPoint = "https://www.gmibank.com/api/authenticate";

        Response response = given().contentType(ContentType.JSON).body(postBody).when().post(endPoint);

        JsonPath token = response.jsonPath();
        return token.getString("id_token");
    }

}
