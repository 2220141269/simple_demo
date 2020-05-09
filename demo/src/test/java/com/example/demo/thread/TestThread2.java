package com.example.demo.thread;

import com.example.demo.entity.Person;

import java.util.HashMap;
import java.util.Map;

public class TestThread2 extends  Thread{

    private static Map<String, Person> map = new HashMap<>();

    static{
        Person person = new Person();
        person.setAge(1);

        map.put("person",person);
    }


    public static void main(String[] args) {
        TestThread2 thead1 = new TestThread2();
        TestThread2 thead2 = new TestThread2();
        TestThread2 thead3 = new TestThread2();
        TestThread2 thead4 = new TestThread2();
        TestThread2 thead5 = new TestThread2();

        thead1.start();
        thead2.start();
        thead3.start();
        thead4.start();
        thead5.start();

        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       // System.out.println(map.get("person").getAge());
    }


    @Override
    public void run() {
        putMap();
    }

    public  void putMap(){
        Map<String,Person> myMap = map;
            Person person = myMap.get("person");
            //synchronized (person){
                for (int i=0;i<100;i++){
                    person.setAge( person.getAge() + 1);
                    System.out.println(String.format("地%s次加一",i));
                }
        //}


    }
}
