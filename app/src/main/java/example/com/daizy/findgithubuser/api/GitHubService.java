package example.com.daizy.findgithubuser.api;

import example.com.daizy.findgithubuser.bean.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by daizy on 2017/4/14.
 */

public interface GitHubService {
    //使用get方式，""引号里的内容将会组合到baseUri中作为请求的uri地址
    @GET("/user/{username}")
    Call<User> getUser(@Path("username") String username);
}
