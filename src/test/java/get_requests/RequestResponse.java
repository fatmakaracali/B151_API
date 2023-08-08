package get_requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;



public class RequestResponse {

    /**
     1_Manuel API icin Postman kullaniyoruz
     2_API otomasyon testi icin REST Assured kutuphanesini kullaniyoruz
     3-Otomasyon kodlarinin yazimi icin su adimlari izleriz
       A- Gereksinimleri anlama
       B- Test senaryosu yazma
          a-Test senaryosu yazmak icin Gherkin dilini kullaniyoruz
            - Given: Endpoint, body ...
            - When : get, put, post gibi islemler
            - Then : Assertion, Close ...
            - And  : Coklu islemlerin art arda yapildigi zaman kullanilir
       C- Otomasyon kodlarini yazarken su adimlari izleriz
            1- Set the URL(url'i tanimla)
            2- Set the expected data(Beklenen datalari ayarla)
            3- Send the request and get the response(Istegi gönder ve cevabi al)
            4- Do assertion(Dogrulama yap)                                              */



    public static void main(String[] args) {

        //Get testi nasil yapilir?

        String url="https://petstore.swagger.io/v2/pet/780";
        Response response = given().when().get(url);
     //   response.prettyPrint();

        //status kod nasil yazdirilir?
        System.out.println("response.statusCode() = " + response.statusCode());

        //Content Type nasil yazdirilir
        System.out.println("response.contentType() = " + response.contentType());

        //Status Line nasil yazdirilir?
        System.out.println("response.statusLine() = " + response.statusLine());

        //Header'daki veriler nasil yazdirilir?
        System.out.println("response.header(\"Server\") = " + response.header("Server"));

        System.out.println("response.header(\"Connection\") = " + response.header("Connection"));

        System.out.println("****************************************");

        //Headers nasil yazdirilir?
        System.out.println("response.headers() = " + response.headers());

        System.out.println("****************************************");

        //Time nasil yazdirilir?
        System.out.println("response.time() = " + response.time());


    }
}
