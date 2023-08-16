package test_data;

import java.util.HashMap;
import java.util.Map;

public class HerOkuAppTestData {


    public Map<String,String> bookingDateMapper(String checkin, String checkout){

        Map<String, String> bookingDatesMap = new HashMap<>();  //ilk önce ic map olusturulur
        bookingDatesMap.put("checkin","checkin");
        bookingDatesMap.put("checkout","2019-01-01");
     //   System.out.println("bookingDatesMap =")+ bookingDatesMap;
        return bookingDatesMap;

    }

    public  Map<String,Object> expectedDataMapper(String firstname, String lastname, Integer totalprice, Boolean depositpaid,Map<String,String>bookingdates,String additionalneeds){

        Map<String,Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("firstname","James");
        expectedDataMap.put("lastname", "Doe");
        expectedDataMap.put("totalprice", 111);
        expectedDataMap.put("depositpaid", true);
        expectedDataMap.put("bookingdates", bookingdates);
        expectedDataMap.put("additionalneeds", "Extra pillows please");
        System.out.println("expectedDataMap = " + expectedDataMap);
        return expectedDataMap;
    }



  /*  Map<String, String> bookingDatesMap = new HashMap<>();  //ilk önce ic map olusturulur
        bookingDatesMap.put("checkin","checkin");
        bookingDatesMap.put("checkout","2019-01-01");

    Map<String,Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("firstname","James");
        expectedDataMap.put("lastname", "Doe");
        expectedDataMap.put("totalprice", 111);
        expectedDataMap.put("depositpaid", true);
        expectedDataMap.put("bookingdates", bookingDatesMap);
        expectedDataMap.put("additionalneeds", "Extra pillows please");
        System.out.println("expectedDataMap = " + expectedDataMap);  */


}
