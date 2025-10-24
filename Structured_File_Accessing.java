import java.io.File;
import java.util.*;
public class Structured_File_Accessing {
    static public void Monthlysales(Scanner Read){
        Scanner read=Read;    
        int total;
        int[]monthlysum=new int[12];
        HashMap<String,Integer>map=new HashMap<>();
        try {
            if (read.hasNextLine()) {
                read.nextLine();
            }
            while (read.hasNextLine()) {
                String line=new String();
                line=read.nextLine().trim();
                String[] Arr=new String[6];
                Arr=line.split("\t");
                String Date=Arr[0];
                String[] monthdate=Date.split("-");
                total=Integer.parseInt(Arr[Arr.length-2])*Integer.parseInt(Arr[Arr.length-1]);
                monthlysum[Integer.parseInt(monthdate[1])-1]+=total;
            }
            read.close();
            map.put("January", monthlysum[0]);
            map.put("February", monthlysum[1]);
            map.put("March", monthlysum[2]);
            map.put("April", monthlysum[3]);
            map.put("May", monthlysum[4]);
            map.put("June", monthlysum[5]);
            map.put("July", monthlysum[6]);
            map.put("August", monthlysum[7]);
            map.put("September", monthlysum[8]);
            map.put("October", monthlysum[9]);
            map.put("November", monthlysum[10]);
            map.put("December", monthlysum[11]);
        } catch (Exception e) {
            System.out.println("Error: "+e.getLocalizedMessage());
        }
        System.out.println("Month Name\tTotalsales");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " \t\t " + entry.getValue());
        }
    }
    static public void regionWiseSum(Scanner Read){
        Scanner read=Read;    
        String[] Region={"North","South","East","West"};
        int[] sum=new int[Region.length];
        HashMap<String,Integer>map=new HashMap<>();
        int total;
        try {
            if (read.hasNextLine()) {
                read.nextLine();
            }
            while (read.hasNextLine()) {
                String line=new String();
                line=read.nextLine().trim();
                String[] Arr=new String[6];
                Arr=line.split("\t");
                for (int i = 0; i < sum.length; i++) {
                    if (Arr[1].equalsIgnoreCase(Region[i])) {
                        total=Integer.parseInt(Arr[Arr.length-2])*Integer.parseInt(Arr[Arr.length-1]);
                        sum[i]+=total;
                    }
                }
            }
            read.close();
            for (int i = 0; i < sum.length; i++) {
                map.put(Region[i],sum[i]);
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getLocalizedMessage());
        }
        System.out.println("Region Name\tTotalsales");
        map.forEach((key,value)->{System.out.println(key+"\t\t"+value);});
    }
    static public void productwisesum(Scanner Read){
        Scanner read=Read;    
        String[] product={"Product A","Product B","Product C","Product D"};
        int[] sum=new int[product.length];
        HashMap<String,Integer>map=new HashMap<>();
        int total;
        try {
            if (read.hasNextLine()) {
                read.nextLine();
            }
            while (read.hasNextLine()) {
                String line=new String();
                line=read.nextLine().trim();
                String[] Arr=new String[6];
                Arr=line.split("\t");
                for (int i = 0; i < sum.length; i++) {
                    if (Arr[3].equalsIgnoreCase(product[i])) {
                        total=Integer.parseInt(Arr[Arr.length-2])*Integer.parseInt(Arr[Arr.length-1]);
                        sum[i]+=total;
                    }
                }
            }
            read.close();
            for (int i = 0; i < sum.length; i++) {
                map.put(product[i],sum[i]);
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getLocalizedMessage());
        }
        System.out.println("Product Name\t\tTotalsales");
        map.forEach((key,value)->{System.out.println(key+"\t\t"+value);});
    }
    static public void employewisesum(Scanner Read){
        Scanner read=Read;    
        ArrayList<String>ID=new ArrayList<>();
        HashMap<String,Integer>map=new HashMap<>();
            try {
                if (read.hasNextLine()) {
                read.nextLine();
                }
            while (read.hasNextLine()) {
                String line=new String();
                line=read.nextLine().trim();
                String[] Arr=new String[6];
                Arr=line.split("\t");
                String empId=Arr[2];
                int total=Integer.parseInt(Arr[Arr.length-2])*Integer.parseInt(Arr[Arr.length-1]);
                map.put(empId,map.getOrDefault(empId, 0)+total);       
            }
            read.close();
            } catch (Exception e) {
             System.out.println("Error: "+e.getLocalizedMessage());
            }
            System.out.println("EmployeID\tTotalsales");
            map.forEach((key,value)->{System.out.println(key+"\t\t"+value);});
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
    public static void main(String[] args)throws Exception {
        File  inputfile=new File("c:\\Users\\TECHNEZO\\Downloads\\EVE01Sales.txt");
        Scanner sc=new Scanner(System.in);
        Scanner read=new Scanner(inputfile);
        System.out.println("Menu \nPrint Totalsales(Enter 1)\nEmploye Wise Sales(Enter 2)\nProduct Wise Sales(Enter 3)\nRegin Wise Sales(Enter 4)\nMonthly Sales(Enter 5)");
        int n=sc.nextInt();
        if (n==1) {
           printtotalsalesamount(read); 
        }else if (n==2) {
            employewisesum(read);
        }else if (n==3) {
            productwisesum(read);
        }else if (n==4) {
            regionWiseSum(read);
        }else if (n==5) {
            Monthlysales(read);           
        }
        sc.close();
    }
}