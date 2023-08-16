package get_requests;

import base_urls.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get09 extends HerokuAppBaseUrl {

    /*
    Given
    https://restful-booker.herokuapp.com/booking/91
When
    I send GET Request to the url
Then
    Response body should be like that;
            {
            "firstname": "John",
            "lastname": "Smith",
            "totalprice": 111,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "checkin",
                "checkout": "2019-01-01"
                            },
            "additionalneeds": "Breakfast"
            }
     */

    @Test
    public void get(){

        // set url

        spec.pathParams("first","booking","second",91);

        //Set expected data



       Map<String, String> bookingDatesMap = new HashMap<>();  //ilk önce ic map olusturulur
        bookingDatesMap.put("checkin","2018-01-01");
        bookingDatesMap.put("checkout","2019-01-01");

        Map<String,Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("firstname","Josh");
        expectedDataMap.put("lastname", "Allen");
        expectedDataMap.put("totalprice", 111);
        expectedDataMap.put("depositpaid", true);
        expectedDataMap.put("bookingdates", bookingDatesMap);
        expectedDataMap.put("additionalneeds", "Extra pillows please");
        System.out.println("expectedDataMap = " + expectedDataMap);

        //sent Request and Get Response

        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        //Do Assertion

       Map<String,Object> actualDataMap = response.as(HashMap.class);
        System.out.println("actualDataMap = " + actualDataMap);

        assertEquals(expectedDataMap.get("firstname"),actualDataMap.get("firstname"));
        assertEquals(expectedDataMap.get("lastname"),actualDataMap.get("lastname"));
        assertEquals(expectedDataMap.get("totalprice"),actualDataMap.get("totalprice"));
        assertEquals(expectedDataMap.get("depositpaid"),actualDataMap.get("depositpaid"));
     //   assertEquals( ((Map) expectedDataMap.get("bookingdates")).get("checkin"),  ((Map) actualDataMap.get("additionalneeds")).get("checkin"));
        assertEquals(  (bookingDatesMap.get("checkin")) ,  ((Map)actualDataMap.get("bookingdates")).get("checkin"));
        assertEquals(  (bookingDatesMap.get("checkout")) ,  ((Map)actualDataMap.get("bookingdates")).get("checkout"));



     /**   Object map = new HashMap<>();
        ((Map)map).get("");   */


    }

 /*   @Test
    public void get01(){


        // Set Url
        spec.pathParams("first","booking"
                ,"second", "92");

        // Set expected data

    Map<String,String>bookingMap=    new HerOkuAppTestData().bookingDateMapper("2018-01-01","2019-01-01");

    Map<String,Object> expectedDataMap = new HerOkuAppTestData().expectedDataMapper("John","Smith",111,
                true,bookingMap, "Extra pillows please");

    }*/














}
