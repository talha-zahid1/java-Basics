public class Philospherproblem {
    public static void main(String[] args)throws Exception {
        shareresource s=new shareresource();
        Thread t1=new Thread(()->{

        });
        t1.start();
    }
}
class shareresource {
    boolean lf1rf5=false,rf1lf2=false,rf2lf3=false,rf3lf4=false,rf4lf5=false;
    synchronized public void Philospher1(){
        System.out.println("I ate");
        rf1lf2=true;
        rf2lf3=true;
        notifyAll();
    }
    synchronized public void Philospher2(){
        while (!rf1lf2 && !rf2lf3) {
            try {
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        System.out.println("I ate");
        rf1lf2=false;
        rf3lf4=true;
        notifyAll();
    }
    synchronized public void Philospher3(){
        while(!rf2lf3 && !rf3lf4) {
            try {
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        System.out.println("I ate");
        rf2lf3=false;
        rf4lf5=true;
        notifyAll();
    }
    synchronized public void Philospher4(){
        while(!rf3lf4 && !rf4lf5) {
            try {
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        System.out.println("I ate");
        rf3lf4=false;
        rf4lf5=false;
        notifyAll();
    }
    synchronized public void Philospher5(){
        while(!lf1rf5 && !rf4lf5) {
            try {
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        System.out.println("I ate");
        lf1rf5=true; 
        rf4lf5=false;
        notifyAll();
    }
}