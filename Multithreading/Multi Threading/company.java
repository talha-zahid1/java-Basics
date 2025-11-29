public class company {

    int n;
    Boolean f=false;
    synchronized public void Produce(int n){
        if (f) {
            try {
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        this.n=n;
        System.out.println("Produced:"+n);
        notify();
        f=true;

    }
    synchronized public int consume(){
        if (!f) {
            try {
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        System.out.println("Consumed:"+n);
        notify();
        f=false;
        return n;
    }
}