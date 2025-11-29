import java.util.concurrent.CyclicBarrier;

public class Barriers {
    public static void main(String[] args) {
        CyclicBarrier barrier=new CyclicBarrier(5);
        for (int i = 0; i <5; i++) {
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+"Finshed phase 1 work");
                    barrier.await();
                    System.out.println(Thread.currentThread().getName()+"Finshed phase 2 work");
                    barrier.await();
                    System.out.println(Thread.currentThread().getName()+"Finshed phase 3 work");
                } catch (Exception e) {
                    e.getStackTrace();
                }
                
            }).start();
        }
    }
    
}
