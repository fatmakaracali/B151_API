package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class DummyResApiBaseURL {

    protected RequestSpecification spec;
    @Before
    public void Setup(){

        spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .setBaseUri("https://dummy.restapiexample.com/api/v1")
                .build();
    }
    //tekrarli olarak kullanilan degerler burada yazilir

}
