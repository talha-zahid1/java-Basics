public class MyTables {
    Boolean f1=false,f2=false,f3=false,f4=false,f5=false,f6=false;
    synchronized public void Printtable2(){
        while(f1) {
            try {
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        System.out.println("Table 2");
        for (int i = 2,j=1; i <=20; i+=2,j++) {
            System.out.println("2 x "+j+" = "+i);
        }
        f1=true;
        f2=true;
        notifyAll();
    }
    synchronized public void Printtable3(){
        while(!f2) {
            try {
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        System.out.println("Table 3");
        for (int i = 3,j=1; i <=30; i+=3,j++) {
            System.out.println("3 x "+j+" = "+i);
        }
        f3=true;
        notifyAll();
    }
    synchronized public void Printtable4(){
        while(!f3) {
            try {
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        System.out.println("Table 4");
        for (int i = 4,j=1; i <=40; i+=4,j++) {
            System.out.println("4 x "+j+" = "+i);
        }
        f4=true;
        notifyAll();
    }
    synchronized public void Printtable5(){
        while (!f4) {
            try {
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        System.out.println("Table 5");
        for (int i = 5,j=1; i <=50; i+=5,j++) {
            System.out.println("5 x "+j+" = "+i);
        }
        f5=true;
        notifyAll();
    }
    synchronized public void Printtable6(){
        while (!f5) {
            try {
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        System.out.println("Table 6");
        for (int i = 6,j=1; i <=60; i+=6,j++) {
            System.out.println("6 x "+j+" = "+i);
        }
        notifyAll();
    }
}
class Table2 extends Thread{
    MyTables t;
    Table2(MyTables t){
        this.t=t;
    }
    public void run(){
        t.Printtable2();
    }
   
}
class Table3 extends Thread{
    MyTables t;
    Table3(MyTables t){
        this.t=t;   
    }
    public void run(){
        t.Printtable3();
    }
}
class Table4 extends Thread{
    MyTables t;
    Table4(MyTables t){
        this.t=t;   
    }
    public void run(){
        t.Printtable4();
    }
}
class Table5 extends Thread{
    MyTables t;
    Table5(MyTables t){
        this.t=t;   
    }
    public void run(){
        t.Printtable5();
    }
}
class Table6 extends Thread{
    MyTables t;
    Table6(MyTables t){
        this.t=t;
    }
    public void run(){
        t.Printtable6();
    }
}