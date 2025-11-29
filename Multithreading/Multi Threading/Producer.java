// public class Producer extends Thread{
//     company c;
//     Producer (company c){
//       this.c=c;
//     }
//     public void run() {
//       int i=1;
//       while (true) {
//         c.Producer(i);
//         try {
//             Thread.sleep(1000);
//         } catch (Exception e) {
//             // TODO: handle exception
//         }
//         i++;
//       }
    
//   }
    
// }
public class Producer extends Thread{
  company c;
  Producer(company c)
  {
    this.c=c;
  }
public void run(){
  int i=1;
  while (true) {
    c.Produce(i);
    try {
      Thread.sleep(1000);
    } catch (Exception e) {
      // TODO: handle exception
    }
    i++;
  }
}
  
}