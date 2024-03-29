package edu.nju.ics.frontier.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringUtil {
    /**
     * check whether two objects' strings are different.
     * @param oldObj one object
     * @param newObj another object
     * @return true if the two objects' strings are different.
     */
    public static boolean isDifferent(Object oldObj, Object newObj) {
        String oldStr = (oldObj == null) ? "" : oldObj.toString();
        String newStr = (newObj == null) ? "" : newObj.toString();
        return oldStr.compareTo(newStr) != 0;
    }

    /**
     * get the string of an object
     * @param obj an object
     * @return the stirng of the object
     */
    public static String toString(Object obj) {
        return (obj == null) ? null : obj.toString();
    }

    /**
     * get the MD5-encoded text of a string
     * @param s a string
     * @return the MD5-encoded text of the string
     */
    public static String md5Encode(String s) {
        if (s == null || s.length() <= 0) {
            return s;
        }

        byte[] secretBytes = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(s.getBytes());
            secretBytes = md.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        if (secretBytes == null) {
            return s;
        }

        String md5code = new BigInteger(1, secretBytes).toString(16);
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }
}
