package org.example;

/* Created By Sithira Roneth
 * Date :4/5/24
 * Time :10:09
 * Project Name :Thread
 * */
class One extends Thread{
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("One");
            try{
                Thread.sleep(500);
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }
}
class Two extends Thread{
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Two");
            try{
                Thread.sleep(500);
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        One one = new One();
        Two two = new Two();

        one.start();
        try {
            Thread.sleep(10);
        }catch (InterruptedException e){
            throw new RuntimeException();
        }
        two.start();
        try{
            Thread.sleep(10);
        }catch (InterruptedException e){
            throw new RuntimeException();
        }
    }
}
