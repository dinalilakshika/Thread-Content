package org.example;

class One extends Thread{
    public void run(){
        for(int i=0;i<=5;i++){
            System.out.println("One");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class Two extends Thread{
    public void run(){
        for(int i=0;i<=5;i++){
            System.out.println("Two");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        One obj1 = new One();
        Two obj2 = new Two();


        obj1.start();
        obj2.start();


    }
}