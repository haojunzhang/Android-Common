package haojun.android_common.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeHelper {
    private static final SimpleDateFormat sdf_standard = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String getStandardSDF() {
        return sdf_standard.format(new Date());
    }

}
