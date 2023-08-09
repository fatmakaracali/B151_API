package get_requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01 {


     /*
        Given
            https://restful-booker.herokuapp.com/booking/55
        When
            Kullanıcı URL'e bir GET request gönderir
        Then
            HTTP Status Code 200 olmalı
        And
            Content Type "application/json" olmalı
        And
            Status Line "HTTP/1.1 200 OK" olmalı
    */

    @Test
    public void get01(){

        // 1- Set the URL = URL'i tanımla
        // Birinci yöntem
        // String url=" https://restful-booker.herokuapp.com/booking/55";

        //Ikinci Yöntem
        RestAssured.baseURI ="https://restful-booker.herokuapp.com";
        RestAssured.basePath ="/booking/55";

        // 2- Set the expected data = Beklenen dataları ayarla

        // 3- Send the request and get the response = İsteği gönder ve cevabı al
        //given() kismi testin basinda request'in hazirlanmasi asamasidir. Testin temel kosullarinin hazirlanmasi
        //when() kismi olusturdugumuz kosullarin eyleme dönup gerceklestirilmesi

        Response response= given().when().get();
        response.prettyPrint();

        // 4- Do assertion = Doğrulama yap
        //then() yaptigimiz eylemin sonuclarini kontrol ediyoruz

        response.then()
                .statusCode(200)
                .contentType("application/json")
                .statusLine("HTTP/1.1 200 OK");


    }
}
