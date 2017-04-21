package haojun.android_common.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import haojun.android_common.R;
import haojun.android_common.model.RepoModel;
import haojun.android_common.retrofit.GitHubService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        GitHubService service = GitHubService.retrofit.create(GitHubService.class);
        Call<List<RepoModel>> call = service.getRepoList("haojunzhang");
        // async
        call.enqueue(new Callback<List<RepoModel>>() {
            @Override
            public void onResponse(Call<List<RepoModel>> call, Response<List<RepoModel>> response) {
                List<RepoModel> list = response.body();

            }

            @Override
            public void onFailure(Call<List<RepoModel>> call, Throwable t) {

            }
        });
    }
}
