package demo2;

import java.util.Random;

/**  
* @Description: TODO(ThreadLocal)  
* @author cofe  
* @date 2018Äê11ÔÂ3ÈÕ  
*    
*/
public class ThreadLocalTest {
	private static int data=0;
//	private static Map<Thread,Integer> map=new HashMap<Thread,Integer>();
	private static ThreadLocal<Integer> map=new ThreadLocal<>();
	
	public static void main(String[] args) {
		for(int i=0;i<100;i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					int data = new Random().nextInt();
					map.set(data);
					System.out.println(Thread.currentThread().getName()+ " set data :"+data);
					new A().get();
					new B().get();
				}
			}).start();
		}
	}
	static class A{
		void get() {
			int data =map.get();
			System.out.println("A from: "+Thread.currentThread().getName()+ " get data :"+data);
		}
	}
	static class B{
		void get() {
			int data =map.get();
			System.out.println("B from: "+Thread.currentThread().getName()+ " get data :"+data);
		}
	}
}

