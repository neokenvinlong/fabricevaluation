package thanhnv.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {
    public static String hashMD5(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(data.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);

            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext.toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String changeValue(String data){
        String replaceData = data.replace("&lt;","<").replace("&amp;","&")
                .replace("&gt;",">").replace("&apos;","\'")
                .replace("&quot;","\"").replace("reg;","")
                .replace("#40;","").replace("#41;","")
                .replace("&copy;","");
        return replaceData;
    }
}
