package learning.himura.httprequestpractice;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hazem on 8/1/2017.
 */

public class MyCustomDeserializer implements JsonDeserializer<List<String>>
{


    @Override
    public List<String> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext ctx) throws JsonParseException
    {
        Log.d("himura","in deserializer");
        Log.d("himura",json.toString());
        List<String> ret = new ArrayList<String>();

        if (json instanceof JsonArray) {
            JsonArray jArray = json.getAsJsonArray();
            for (JsonElement entry:jArray) {
                ret.add(entry.toString());
            }
        }
//        JsonArray titles = jArray.get(1).getAsJsonArray();
//        JsonArray descriptions = jArray.get(2).getAsJsonArray();
//        JsonArray links = jArray.get(3).getAsJsonArray();
//
//        for(int i = 0; i < jArray.size(); i++) {
//            ListItemM item = new ListItemM(titles.get(i).getAsString(), descriptions.get(i).getAsString(), links.get(i).getAsString());
//            ret.add(item);
//        }

        Log.d("himura","");Log.d("himura","");Log.d("himura","");Log.d("himura","");
        return ret;
    }
}
