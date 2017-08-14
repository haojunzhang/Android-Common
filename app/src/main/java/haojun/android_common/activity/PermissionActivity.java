package haojun.android_common.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;

import haojun.android_common.R;

public class PermissionActivity extends CommonActivity {

    // request
    public static final int PERMISSION = 0;

    // permission
    public static final String[] PERMISSIONS = {
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
        checkPermission();
    }

    private void checkPermission() {
        // check
        for (String permission : PERMISSIONS) {
            if (ActivityCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION);
                return;
            }
        }
        // pass
        openActivity(MainActivity.class);
        finish();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for (int result:grantResults){
            if (result != PackageManager.PERMISSION_GRANTED){
                finish();
                return;
            }
        }
        openActivity(MainActivity.class);
        finish();
    }
}
