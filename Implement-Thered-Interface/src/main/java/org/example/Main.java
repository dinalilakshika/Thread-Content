package org.example;

/* Created By Sithira Roneth
 * Date :4/5/24
 * Time :10:30
 * Project Name :Thread
 * */
class One implements Runnable{

    @Override
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
class Two implements Runnable{

    @Override
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

        Thread t1 = new Thread(one);
        Thread t2 = new Thread(two);

        t1.start();
        try{
            Thread.sleep(10);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        t2.start();
        try{
            Thread.sleep(10);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
