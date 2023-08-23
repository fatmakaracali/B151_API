package SmokeTestHerOkuApp;

import base_urls.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static SmokeTestHerOkuApp.C01_CreateBooking.bookingid;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C06_GetDeleteBooking extends HerokuAppBaseUrl {

    /*
   Given
           https://restful-booker.herokuapp.com/booking/:id
   When
           Send Get request
   Then
           Statuscode 404
   And
           Body: Not Found
    */
    @Test
    public void get() {
        spec.pathParams("first","booking","second",bookingid);
        // Set expected data
        String expectedDAta = "Not Found";
        // Sent req and get resp
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();
        // Do aseertion
        assertEquals(404,response.statusCode());
        assertEquals(expectedDAta,response.asString());
    }
}
