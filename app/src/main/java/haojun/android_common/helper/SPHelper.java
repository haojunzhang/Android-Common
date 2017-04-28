package haojun.android_common.helper;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by haojun on 4/23/17.
 */

public class SPHelper {
    private static final String FILE_SAMPLE = "sample";
    private static final String KEY_NAME = "name";

    public void setName(Context context, String name) {
        SharedPreferences sp = context.getSharedPreferences(FILE_SAMPLE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(KEY_NAME, name);
        editor.apply();
    }

    public String getName(Context context) {
        return context.getSharedPreferences(FILE_SAMPLE, Context.MODE_PRIVATE).getString(KEY_NAME, "");
    }

    public void clearName(Context context) {
        context.getSharedPreferences(FILE_SAMPLE, Context.MODE_PRIVATE).edit().clear().apply();
    }
}
