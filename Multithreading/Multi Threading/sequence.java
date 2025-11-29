public class sequence {
    int n=1;
    synchronized public void one(){
        while (n!=1) {
            try {
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        System.out.println("1");
        n++;
        notifyAll();
    }
    synchronized public void two(){
        while (n!=2) {
            try {
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        System.out.println("2");
        n++;
        notifyAll();        
    }
    synchronized public void three(){
        while (n!=3) {
            try {
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        System.out.println("3");
        n=1;
        notifyAll();
    }
}
class print1 extends Thread{
    sequence s;
    print1(sequence s){
        this.s=s;
    }
    public void run(){
        for (int i = 0; i < 5; i++) {
            s.one();
        }
    }
}
class print2 extends Thread{
    sequence s;
    print2(sequence s){
        this.s=s;
    }
    public void run(){
        for (int i = 0; i < 5; i++) {
            s.two();
        }
    }
}
class print3 extends Thread{
    sequence s;
    print3(sequence s){
        this.s=s;
    }
    public void run(){
        for (int i = 0; i <5; i++) {
            s.three();   
        }
    }
}