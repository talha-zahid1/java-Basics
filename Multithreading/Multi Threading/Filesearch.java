import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Filesearch {
    public static void main(String[] args)throws Exception {
        File Myfile=new File("d:\\New folder (2)");
        File[] list=Myfile.listFiles();
        ExecutorService service=Executors.newFixedThreadPool(5);
        for (File file : list) {
            File Currentfile=file;
            service.submit(()->{
                try {
                        Scanner Filetoread=new Scanner(Currentfile); 
                        while (Filetoread.hasNextLine()) {
                            String words=new String();
                            words=Filetoread.nextLine();
                            String[] tokens=words.split(" ");
                            for(int i=0;i<tokens.length;i++){
                                if(tokens[i].equalsIgnoreCase("columns")){
                                    System.out.println("columns Found in "+file.getName());                                
                                }
                            }
                        }
                        } catch (Exception e) {
                            // TODO: handle exception
                        }
                    });
        }
        service.shutdown();
    }    
}
