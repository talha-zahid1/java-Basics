public class Parallelmergesort {
    public static void main(String[] args)throws Exception {
        int[] Array={3,2,4,7,5,8,1,6,10,9,11,12};
        int tp=Array.length;
        int p1=tp/2;
        int p2=tp-p1;
        int[]Arrayp1=new int[p1];
        int[]Arrayp2=new int[p2];
        for (int i = 0; i < Arrayp1.length; i++) {
            Arrayp1[i]=Array[i];
        }
        for (int i = 0,j=p2; i < Arrayp2.length && j<Array.length; i++,j++) {
            Arrayp2[i]=Array[j];
        }
        Thread t1=new Thread(()->{
            for (int i = 0; i < Arrayp1.length-1; i++) {
                for (int j = i; j < Arrayp1.length; j++) {
                    if (Arrayp1[i]>Arrayp1[j]) {
                        int temp=Arrayp1[i];
                        Arrayp1[i]=Arrayp1[j];
                        Arrayp1[j]=temp;
                    }
                }
            }
        });
        Thread t2=new Thread(()->{
            for (int i = 0; i < Arrayp2.length-1; i++) {
                for (int j = i; j < Arrayp2.length; j++) {
                    if (Arrayp2[i]>Arrayp2[j]) {
                        int temp=Arrayp2[i];
                        Arrayp2[i]=Arrayp2[j];
                        Arrayp2[j]=temp;
                    }
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        int[]MergeArray=new int[Array.length];
        int i=0,k=0,j=0;
        for (;i<Arrayp1.length && j<Arrayp2.length;k++) {
            if (Arrayp1[i]<=Arrayp2[j]) {
                MergeArray[k]=Arrayp1[i];
                i++;
            }else{
                MergeArray[k]=Arrayp2[j];
                j++;
            }
        }
        if (i==Arrayp1.length) {
            for (;j<Arrayp2.length;j++,k++) {
                MergeArray[k]=Arrayp2[j];
            }
        }else if (j==Arrayp2.length) {
            for (;i<Arrayp1.length;i++,k++) {
                MergeArray[k]=Arrayp1[i];
            }
        }
        System.out.println("Final Sorted Array");
        for (int i1 = 0; i1 < MergeArray.length; i1++) {
            System.out.println("Index "+i1+"="+MergeArray[i1]);
        }
    }
}
