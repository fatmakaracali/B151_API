package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

    public Map<String,Object> expectedDataMapper(Integer userId,String title,Boolean completed){

        Map<String, Object> expectedData = new HashMap<>();
        if(userId!=null){
            expectedData.put("userId",userId);
        }
        if(title!=null){
            expectedData.put("title",title);
        }
        if(completed!=null){
            expectedData.put("completed",completed);
        }
        return expectedData;
    }
       /*
    if yapmamizin sebebi spesifik bir islem yapmak istedigimizde parametre kismina islem yapacagimiz haric null yazarsak
    body'de null yazdiklarimiza bir islem yapmamasi.
    */


    public static String convertJsonToString(Integer userId, String title, Boolean completed){
        return "{\n" +
                "\"userId\": "+userId+",\n" +
                "\"title\": \""+title+"\",\n" +
                "\"completed\": "+completed+"\n" +
                "}";

    }

}
