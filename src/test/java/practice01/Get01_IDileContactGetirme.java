package practice01;

import io.restassured.RestAssured;
import org.junit.Test;

public class Get01_IDileContactGetirme {

    @Test
    public void get01(){

        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
        RestAssured.basePath = "/contactList";
    }

}
