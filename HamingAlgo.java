public class HamingAlgo {
    public static void  sender(){
        String[] msg={"2","0","0","0","0","1","0","0","0","1","1","1","0","0","1"};
        //Preparing String To send a message
        int powoftwo=0;
        int[] s=new int[4];
        boolean[] f=new boolean[4];
        for (int i = 0; i < msg.length; i++) {
            double n=i;
            powoftwo=(int)Math.pow(2, n);
            if (powoftwo>msg.length) {
                break;
            }
            for (int j = powoftwo; j < msg.length;) {
            if (powoftwo==1) {
                s[0]+=Integer.parseInt(msg[j]);
                j+=2;
            }else if (powoftwo==2) {
                for(int k=0;k<powoftwo&&(j+k)<msg.length;k++){
                    s[1]+=Integer.parseInt(msg[j+k]);
                }
                j+=4;
            }else if (powoftwo==4) {
                for(int k=0;k<powoftwo&&(j+k)<msg.length;k++){
                    s[2]+=Integer.parseInt(msg[j+k]);
                }
                j+=8;
            }else if (powoftwo==8) {
                for(int k=0;k<6 &&(j+k)<msg.length;k++){
                    s[3]+=Integer.parseInt(msg[j+k]);
                }
                j+=12;
            }
        }
        for (int j2 = 0; j2 < s.length; j2++) {
        if (s[j2]%2!=0 && !f[j2] && powoftwo<msg.length) {
            msg[powoftwo]="1";
            f[j2]=true;
        }    
        }
        }
        System.out.print("msg: ");
        for (int i = 0; i < msg.length; i++) {
            System.out.print(msg[i]);
        }
    }
    public static void Reciever(){
        //Preparing To check the recieve message
        String[] msg={"2","1","1","0","0","1","0","0","1","1","1","1","1","0","1"};
        int powoftwo=0;
        int changeindex=0;
        int[] s=new int[4];
        boolean[] f=new boolean[4];
        for (int i = 0; i < msg.length; i++) {
            double n=i;
            powoftwo=(int)Math.pow(2, n);
            if (powoftwo>msg.length) {
                break;
            }
            for (int j = powoftwo; j < msg.length;) {
            if (powoftwo==1) {
                s[0]+=Integer.parseInt(msg[j]);
                j+=2;
            }else if (powoftwo==2) {
                for(int k=0;k<powoftwo&&(j+k)<msg.length;k++){
                    s[1]+=Integer.parseInt(msg[j+k]);
                }
                j+=4;
            }else if (powoftwo==4) {
                for(int k=0;k<powoftwo&&(j+k)<msg.length;k++){
                    s[2]+=Integer.parseInt(msg[j+k]);
                }
                j+=8;
            }else if (powoftwo==8) {
                for(int k=0;k<6 &&(j+k)<msg.length;k++){
                    s[3]+=Integer.parseInt(msg[j+k]);
                }
                j+=12;
            }
            }
            for (int j2 = 0;j2<s.length;j2++ ) {
                if (s[j2]%2!=0 && !f[j2]&&powoftwo<msg.length) {
                    changeindex+=powoftwo;
                    f[j2]=true;
                }    
        }
        }
        if (changeindex!=0) {
            System.out.println("The Message contain change bit at index "+changeindex);
        }else{
            System.out.println("The Message is not Corrupted");
        }
    }
    public static void main(String[] args) {
        sender();
        Reciever();        
    }   
}
