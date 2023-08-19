package delete_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utils.ObjectMapperUtils.convertJsonToJava;

public class Delete01 extends JsonPlaceHolderBaseUrl {

     /*
        Given
            https://jsonplaceholder.typicode.com/todos/198
        When
            I send DELETE Request to the Url
        Then
            Status code is 200 */

    @Test
    public void delete01() {

        //Set the url

        spec.pathParams("first","todos","second",198);

        //Set the expected data

        Map<String,String> expectedData = new HashMap<>();

        //Send the request and get the res

        Response response = RestAssured.given(spec).when().delete("{first}/{second}");
        response.prettyPrint();

        //Do assertion

        Map<String, String> actualData = convertJsonToJava(response.asString(),HashMap.class);
        assertEquals(200,response.statusCode());

        //1.yol
        assertEquals(expectedData,actualData);

        //2.yol
        assertEquals(0,actualData.size());

        //3.yol
        assertTrue(actualData.isEmpty());



    }
}
