package haojun.android_common.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import haojun.android_common.R;
import haojun.android_common.helper.EncryptHelper;
import haojun.android_common.helper.LogHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String text = "123";
        LogHelper.d(EncryptHelper.md5(text));
        LogHelper.d(EncryptHelper.sha256(text));
        LogHelper.d(EncryptHelper.sha512(text));
    }
}
