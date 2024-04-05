package org.example;


class MyThread extends Thread{
    public void run(){
        System.out.println("Thread is running");
    }
}

public class ExtentThread{
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}