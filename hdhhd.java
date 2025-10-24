import java.util.*;
import java.io.*;
public class SalesDataAnalyzer {
    static public HashMap<String,Integer> Unique(Scanner read,int menudigit){
        double totalsales=0;
        int total=0;
        Scanner Read=read;
        HashMap<String,Integer>map=new HashMap<>();
        String[] Header=null;
        try {
            if (Read.hasNextLine()) {
                Header=Read.nextLine().split("\t");
            }
            while (Read.hasNextLine()) {
                String line=Read.nextLine();
                String[]Arr=line.split("\t");
                String key=Arr[menudigit-1];
                total=Integer.parseInt(Arr[Arr.length-2])*Integer.parseInt(Arr[Arr.length-1]);
                map.put(key, map.getOrDefault(key, 0)+total);
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getLocalizedMessage());
        }
        return map;
    }
    static public void printtotalsalesamount(Scanner Read){
        Scanner read=Read;
        double totalsales=0;
        try {
            if (read.hasNextLine()) {
                read.nextLine();
            }
            while (read.hasNextLine()) {
                    String line=new String();
                    line=read.nextLine().trim();
                    String[] Arr=new String[6];
                    Arr=line.split("\\s+");
                    int total=Integer.parseInt(Arr[Arr.length-2])*Integer.parseInt(Arr[Arr.length-1]);
                    totalsales+=total;

            }
            read.close();
        } catch (Exception e) {
            System.out.println("Error "+e.getLocalizedMessage());
        }
        System.out.println("The Total Sales are "+totalsales);
    }

    public static void main(String[] args) {
        Scanner read;
        Scanner Read;
        Scanner sc=new Scanner(System.in);
        File Myfile;
        HashMap<String,Integer>map=new HashMap<>();
        int Answer=0;
        try {
            Myfile=new File("c:\\\\Users\\\\TECHNEZO\\\\Downloads\\\\EVE01Sales.txt");
            read=new Scanner(Myfile);
            Read=new Scanner(Myfile) ;
            String line=read.nextLine();
            String[] Header=line.split("\t");
            read.close();
            System.out.println("Tell Me what do You Want to do?");
            for (int i = 0; i < Header.length-1; i++) {
                System.out.println((i+1)+"."+Header[i]+" Wise sum");
            }
            System.out.println(Header.length+".Total Sum Of All sales");
            Answer=sc.nextInt();
            if (Answer==6) {
                printtotalsalesamount(Read);
            }else{
                map=Unique(Read, Answer);
                map.forEach((key,value)->{System.out.println(key+" Sales Are "+value);});
            }
        } catch (Exception e) {
            System.out.println("Error "+e.getLocalizedMessage());
        }
        
    }
}
