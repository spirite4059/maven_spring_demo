package com.maven01.web.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Md5工具，用于计算输入的md5;生成输入的md5码
 * @version v1.0
 * 2013-05-29
 */

public class Md5Util {
    public static String md5(String plainText) {
        String str = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            str = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return str;
    }
}



