package put_requests;

import base_urls.DummyResApiBaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyDataPojo;
import pojos.DummyResponsePojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put02 extends DummyResApiBaseURL {

    /*
    Given
    https://dummy.restapiexample.com/api/v1/update/21
And
    Request body: {
                    "employee_name": "Ali Can",
                    "employee_salary": 111111,
                    "employee_age": 23,
                    "profile_image": "Perfect image"
                }
When
    User sends PUT request
Then
    Status code should be 200
And
    Response body should be like the following:
                {
                    "status": "success"
                    "data": {
                        "employee_name": "Ali Can"
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image"
                    },
                    "message": "Successfully! Record has been updated."
                }
     */

    @Test
    public void put() {

        spec.pathParams("first", "update", "second", 21);

        //Set expected data

       
        DummyDataPojo payLoad = new DummyDataPojo("Ali Can", 111111, 23, "Perfect image");
        System.out.println("payLoad =" + payLoad);

        //Send Req and get Response

        Response response = given(spec).body(payLoad).when().put("{first}/{second}");
        response.prettyPrint();

        //Do aseertion

        DummyResponsePojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), DummyResponsePojo.class);
        assertEquals(200,response.statusCode());
        assertEquals(payLoad.getEmployee_age(),actualData.getData().getEmployee_age());
        assertEquals(payLoad.getEmployee_salary(),actualData.getData().getEmployee_salary());
        assertEquals(payLoad.getEmployee_name(),actualData.getData().getEmployee_name());
        assertEquals("success",actualData.getStatus());
        assertEquals("Successfully! Record has been updated.",actualData.getMessage());

    }

      /*
      Console’da, Unreqognized field status uyarisi aldiysak atladigimiz fazladan veri vardir.
      @JsonIgnoreProperties(ignoreUnknown = true)  Bazi verileri zaten atlamak istediysek bu ignore syntax’i
      kullanirsak hata almayiz.
       */
}
