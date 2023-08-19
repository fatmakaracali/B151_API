package post_request;

import base_urls.JsonPlaceHolderBaseUrl;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post05_ObjectMapper_Pojo extends JsonPlaceHolderBaseUrl {
    @Test
    public void test06() {

        // set the url

        spec.pathParam("first","todos");

        //Set the url

        JsonPlaceHolderPojo expectedData = new JsonPlaceHolderPojo(55,"Tidy your room", false);
        System.out.println("expectedData = " + expectedData);

        //Send the req and get the res

        Response response = given(spec).body(expectedData).when().post("{first}");
        response.prettyPrint();

        //Do assertion

        JsonPlaceHolderPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(),JsonPlaceHolderPojo.class);
        assertEquals(201,response.statusCode());
        assertEquals(expectedData.getUserId(),actualData.getUserId());
        assertEquals(expectedData.getTitle(),actualData.getTitle());
        assertEquals(expectedData.getCompleted(),actualData.getCompleted());




    }
}
