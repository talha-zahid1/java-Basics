public class DeadLock {

    public static void main(String[] args)throws Exception {
      Friend2 SpoonB=new Friend2();
      Friend1 SpoonA=new Friend1();
        new Thread(()->{
          synchronized (SpoonA){
            try {
              Thread.sleep(2000);
            } catch (Exception e) {
              // TODO: handle exception
            }
            synchronized (SpoonB){

            }
          }
        }).start();
        new Thread(()->{
          synchronized (SpoonA){
            try {
              Thread.sleep(1000);
            } catch (Exception e) {
              // TODO: handle exception
            }
            synchronized (SpoonB){

            }
          }
        }).start();
    }
}
class Friend1{}
class Friend2{}

