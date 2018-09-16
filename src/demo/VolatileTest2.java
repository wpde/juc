package demo;

public class VolatileTest2 extends Thread {
     
     boolean flag = false;
     int i = 0;
     
     public void run() {
         while (!flag) {
             i++;
         }
     }
     
     public static void main(String[] args) throws Exception {
         VolatileTest2 vt = new VolatileTest2();
         vt.start();
         Thread.sleep(2000);
         vt.flag = true;
         System.out.println("stope" + vt.i);
     }
 }