package gmiBank;

import base_urls.GmiBankBaseUrl;
import org.junit.Test;

public class PostCountry extends GmiBankBaseUrl {

    /*
    Given
        https://gmibank.com/api/tp-countries
    And
        Body:
            {
              "name": "Banana",
              "states": [
                {
                  "id": 1,
                  "name": "Apple"
                },
                {
                  "id": 2,
                  "name": "Orange"
                },
                {
                  "id": 3,
                  "name": "Pear"
                }
              ]
             }
    When
        send posr request
    Then
        Statuscode 200
    And
        body :
                 {
    "id": 191587,
    "name": "Banana",
    "states": [
        {
            "id": 1,
            "name": "Apple",
            "tpcountry": null
        },
        {
            "id": 2,
            "name": "Orange",
            "tpcountry": null
        },
        {
            "id": 3,
            "name": "Pear",
            "tpcountry": null
        }
    ]
}
     */

    @Test
    public void postStates(){

        //Set  Url
        spec.pathParams("first","api","second","tp-countries");

        //Set Expected data




    }











}
