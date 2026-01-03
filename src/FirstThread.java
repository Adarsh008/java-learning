
class  Mythread extends  Thread{
    @Override
    public void run(){
        for(int i =0; i<10; i++){
            System.out.println( Thread.currentThread().getName()+" no " + i);
        }
    }
}

class ThreadByInterface implements Runnable{

    @Override
    public  void  run(){
        for (int i =0; i<10 ; i++){
            System.out.println("Interface " + Thread.currentThread().getName() + i);
            Thread.yield();
        }
    }

}

public class FirstThread {
    public static void main(String[] args) throws InterruptedException {
        /*Thread myThread = new Mythread();
        myThread.start();*/

        ThreadByInterface th1 = new ThreadByInterface();
        Thread ThreadByInterface = new Thread(th1);
        ThreadByInterface.setName("phla_Thread");
        ThreadByInterface.setName("Dusra_Thread");

        Thread ThreadByInterface1 = new Thread(th1);
        ThreadByInterface.start();
        ThreadByInterface1.start();


        Thread th = new Thread(()->{
            for (int i =0; i< 10 ; i++){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"Thread Ka name ");



        /*System.out.println(th.getState());
        th.start();
        System.out.println(th.getState());
        Thread.currentThread().sleep(100);
        System.out.println(th.getState());
        try {
            th.join();
        } catch (InterruptedException e) {
            System.out.println( e.getMessage());
        }

        System.out.println(th.getState());*/

        /*for(int i =0; i< 1000; i++){
            System.out.println(Thread.currentThread().getName() +" no "+ i );
        }*/
    }
}