package com.example.demo;

import com.example.commons.security.MD5Utils;
import com.example.commons.security.SecretUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Base64;

public class SecretUtilsTest {
    private final static Logger logger = LoggerFactory.getLogger(SecretUtilsTest.class);


    @Test
    public void test1() {
        String msg = "3DES加密解密案例";
        System.out.println("【加密前】：" + msg);

        //加密
        byte[] secretArr = SecretUtils.encryptMode(msg.getBytes());
        System.out.println("【加密后】：" + new String(secretArr));

        byte[] secret64 = Base64.getEncoder().encode(secretArr);
        System.out.println(String.format("【64位加密后】%s",new String(secret64)));

        byte[] secret = Base64.getDecoder().decode(new String(secret64));
        System.out.println(String.format("【64位解密后】%s",new String(secret)));

        //解密
        byte[] myMsgArr = SecretUtils.decryptMode(secret);
        System.out.println("【解密后】：" + new String(myMsgArr));
    }

    @Test
    public void test2(){
        String src = "你好";
        logger.info(String.format("md5加密原文:%s",src));
        byte[] bytes = MD5Utils.md5Digest(src);

        logger.info(String.format("md5加密后报文:%s",new String(bytes)));



    }
}
