import java.util.concurrent.locks.ReentrantReadWriteLock;
public class sharedresource {
    int data=0;
    private final ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
    public void write(){
        lock.writeLock().lock();
        data++;
        System.out.println("Data written:"+data);
        lock.writeLock().unlock();
    }
    public void read(){
        lock.readLock().lock();
        System.out.println("Data:"+data);
        lock.readLock().unlock();
    }
}
class write extends Thread{
    sharedresource s;
    write(sharedresource s){
        this.s=s;
    }
    public void run(){
        for (int i = 0; i <5; i++) {
            s.write();
        }
    }
}
class read1 extends Thread{
    sharedresource s;
    read1(sharedresource s){
        this.s=s;
    }
    public void run(){
        for (int i = 0; i <5; i++) {
            s.read();
        }
    }
}
class read2 extends Thread{
    sharedresource s;
    read2(sharedresource s){
        this.s=s;
    }
    public void run(){
        for (int i = 0; i <5; i++) {
            s.read();
        }
    }
}
class read3 extends Thread{
    sharedresource s;
    read3(sharedresource s){
        this.s=s;
    }
    public void run(){
        for (int i = 0; i <5; i++) {
            s.read();
        }
    }
}
