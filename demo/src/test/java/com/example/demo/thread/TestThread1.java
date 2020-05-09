package com.example.demo.thread;

public class TestThread1 extends  Thread{

    private static int count = 0 ;

    public static void main(String[] args) {
        TestThread1 thead1 = new TestThread1();
        TestThread1 thead2 = new TestThread1();
        TestThread1 thead3 = new TestThread1();
        TestThread1 thead4 = new TestThread1();
        TestThread1 thead5 = new TestThread1();

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
        System.out.println("count = "+count);
    }


    @Override
    public void run() {
        add();
    }

    public synchronized void add(){
            for (int i = 0;i<10000;i++){
                count = count + 1;
            }

    }
}
