package haojun.android_common.retrofit;

import java.util.ArrayList;

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
//            .addConverterFactory(ScalarsConverterFactory.create())
            .build();

    GitHubService service = retrofit.create(GitHubService.class);

    @GET("users/{user}/repos")
    Call<ArrayList<RepoModel>> getRepoList(@Path("user") String user);

//    @Multipart
//    @POST("Picture/Create")
//    Call<Player> createPicture(@Part MultipartBody.Part fileName,
//                               @Part MultipartBody.Part subFileName,
//                               @Part MultipartBody.Part type,
//                               @Part MultipartBody.Part file);
//
//    @POST("Player/SignIn")
//    Call<Player> signIn(@Body Player player);
//
//    @GET("youbike")
//    Call<String> getData();
}
