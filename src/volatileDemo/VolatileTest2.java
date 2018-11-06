package volatileDemo;

import java.util.concurrent.atomic.AtomicInteger;

/**  
* @Description: TODO(证明：volatile不保证原子性)  
* @author cofe  
* @date 2018年11月6日  
*    
*/
public class VolatileTest2 extends Thread {
	
//	private static volatile int num;
	private static AtomicInteger num=new AtomicInteger(0);
	public void add() {
		for(int i=0;i<1000;i++) {
//			num++;
			num.incrementAndGet();// num++
		}
		System.out.println(num);
	}
	
	
	public void run() {
		add();
	}
	public static void main(String[] args) {
		VolatileTest2 []t=new VolatileTest2[10];
		for (int i = 0; i < t.length; i++) {
			t[i]=new VolatileTest2();
			t[i].start();
		}
	}
}
