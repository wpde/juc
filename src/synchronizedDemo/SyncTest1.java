package synchronizedDemo;


/**  
* @Description: TODO(synchornized 修饰的方法是可以传递的)  
* @author cofe  
* @date 2018年11月6日  
*    
*/
public class SyncTest1 {
	
	public synchronized void m1() {
		System.out.println("m1");
		m2();
	}
	
	public synchronized void m2() {
		System.out.println("m2");
		m3();
	}
	
	public synchronized void m3() {
		System.out.println("m3");
	}
	public static void main(String[] args) {
		SyncTest1 s=new SyncTest1();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				s.m1();
			}
		}).start();
	}
}
