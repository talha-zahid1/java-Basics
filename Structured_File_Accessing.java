import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class Structured_File_Accessing {
    static public void daywise(Scanner Read){
        Scanner read=Read;    
        int total;
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
                LocalDate day = null;
                try {
                    day = LocalDate.parse(Date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                } catch (Exception e1) {
                    try {
                        day = LocalDate.parse(Date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    } catch (Exception e) {
                        day = LocalDate.parse(Date, DateTimeFormatter.ofPattern("d-MM-yyyy"));
                    }   
                }
                String dayname=day.format(DateTimeFormatter.ofPattern("EEEE"));
                total=Integer.parseInt(Arr[Arr.length-2])*Integer.parseInt(Arr[Arr.length-1]);
                map.put(dayname,map.getOrDefault(dayname, 0)+total);
            }
            read.close();
        } catch (Exception e) {
            System.out.println("Error: "+e.getLocalizedMessage());
        }
        System.out.println("Day Name\tTotalsales");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " \t\t " + entry.getValue());
        }

    }
    static public void Monthlysales(Scanner Read){
        Scanner read=Read;    
        int total;
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
                LocalDate day=LocalDate.parse(Date);
                String dayname=day.format(DateTimeFormatter.ofPattern("EEEE"));
                String[] monthdate=Date.split("-");
                total=Integer.parseInt(Arr[Arr.length-2])*Integer.parseInt(Arr[Arr.length-1]);
                LocalDate date=LocalDate.of(Integer.parseInt(monthdate[2]),Integer.parseInt(monthdate[1]), Integer.parseInt(monthdate[0]));
                String monthname=date.format(DateTimeFormatter.ofPattern("MMMM"));
                map.put(monthname,map.getOrDefault(monthname, 0)+total);
            }
            read.close();
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
                total=Integer.parseInt(Arr[Arr.length-2])*Integer.parseInt(Arr[Arr.length-1]);
                map.put(Arr[1], map.getOrDefault(Arr[1], 0)+total);
            }
            read.close();
        } catch (Exception e) {
            System.out.println("Error: "+e.getLocalizedMessage());
        }
        System.out.println("Region Name\tTotalsales");
        map.forEach((key,value)->{System.out.println(key+"\t\t"+value);});
    }
    static public void productwisesum(Scanner Read){
        Scanner read=Read;    
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
                total=Integer.parseInt(Arr[Arr.length-2])*Integer.parseInt(Arr[Arr.length-1]);
                map.put(Arr[3], map.getOrDefault(Arr[3],0)+total);
            }
            read.close();
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
        System.out.println("Menu \nPrint Totalsales(Enter 1)\nEmploye Wise Sales(Enter 2)\nProduct Wise Sales(Enter 3)\nRegin Wise Sales(Enter 4)\nMonthly Sales(Enter 5)\nDay Wise Sum(Enter 6)");
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
        }else if (n==6) {
            daywise(read);
        }
        sc.close();
    }
}