package com.example.demo.thread;

public class TestThread3 extends  Thread{

    private static int count = 0 ;

    public static void main(String[] args) {
        TestThread3 thead1 = new TestThread3();
        TestThread3 thead2 = new TestThread3();
        TestThread3 thead3 = new TestThread3();
        TestThread3 thead4 = new TestThread3();
        TestThread3 thead5 = new TestThread3();

        thead1.start();
        thead2.start();
        thead3.start();
        thead4.start();
        thead5.start();


    }


    @Override
    public void run() {
        add();
    }

    public  void add(){
        int i =0;
            while(true){
                i = i++;
            }

    }
}
