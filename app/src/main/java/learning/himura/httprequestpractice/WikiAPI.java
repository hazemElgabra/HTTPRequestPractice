package learning.himura.httprequestpractice;

import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface WikiAPI {
    String SAMPLE_URL = "https://en.wikipedia.org/w/api.php?action=opensearch&format=json&search=";
    String BASE_URL = "https://en.wikipedia.org/w/";
    String DEFAULT_ACTION = "opensearch";
    String DEFAULT_FORMAT = "json";

    @GET("api.php")
    Observable<List<String>> search(@Query("action") String action,
                                       @Query("format") String format,
                                       @Query("search") String searchText);
}
