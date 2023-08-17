package pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class JsonPlaceHolderPojo {

    /**
     * 1.adim : Tum degiskenlere ait private isimler olustur
     * 2.adim : Parametreli ve parametresiz constructor olustur
     * 3.adim : public Getter ve Setter lari olustur
     * 4.adim : toString methodu olustur
     */


    //1.adim : Tum degiskenlere ait private isimler olustur

    private Integer userId;
    private String title;
    private Boolean completed;

    //2.adim : Parametreli ve parametresiz constructor olustur


    public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    public JsonPlaceHolderPojo() {

    }

    //3.adim : public Getter ve Setter lari olustur


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }


//4.adim : toString methodu olustur

    @Override
    public String toString() {
        return "JsonPlaceHolderPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';


    }
}