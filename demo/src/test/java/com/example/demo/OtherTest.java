package com.example.demo;

import com.example.service.HelloService;
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.web.context.ContextLoaderListener;


import javax.servlet.ServletContext;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.ServerSocket;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
@Log4j2
public class OtherTest {



    @Test
    public void test1(){
        Double d1 = new Double(0);
        Double d2 = new Double(0);
        if (d1 == d2){
            System.out.println("相等");
        }else {
            System.out.println("不相等");
        }

        if (d1.doubleValue() == d2.doubleValue()){
            System.out.println("相等");
        }else {
            System.out.println("不相等");
        }

    }

    @Test
    public void test2(){
        BigDecimal b1 = new BigDecimal("1");
        BigDecimal b2 = new BigDecimal("1");

        System.out.println(String.format("b1 - b2 = %s ",b1.subtract(b2).toString()));
    }
    @Test
    public void test3(){
        //Map<String, Person> map = new ConcurrentHashMap<>();

        AtomicInteger count = new AtomicInteger(10);
        System.out.println(count.incrementAndGet());
        System.out.println(count.decrementAndGet());


    }

    @Test
    public void test4(){
        Semaphore semphore = new Semaphore(5);


        try {
            semphore.acquire();
        }catch (Exception e){

        }finally {
            semphore.release();
        }



    }
    @Test
    public void test5(){
        RateLimiter limiter = RateLimiter.create(5);
        System.out.println("--" + System.currentTimeMillis() / 1000);
        System.out.println(limiter.acquire(1));
        System.out.println("--" + System.currentTimeMillis() / 1000);
        System.out.println(limiter.acquire(5));
        System.out.println("--" + System.currentTimeMillis() / 1000);
        System.out.println(limiter.acquire(2));
        System.out.println("--" + System.currentTimeMillis() / 1000);
        System.out.println(limiter.acquire(1));
    }
    @Test
    public void test6(){
        List<String> list = new ArrayList<>();
        list.add("2");
        list.add("3");
        list.add("1");

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2 .compareTo(o1);
            }
        });

        System.out.println(list.toString());

        //1,5,3,6
        //2,4,1,5
        //124
        Arrays.asList();
    }

    @Test
    public void test7(){

        boolean flag = true;
        Integer i = Integer.valueOf(0);
        int j = 1;
        int k = flag ? i.intValue() : j;
        System.out.println(k);
    }

    public static int num = 0;
    @Test
    public void test8(){


    }

    public static void main(String[] args) {


    }

    @Test
    public  void test9(){
        try {

        String s = "你好";
        byte[] b = s.getBytes();
        System.out.println(Arrays.toString(b));

            System.out.println(Arrays.toString(s.getBytes("utf-8")));

            String s1 = new String(b,"utf-8");
            System.out.println(s1);

            System.out.println("------------------------------");

            String s2 = new String(b,"gbk");
            System.out.println(s2);

            System.out.println("------------------------------");

            byte[] b2 = s2.getBytes("gbk");
            System.out.println(Arrays.toString(b2));
            String ss2 = new String(b2,"utf-8");
            System.out.println(ss2);

            System.out.println("------------------------------");

            String s3 = new String(b,"iso8859-1");
            System.out.println(s3);
        }catch (Exception e){
            e.printStackTrace();
        }





    }




    @Test
    public  void test13(){
        String s = "你好";

        try {
            byte[] b = s.getBytes("utf-8");
            System.out.println(Arrays.toString(b));

            byte[] b2 = s.getBytes("gbk");
            System.out.println(Arrays.toString(b2));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }


    @Mock
    private HelloService helloService;

    @Test
    public void test14(){
        HelloService service = mock(HelloService.class);
        Mockito.when(service.getage(anyString())).thenReturn(10);
        log.info(service.getage(""));
    }


    @Test
    public void test15(){
        ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
        map.get("");

        ReentrantReadWriteLock rrwl;

        ServletContext sc;

        ContextLoaderListener cll;
    }

    @Test
    public void test16(){
        Integer num1 = 123;
        Integer num2 = 123;
        Integer num3 = new Integer(123);
        System.out.println(num1 == num2);
        System.out.println(num1 == num3);

        ServerSocket ss;
        InputStream is;
    }

    @Test
    public void test17(){
        String s = "1";
    }

    public void updateS(String s){
        s = "";
    }


    @Test
    public void test18(){
        String s = "重庆市";
        System.out.println("市".equals(s.substring(s.length() -1)));

    }

    @Test
    public void test19(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(2);

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (Integer i: list) {
            System.out.println(i);

        }

    }

}
