package com.example.commons.security;


import org.springframework.util.DigestUtils;

public class MD5Utils {

    public static byte[] md5Digest(byte[] bytes){
        return DigestUtils.md5Digest(bytes);
    }

    public static byte[] md5Digest(String s){
        return md5Digest(s.getBytes());
    }


}
