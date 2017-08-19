package learning.himura.httprequestpractice;

import java.io.Serializable;

/**
 * Created by Hazem on 8/1/2017.
 */

public class ListItemM implements Serializable {
//    @SerializedName("title")
    private String title;
//    @SerializedName("description")
    private String description;
//    @SerializedName("link")
    private String link;

    public String getTitle(){
        return this.title;
    }

    public String getDescription(){
        return this.description;
    }

    public String getLink(){
        return this.link;
    }

    public ListItemM(String title, String description, String link){
        this.title = title;
        this.description = description;
        this.link = link;
    }
}
