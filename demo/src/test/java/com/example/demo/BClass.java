package com.example.demo;

public class BClass extends AClass {

    private static String age = iniAge();

    private String name = iniName();



    static{
        System.out.println("执行B静态代码块");
    }

    {
        System.out.println("执行B代码块");
    }

    public BClass(){
        System.out.println("执行B构造方法");
    }

    public String iniName(){
        System.out.println("初始化B实例属性");
        return null;
    }

    public static String iniAge(){
        System.out.println("初始化B静态属性");
        return null;
    }

}
