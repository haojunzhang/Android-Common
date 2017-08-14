package haojun.android_common.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import haojun.android_common.R;
import retrofit2.Response;


public class CommonActivity extends AppCompatActivity {

    private ProgressDialog pd;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setRequestedOrientation(true ? ActivityInfo.SCREEN_ORIENTATION_PORTRAIT : ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }


    protected AlertDialog alert(int titleId, int messageId, DialogInterface.OnClickListener posi, DialogInterface.OnClickListener nega) {
        return alert(getString(titleId), getString(messageId), posi, nega);
    }

    protected AlertDialog alert(String title, String message, DialogInterface.OnClickListener posi, DialogInterface.OnClickListener nega) {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        if (title != null) b.setTitle(title);
        if (message != null) b.setMessage(message);
        if (posi != null || nega != null) {
            b.setPositiveButton(R.string.confirm, posi);
            b.setNegativeButton(R.string.cancel, nega);
        }
        return b.show();
    }

    protected AlertDialog alertWithView(View v, DialogInterface.OnClickListener posi, DialogInterface.OnClickListener nega) {
        return alertWithView(null, v, posi, nega);
    }

    protected AlertDialog alertWithView(String title, View v, DialogInterface.OnClickListener posi, DialogInterface.OnClickListener nega) {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        if (title != null) b.setTitle(title);
        b.setView(v);
        if (posi != null || nega != null) {
            b.setPositiveButton(R.string.confirm, posi);
            b.setNegativeButton(R.string.cancel, nega);
        }
        return b.show();
    }

    protected AlertDialog alertWithItems(String[] items, DialogInterface.OnClickListener click) {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setItems(items, click);
        return b.show();
    }

    protected void showLoadingDialog() {
        showLoadingDialog(null);
    }

    protected void showLoadingDialog(String message) {
        if (pd == null) {
            pd = new ProgressDialog(this);
            pd.setIndeterminate(true);
            pd.setCancelable(false);
        }
        pd.setMessage(message != null ? message : getString(R.string.loading));
        pd.show();
    }

    protected void dismissLoadingDialog() {
        if (pd != null && pd.isShowing()) {
            pd.dismiss();
        }
    }

    protected void openActivity(Class activityClass) {
        openActivity(activityClass, null);
    }

    protected void openActivity(Class activityClass, Bundle bundle) {
        Intent intent = new Intent(this, activityClass);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    protected void openActivityForResult(Class activityClass, int request) {
        openActivityForResult(activityClass, request, null);
    }

    protected void openActivityForResult(Class activityClass, int request, Bundle bundle) {
        Intent intent = new Intent(this, activityClass);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, request);
    }

    protected void hideKeyBoard(View view) {
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
        }
    }

    protected void t(int textId) {
        t(getString(textId));
    }

    protected void t(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    protected boolean isResponseOK(Response<?> response) {
        if (!response.isSuccessful()) {
            t(getString(R.string.connect_error) + response.code());
            return false;
        }
        if (response.body() == null) {
            t(R.string.server_error_null);
            return false;
        }
        return true;
    }

}
