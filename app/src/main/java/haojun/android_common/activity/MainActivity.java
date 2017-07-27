package haojun.android_common.activity;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import haojun.android_common.R;
import haojun.android_common.helper.LogHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LogHelper.d(getCacheDir().getAbsolutePath());
        LogHelper.d(getFilesDir().getAbsolutePath());
        LogHelper.d(getExternalCacheDir().getAbsolutePath());
        LogHelper.d(getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS).getAbsolutePath());
        LogHelper.d(getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath());
        LogHelper.d(getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath());
    }
}
