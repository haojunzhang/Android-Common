package haojun.android_common.helper;

import java.security.MessageDigest;

public class EncrptyHelper {
    public static String md5(String str) {
        String md5 = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] barr = md.digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte aBarr : barr) {
                sb.append(byte2Hex(aBarr));
            }
            String hex = sb.toString();
            md5 = hex.toUpperCase(); //一律轉成大寫
        } catch (Exception e) {
            e.printStackTrace();
        }
        return md5;
    }

    private static String byte2Hex(byte b) {
        String[] h = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
        int i = b;
        if (i < 0) {
            i += 256;
        }
        return h[i / 16] + h[i % 16];
    }

    public static String sha256(String s) {
        MessageDigest sha;

        try {
            sha = MessageDigest.getInstance("SHA-256");
            sha.update(s.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

        return byte2hex(sha.digest());
    }

    private static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) hs = hs + "0" + stmp;
            else hs = hs + stmp;
        }
        return hs.toUpperCase();
    }
}

