package org.example;


class Q{
    int num;

    boolean valeSet=false;
    public synchronized void put(int num){

        while (valeSet){
            try{
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Put  :" +num);
        this.num=num;
        valeSet=true;
        notify();
    }

    public  synchronized void   get(){
        while (!valeSet){
            try{
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Get  :" +num);
        valeSet=false;
        notify();
    }
}

class Producer implements Runnable {

    Q q;

    public Producer(Q q) {
        this.q = q;
        Thread t = new Thread(this, "Producer");
        t.start();
    }


    @Override
    public void run() {
        int i = 0;
        while (true) {
            q.put(i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

    class Consumer implements Runnable {

        Q q;

        public Consumer(Q q) {
            this.q = q;
            Thread t = new Thread(this, "Consumer");
            t.start();
        }


        @Override
        public void run() {
            while (true) {
                q.get();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


        public class InterThread {
            public static void main(String[] args) {

                Q q =new Q();
                new Producer(q);
                new Consumer(q);
            }

}
