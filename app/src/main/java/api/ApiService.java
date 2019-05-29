package api;

import bean.User;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    public String url = "http://gank.io/";
    @GET("api/data/%E7%A6%8F%E5%88%A9/20/1")
    Observable<User> getData();
}
