import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executerservices {
    public static void main(String[] args)throws Exception {
        ExecutorService service=Executors.newFixedThreadPool(5);
        for (int i = 1; i <=100; i++) {
            int num=i;
            service.submit(()->{
                String name=Thread.currentThread().getName();
                System.out.println(name);
                System.out.println("square of "+num+"="+(num*num));
            });
        }
        service.shutdown();
    }
}
