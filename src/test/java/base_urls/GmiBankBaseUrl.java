package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class GmiBankBaseUrl {

    protected RequestSpecification spec;
    @Before
    public void Setup(){

        spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Authorization",("Bearer eyJhbGciOiJIUzUxMiJ9" +
                        ".eyJzdWIiOiJtYXJrX3R3YWluIiwiYXV0aCI6IlJPTEVfQURNSU4sUk9MRV9NQU5BR0VSIiwiZXhwIjoxNjk1NDU2NDcyfQ" +
                        ".W1_UiKtmykQzvmMY9H9RF51gBxCD8Bnz8zwChV5OO4O7Zlz-NshqzIrwQ6wU8El4gxyqU11ublCQh-ctSBZ6sg" ))
                .setAccept(ContentType.JSON)
                .setBaseUri("https://gmibank.com")
                .build();
    }
    //tekrarli olarak kullanilan degerler burada yazilir



}
