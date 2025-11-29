public class Consumer extends Thread{
    company c;
    Consumer(company c)
    {
         this.c=c;
    }
   public void run()
   {
    while (true) {
        c.consume();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
   }
    
}
