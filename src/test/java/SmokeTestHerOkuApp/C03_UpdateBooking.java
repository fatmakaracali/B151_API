package SmokeTestHerOkuApp;

import base_urls.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import static SmokeTestHerOkuApp.C01_CreateBooking.bookingid;
import static io.restassured.RestAssured.given;

public class C03_UpdateBooking extends HerokuAppBaseUrl {


    /*
    Given
    https://restful-booker.herokuapp.com/booking/:id
And
            {
        "firstname" : "James",
        "lastname" : "Brown",
        "totalprice" : 111,
        "depositpaid" : true,
        "bookingdates" : {
            "checkin" : "2018-01-01",
            "checkout" : "2019-01-01"
        },
        "additionalneeds" : "Breakfast"
        }
When
    Sent put request
Then
    Statuscode 200
And
    body:
            {
        "firstname" : "James",
        "lastname" : "Brown",
        "totalprice" : 111,
        "depositpaid" : true,
        "bookingdates" : {
            "checkin" : "2018-01-01",
            "checkout" : "2019-01-01"
        },
        "additionalneeds" : "Breakfast"
    }
     */

    @Test
    public void put(){

        //SetUrl
        spec.pathParams("first","booking","second",bookingid);

        // Set expected data
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2018-01-01", "2019-01-01");
        BookingPojo expectedData = new BookingPojo("James"
                , "Brown", 111
                , true, bookingDatesPojo
                , "Breakfast");
        Response response = given(spec).body(expectedData).when().put("{first}/{second}");
        response.prettyPrint();


    }

}
