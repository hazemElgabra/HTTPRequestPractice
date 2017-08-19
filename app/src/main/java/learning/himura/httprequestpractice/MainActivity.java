package learning.himura.httprequestpractice;

import android.database.Observable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ContentFrameLayout;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private WikiAPI api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // setup retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WikiAPI.BASE_URL)
                .addConverterFactory(buildGsonConverter())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        api = retrofit.create(WikiAPI.class);

        Log.d("himura", "starting up observable...");

        search(WikiAPI.DEFAULT_ACTION, WikiAPI.DEFAULT_FORMAT, "hazem")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( bigList-> {
                    Object [] temp = bigList.toArray();
                    for (Object templist:temp) {
                        ArrayList<String> list = new ArrayList<String>((Collection<? extends String>) templist);
                        Log.d("himura", "i'm in    " + list.getClass().getName());
                        Log.d("himura", "i'm in    " + list.toString());
                        if(list.size()>0)
                            Log.d("himura", "i'm in    " + list.get(0));
                    }
                });
    }





    public rx.Observable<List<String>> search(String action, String format, String searchText){
        return api.search(action,format,searchText);
    }

    private Converter.Factory buildGsonConverter() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        // Adding custom deserializers
        gsonBuilder.registerTypeAdapter(String.class, new MyCustomDeserializer());
        Gson myGson = gsonBuilder.create();

        return GsonConverterFactory.create(myGson);
    }
}
