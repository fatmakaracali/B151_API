package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;
import test_data.JsonPlaceHolderTestData;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get13ObjectMapperPojo extends JsonPlaceHolderBaseUrl {

      /* Given
    https://jsonplaceholder.typicode.com/todos/198
    When
    I send Get Request to the Url
            Then
    Status code is 201
    And
    response body is like {
        "userId": 10,
                "id": 198,
                "title": "quis eius est sint explicabo",
                "completed": true
    }*/

    @Test
    public void Get013() {

        //Set Url

        spec.pathParams("first", "todos", "second", 198);

        //Setexpected data

     /*   String body = "{\n" +
                "                        \"userId\": 10,\n" +
                "                        \"id\": 198,\n" +
                "                        \"title\": \"quis eius est sint explicabo\",\n" +
                "                        \"completed\": true\n" +
                "                       }"; //1.yöntem  */

        String body = JsonPlaceHolderTestData.convertJsonToString(10,"quis eius est sint explicabo",true); //2.yöntem.method olusturduk
        JsonPlaceHolderPojo expectedDataPojo = ObjectMapperUtils.convertJsonToJava(body, JsonPlaceHolderPojo.class);
        System.out.println(expectedDataPojo);

        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        JsonPlaceHolderPojo actualDataPojo = ObjectMapperUtils.convertJsonToJava(response.asString(), JsonPlaceHolderPojo.class);
        assertEquals(200, response.statusCode());
        assertEquals(expectedDataPojo.getCompleted(),actualDataPojo.getCompleted());
        assertEquals(expectedDataPojo.getTitle(),actualDataPojo.getTitle());
        assertEquals(expectedDataPojo.getUserId(),actualDataPojo.getUserId());

    }
}