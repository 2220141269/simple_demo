package com.example.demo;

public class AClass {

    private static String age = iniAge();

    private String name = iniName();



    static{
        System.out.println("执行A静态代码块");
    }

    {
        System.out.println("执行A代码块");
    }

    public AClass(){
        System.out.println("执行A构造方法");
    }

    public String iniName(){
        System.out.println("初始化A实例属性");
        return null;
    }

    public static String iniAge(){
        System.out.println("初始化A静态属性");
        return null;
    }


    public static void main(String[] args) {
        String s = "1,1,1,,,";
        System.out.println(s.split(",").length);
    }


}
