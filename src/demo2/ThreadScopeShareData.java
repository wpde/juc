package demo2;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**  
* @Description: TODO(线程范围内共享数据)  
* @author cofe  
* @date 2018年11月1日  
*    
*/
public class ThreadScopeShareData {
	
	private static int data=0;
	private static Map<Thread,Integer> map=new HashMap<Thread,Integer>();
	public static void main(String[] args) {
		for(int i=0;i<300;i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					int data = new Random().nextInt();
					map.put(Thread.currentThread(), data);
					System.out.println(Thread.currentThread().getName()+ " set data :"+data);
					new A().get();
					new B().get();
				}
			}).start();
		}
	}
	static class A{
		void get() {
			int data =map.get(Thread.currentThread());
			System.out.println("A from: "+Thread.currentThread().getName()+ " get data :"+data);
		}
	}
	static class B{
		void get() {
			int data =map.get(Thread.currentThread());
			System.out.println("B from: "+Thread.currentThread().getName()+ " get data :"+data);
		}
	}
}
