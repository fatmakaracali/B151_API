package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class AuthenticationGmiBank {

    public static void main(String[] args) {
        System.out.println("generateToken() = " + generateToken());
    }
    public static String generateToken(){
        String body ="{\n" +
                "  \"password\": \"Mark.123\",\n" +
                "  \"rememberMe\": true,\n" +
                "  \"username\": \"mark_twain\"\n" +
                "}";
        Response response= given().body(body).contentType(ContentType.JSON).when().post("https://gmibank.com/api/authenticate");
        response.prettyPrint();
        return response.jsonPath().getString("id_token");
    }
}



