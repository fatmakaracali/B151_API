package SmokeTestHerOkuApp;

import base_urls.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static SmokeTestHerOkuApp.C01_CreateBooking.bookingid;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C05_DeleteBooking extends HerokuAppBaseUrl {

    @Test
    public void delete(){

           /*
    Given
        https://restful-booker.herokuapp.com/booking/1
    When
        sent delete request
    Then
        StatusCode 201
    And
        body : Created
     */

        //setUrl

        spec.pathParams("first", "booking",
                "second", bookingid);

        // Set expected data
        String expectedData = "Created";

        // Send req and get resp
        Response response = given(spec).when().delete("{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        assertEquals(201,response.statusCode());
        assertEquals(expectedData,response.asString());


    }
}
