package haojun.android_common.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;

import haojun.android_common.R;

public class FileHelper {

    public static File createFile(File dir, String fileName) {
        try {
            File f = new File(dir, fileName);
            if (f.exists()) {
                f.delete();
            }
            return f.createNewFile() ? f : null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static File writeFile(byte[] bArr, File file) {
        try {
            if (file == null) return null;
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bArr);
            fos.flush();
            fos.close();
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Uri file2Uri(File file) {
        return Uri.fromFile(file);
    }

    public static File getPicturesDir(Context context) {
        return context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
    }

    public static File getAppExternalDir(Context context) {
        File dir = new File(Environment.getExternalStorageDirectory() + File.separator + context.getString(R.string.app_name));
        if (!dir.exists())
            dir.mkdir();
        return dir;
    }
}
