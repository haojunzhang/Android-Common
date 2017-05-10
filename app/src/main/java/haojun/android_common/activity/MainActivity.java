package haojun.android_common.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import haojun.android_common.R;
import haojun.android_common.helper.EncrptyHelper;
import haojun.android_common.helper.LogHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String text = "123";
        LogHelper.d(EncrptyHelper.sha256(text));
    }
}
