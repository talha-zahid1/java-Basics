/*> Problem Statement:
Write a Java program that reads a binary tree from a file and performs various operations such as printing all leaf nodes, searching for a number and its index, displaying parent and child nodes of any number, and printing the tree using inorder traversal. */
import java.io.File;
import java.util.Scanner;

public class BinaryTree {
    static int[][] BT=new int[13][3];
    public static void printLN(){
        int j=0;
        for (int i = 0; i < BT.length; i++) {
            if (BT[i][j]==-1 && BT[i][j+2]==-1) {
                System.out.println("LeafNode = "+BT[i][j+1]);
            }
        }

    }
    public static void Searchnumber(){
        Scanner sc=new Scanner(System.in);
        int num;
        System.out.println("Enter a Number to Search");
        num=sc.nextInt();
        int j=0;
        boolean f=false;
        for (int i = 0; i < BT.length; i++) {
            if (BT[i][j+1]==num) {
                System.out.println("Entered Number "+num+" Found At Index "+i);
                f=true;
            }
        }
        if (!f) {
            System.out.println("Entered Number "+num+" Does not Exist In The Given Binary Tree");
        }
        sc.close();
    }
    public static void Printparentandchildnodes(){
        int j=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Number ");
        int num=sc.nextInt();
        boolean f1=false,f2=false;
        int[] Arr=new int[BT.length];
        int k=0;
        Arr[0]=BT[0][1];
        k+=1;
        int s=0;
        for (int i = 0;i< BT.length;) {
            if (BT[i][s+1]<num && BT[i][s+2]!=-1) {
                Arr[k]=BT[BT[i][s+2]][s+1];
                k++;
                i=BT[i][s+2];
            }else if (BT[i][s+1]>num && BT[i][s]!=-1) {
                Arr[k]=BT[BT[i][s]][s+1];
                k++;
                i=BT[i][s];
            }else{
                break;
            }
        }
        if (k<2) {
            System.out.println("Parent node Doesn't Exist of number "+num);
        }else{
            System.out.println("Parent Node of "+num+" = "+Arr[k-2]);
        }
        
        for (int i = 0; i < BT.length; i++) {
            if (BT[i][j+1]==num && BT[i][j]!=-1) {
                System.out.println("Left Child Node = "+BT[BT[i][j]][j+1]);
                f1=true;
            }
            if (BT[i][j+1]==num && BT[i][j+2]!=-1) {
                System.out.println("Right Child Node = "+BT[BT[i][j+2]][j+1]);
                f2=true;
            }
        }
        if (!f2 && !f1) {
            System.out.println("The Entered Number Has Not Any Child Node");
        }else if (!f2) {
            System.out.println("Right child node does not exist of this number in the given Tree");
        }else if (!f1) {
            System.out.println("Left child node does not exist of this number in the given Tree");
        } 
    }
    public static void readandwrite(){
        File myFile;
        Scanner fileread;
        try {
            myFile=new File("d:\\New folder\\SMTP Questions\\xyz.TAB");
            fileread=new Scanner(myFile);
            int i=0;
            while (fileread.hasNextInt() && i<BT.length) {
                BT[i][0]=fileread.nextInt();
                BT[i][1]=fileread.nextInt();
                BT[i][2]=fileread.nextInt();
                i++;
            }
            fileread.close();
        } catch (Exception e) {
            System.out.println("Meter Ghuma hua hai "+e.getLocalizedMessage());
        }
        System.out.println("Table");
        for (int i = 0; i < BT.length; i++) {
            System.out.println("{"+BT[i][0]+","+BT[i][1]+","+BT[i][2]+"}");           
        }
    }
    public static void inorderd_traversal_nodes(int root_index,int[][] Arr){ // LNR
        if(root_index==-1) return;
        inorderd_traversal_nodes(Arr[root_index][0], Arr); // left
        System.out.print(Arr[root_index][1]+",");
        inorderd_traversal_nodes(Arr[root_index][2], Arr);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please Select Any Option From the Following \n1-Print Leaf Nodes\n2-Search a Number In Binary Tree and print it's index\n3-Print Parent And Child Nodes of the any Number\n4-Print the Binary tree using In Order Traversal\n5-Read the Data from File and print ");
        int n=sc.nextInt();
        if (n==1) {
            readandwrite();
            printLN();
        }else if (n==2) {
            readandwrite();
            Searchnumber();
        }else if (n==3) {
            readandwrite();
            Printparentandchildnodes();
        }else if (n==4) {
            readandwrite();
            inorderd_traversal_nodes(0, BT);
        } else if (n==5) {
            readandwrite();
        }
        sc.close();
    }    
}