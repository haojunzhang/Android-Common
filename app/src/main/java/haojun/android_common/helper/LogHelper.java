package haojun.android_common.helper;


import android.util.Log;

public class LogHelper {
    public static final String TAG = "Android-Common";
    private static boolean isDebuggable = false;

    public static void setDebuggable(boolean d) {
        isDebuggable = d;
    }

    public static void d(String msg) {
        d(TAG, msg);
    }

    public static void d(String tag, String msg) {
        if (!isDebuggable) return;
        Log.d(tag, msg);
    }
}
