
public class haming {
    public static void place(){
        String[] line={"0","0","0","0","1","0","0","0","1","1","1","0","0","1"}; 
        for (int i = 0; i < line.length; i++) {
            int num=(int)Math.pow(2, i);
            int sum=0;
            if (num==1 || num==2 || num==4 || num==8) {
                for (int j =num-1; j < line.length; j+=2*num) {
                    for (int k=0;k<num && (j+k)<line.length;k++) {
                        sum+=Integer.parseInt(line[j+k]);
                    }
                }
                if (sum%2!=0) {
                    line[num-1]="1";
                }else{
                    line[num-1]="0";
                }
            }
        }
        System.out.println("String After Placing Perity Bits ");
        for (int i = 0; i < line.length; i++) {
            System.out.print(line[i]);
        }
        System.out.println();
    }
    public static void check(){
        String[] placedperitybitsline={"1","1","0","0","1","0","0","0","1","1","1","1","0","1"};
        int index=0;
          for (int i = 0; i < placedperitybitsline.length; i++) {
            int num=(int)Math.pow(2, i);
            int sum=0;
            if (num==1 || num==2 || num==4 || num==8) {
                for (int j =num-1; j < placedperitybitsline.length; j+=2*num) {
                    for (int k=0;k<num && (j+k)<placedperitybitsline.length;k++) {
                        sum+=Integer.parseInt(placedperitybitsline[j+k]);
                    }
                }
                if (sum%2!=0) {
                    index+=num;
                }
            }
        }
        System.out.println("The Bit Has Changed At position "+(index-1));
    }
    public static void main(String[] args) {
        place();
        check();
    }
}
