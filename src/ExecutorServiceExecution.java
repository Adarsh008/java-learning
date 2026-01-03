import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExecution {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for(int i =0 ; i< 10 ; i++){
            int finalI = i;
            executorService.submit(
                ()->{
                    try {
                        System.out.println("factorial of "  + finalI +" is "+ ExecutorServiceExecution.factorial(finalI) );
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            );
        }
        executorService.shutdown();

        while (!executorService.awaitTermination(1, TimeUnit.SECONDS)){
            System.out.println("HI");
        };



        System.out.println("sab khatam ");

    }

    public static int factorial(int factororial) throws InterruptedException {
        Thread.sleep(1000);
        int ans =1;
        for(int i = 2;i<= factororial;i++){
            ans = ans *i;
        }
        return ans;
    }
}
