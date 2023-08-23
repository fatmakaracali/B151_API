package SmokeTestHerOkuApp;

import base_urls.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static SmokeTestHerOkuApp.C01_CreateBooking.bookingid;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utils.ObjectMapperUtils.convertJsonToJava;

public class C04_PartiallyUpdateBooking extends HerokuAppBaseUrl {


   /* {
        "firstname" : "Sakin",
            "lastname" : "Brown"
    }

    When
    sent patch request
            Then
    statuscode 200
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

 */

    @Test
    public void patch(){

        // set url
        spec.pathParams("first", "booking", "second", bookingid);

        // set expected data
        Map<String, Object> payLoad = new HerOkuAppTestData().expectedDataMapper("Sakin",
                "Browny", null, null, null, null);
        System.out.println("payLoad = " + payLoad);

        //sent rqs and get resp
        Response response = given(spec).body(payLoad).when().patch("{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        Map<String,Object> actualData = convertJsonToJava(response.asString(), HashMap.class);
        assertEquals(200,response.statusCode());
        assertEquals(payLoad.get("firstname"),actualData.get("firstname"));
        assertEquals(payLoad.get("lastname"),actualData.get("lastname"));







    }




















}
