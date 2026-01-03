
class NormalThread extends  Thread{
    @Override
    public void run(){
        while (true){
            System.out.println("ABCD");
        }
    }
}

public class DaemonnThread {
    public static void main(String[] args) throws InterruptedException {
        NormalThread Nth = new NormalThread();
        Nth.setDaemon(true);
        Nth.start();
        Thread.sleep(100);

    }
}
