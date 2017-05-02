package haojun.android_common.retrofit;

import java.util.List;

import haojun.android_common.model.RepoModel;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface GitHubService {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("users/{user}/repos")
    Call<List<RepoModel>> getRepoList(@Path("user") String user);
}
