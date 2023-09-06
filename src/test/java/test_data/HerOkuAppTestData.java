package test_data;

import java.util.HashMap;
import java.util.Map;

public class HerOkuAppTestData {


    public Map<String,String> bookingDateMapper(String checkin, String checkout){

        Map<String, String> bookingDatesMap = new HashMap<>();  //ilk önce ic map olusturulur
        bookingDatesMap.put("checkin",checkin);
        bookingDatesMap.put("checkout",checkout);
        return bookingDatesMap;
        //   System.out.println("bookingDatesMap ="+ bookingDatesMap);

    }


    public  Map<String,Object> expectedDataMapper(String firstname, String lastname, Integer totalprice,
                                                  Boolean depositpaid,Map<String,String>bookingdates,String additionalneeds) {

        Map<String, Object> expectedDataMap = new HashMap<>();
        if (firstname!=null){
            expectedDataMap.put("firstname", firstname);
        }
        if (lastname!=null){
            expectedDataMap.put("lastname", lastname);
        }
        if (totalprice!=null){
            expectedDataMap.put("totalprice", totalprice);
        }
        if (depositpaid != null){
            expectedDataMap.put("depositpaid", depositpaid);
        }

        if (bookingdates!= null){
            expectedDataMap.put("bookingdates", bookingdates);
        }
        if (additionalneeds != null) {
            expectedDataMap.put("additionalneeds", additionalneeds);
        }
        return expectedDataMap;


    }


}
