package get_requests;

import base_urls.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

public class get05 extends HerokuAppBaseUrl {

  /*  Given
    https://restful-booker.herokuapp.com/booking
    When
    User send a request to the URL
            Then
    Status code is 200
    And
    Among the data there should be someone whose firstname is "John" and last name is "Smith"*/

    @Test
    public void get(){
        //1. Set Base Url

        spec.pathParam("first", "booking").
                queryParams("firstname", "John",
                        "lastname", "Smith");

        //2. Set expected data

        //3. Request
        Response response = given(spec).when().get("{first}");
        response.prettyPrint();

        //4. Do assertion
        response
                .then()
                .statusCode(200)
                .body(containsString("bookingid"))                   //1.yol
                .body("bookingid",hasSize(greaterThan(0)));          //2.yol
        assertTrue(response.asString().contains("bookingid"));               //3.yol
    }
}
