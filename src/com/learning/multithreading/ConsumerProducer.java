package com.learning.multithreading;

class SharedResources {
    int buffer;
    boolean hasdata;

    public synchronized void producer(int r){
        while (hasdata){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        buffer = r;
        System.out.println("com.learning.multithreading.Producer produced " + buffer);
        hasdata = true;
        notify();
    }

    public  synchronized  int consumer(){
        while (!hasdata){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        hasdata = false;
        System.out.println("Cosumer consumed " + buffer);
        notify();
        return buffer;
    }
}

class Consumer extends Thread{
     public SharedResources sharedResource;
    Consumer(SharedResources sharedResource){
        this.sharedResource = sharedResource;
    }
    @Override
    public void run(){
        for (int i =0; i<10; i++){
            int r =  sharedResource.consumer();
        }
    }

}

class Producer extends Thread{
    public SharedResources sharedResource;
    Producer(SharedResources sharedResource){
        this.sharedResource = sharedResource;
    }
    @Override
    public void run(){
        for (int i =0; i<10; i++){
          sharedResource.producer(i);
        }
    }

}


public class ConsumerProducer {
    public static void main(String[] args) {
        SharedResources sharedResource = new SharedResources();
        Producer P = new Producer(sharedResource);
        Consumer C = new Consumer(sharedResource);
        P.start();
        C.start();
    }
}
