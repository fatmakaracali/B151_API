package get_requests;

import base_urls.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get06 extends HerokuAppBaseUrl {

    /*
    Given
        https://restful-booker.herokuapp.com/booking/22
    When
        User send a GET request to the URL
    Then
        HTTP Status Code should be 200
    And
        Response content type is “application/json”
    And
        Response body should be like;
      {
        "firstname": "John",
        "lastname": "Smith",
        "totalprice": 111,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2018-01-01",
            "checkout": "2019-01-01"
        },
        "additionalneeds": "Breakfast"
    }
     */

    @Test
    public void get() {
        spec.pathParams("first","booking","second",22);
        Response response=given().spec(spec).get("{first}/{second}");
        response.prettyPrint();

        //1.yol
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", equalTo("John"),
                        "lastname", equalTo("Smith"),
                        "totalprice", equalTo(111),
                        "depositpaid", equalTo(true),
                        "bookingdates.checkin", equalTo("2018-01-01"),
                        "bookingdates.checkout", equalTo("2019-01-01"),
                        "additionalneeds", equalTo("Breakfast")
                );

        //2. Yol: Response data icerisindeki degerlere ulasmak icin Jsonpath kullanilir
        JsonPath json=response.jsonPath();
        System.out.println(json.getString("firstname"));
        System.out.println(json.getInt("totalprice"));
        System.out.println(json.getBoolean("depositpaid"));
        assertEquals("John",json.getString("firstname"));
        assertEquals("Smith",json.getString("lastname"));
        assertEquals(111,json.getInt("totalprice"));
        assertTrue(json.getBoolean("depositpaid"));
        assertEquals("2018-01-01",json.getString("bookingdates.checkin"));
        assertEquals("2019-01-01",json.getString("bookingdates.checkout"));
        assertEquals("Breakfast",json.getString("additionalneeds"));

        //SoftAssertion 3 adimda yapilir.--> testng poma eklenmeli
        //1.adim softassertion objesi olusturulur
        SoftAssert softAssert = new SoftAssert();

        //2.adim assertion yapilir
        softAssert.assertEquals(json.getString("firstname"),"John","firstname uyusmadi");
        softAssert.assertEquals(json.getString("lastname"),"Smith","lastname uyusmadi");
        softAssert.assertEquals(json.getInt("totalprice"),111,"toplam ucret uyusmadi");
        softAssert.assertEquals(json.getBoolean("depositpaid"),true);
        softAssert.assertEquals(json.getString("bookingdates.checkin"),"2018-01-01");
        softAssert.assertEquals(json.getString("bookingdates.checkout"),"2019-01-01");

        //3. adim softAssert.assertAll anahtar kelimesiyle bitirilir

         softAssert.assertAll();


    }
}
