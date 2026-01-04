package com.learning.multithreading;

class Counter {
    int count =0 ;

     void  increment(){
         synchronized (this){
             count++;
         }
    }

}

class SharedResource extends  Thread{
    @Override
    public void run(){
        int i =0;
        while(i <1000){
            counter.increment();
            i++;
        }
    }
    Counter counter;
    SharedResource(Counter counter){
        this.counter = counter;
    }
}
public class SyncronizationDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        SharedResource th1 = new SharedResource(counter);
        SharedResource th2 = new SharedResource(counter);
         th1.start();
        th2.start();


        th1.join();
        th1.join();


        System.out.println(counter.count);
    }
}
