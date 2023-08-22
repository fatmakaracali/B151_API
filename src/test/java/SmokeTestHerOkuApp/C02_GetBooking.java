package SmokeTestHerOkuApp;

import base_urls.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.BookingResponsePojo;

import static SmokeTestHerOkuApp.C01_CreateBooking.bookingid;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utils.ObjectMapperUtils.convertJsonToJava;

public class C02_GetBooking extends HerokuAppBaseUrl {


    /*
    Given
        https://restful-booker.herokuapp.com/booking/:id
When
        Send Get request
Then
        Statuscode 200
And
        Body:
                    {
            "firstname": "Sally",
            "lastname": "Brown",
            "totalprice": 111,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2013-02-23",
                "checkout": "2014-10-23"
            },
            "additionalneeds": "Breakfast"
        }
     */

    @Test
    public void get() {
        spec.pathParams("first","booking","second",bookingid);
        // Set expected data
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2018-01-01", "2018-01-01");
        BookingPojo expectedData = new BookingPojo("Jim"
                , "Brown", 111
                , true, bookingDatesPojo
                , "Breakfast");
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();
        // Do aseertion
        BookingPojo actualData = convertJsonToJava(response.asString(), BookingPojo.class);
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getFirstname(),actualData.getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getLastname());
        assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(),actualData.getDepositpaid());
        assertEquals(expectedData.getAdditionalneeds(),actualData.getAdditionalneeds());
        assertEquals(expectedData.getBookingdates().getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(expectedData.getBookingdates().getCheckout(),actualData.getBookingdates().getCheckout());

    }
}
