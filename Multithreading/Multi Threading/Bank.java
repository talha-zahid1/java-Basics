public class Bank {
    private double Balance=5000;
    synchronized public void Dep(double depAmount){
        System.out.println("Initial Balance:"+Balance);
        Balance+=depAmount;
        System.out.println("Deposited Amount:"+depAmount);
        System.out.println("Balance After Deposite:"+Balance);
        notify();
    }
    synchronized public void withdraw(double wamount){
        while(Balance<wamount) {
            try {
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        System.out.println("Initial Balance:"+Balance);
        Balance-=wamount;
        System.out.println("WithDraw Amount:"+wamount);
        System.out.println("Balance After WithDrawal:"+Balance);
    }
}
class Deposite extends Thread{
    Bank b;
    double depAmount;
    public Deposite(Bank b,double depAmount){
        this.b=b;
        this.depAmount=depAmount;
    }
    public void run(){
        b.Dep(depAmount);
    }
}
class NewDeposite extends Thread{
    Bank b;
    double depAmount;
    public NewDeposite(Bank b,double depAmount){
        this.b=b;
        this.depAmount=depAmount;
    }
    public void run(){
        b.Dep(depAmount);
    }
}
class Withdraw extends Thread{
    Bank b;
    double wamount;
    Withdraw(Bank b,double wamount){
        this.b=b;
        this.wamount=wamount;
    }
    public void run(){
        b.withdraw(wamount);
    }
}
class newWithdraw extends Thread{
    Bank b;
    double wamount;
    newWithdraw(Bank b,double wamount){
        this.b=b;
        this.wamount=wamount;
    }
    public void run(){
        b.withdraw(wamount);
    }
}