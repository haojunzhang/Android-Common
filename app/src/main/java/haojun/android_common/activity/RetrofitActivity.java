package haojun.android_common.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import haojun.android_common.R;
import haojun.android_common.helper.LogHelper;
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

        Call<ArrayList<RepoModel>> call = GitHubService.service.getRepoList("haojunzhang");
        // async
        call.enqueue(new Callback<ArrayList<RepoModel>>() {
            @Override
            public void onResponse(Call<ArrayList<RepoModel>> call, Response<ArrayList<RepoModel>> response) {
                ArrayList<RepoModel> list = response.body();
                for(RepoModel r : list){
                    LogHelper.d(r.toString());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<RepoModel>> call, Throwable t) {

            }
        });
    }
}
