package synchronizedDemo;


/**  
* @Description: TODO(synchornized中发生了异常)  
* @author cofe  
* @date 2018年11月6日  
*    
*/
public class SyncTest2 {
	
	int i=0;
	
	/**
	 *  synchrnized 修饰的方法发生的异常，如果不进行处理会放弃对象锁
	 */
	public synchronized void m1() {
		System.out.println("m1方法执行");
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			i++;
			System.out.println("i=" +i);
			
			if(i==10) {
				Integer.parseInt("a");
			}
			
			
			/*try {
				if(i==10) {
					Integer.parseInt("a");
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
				System.out.println(" loginfo : i=" +i);
			}*/
		}
	}
	public synchronized void m2() {
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("m2方法执行");
		}
	}
	public static void main(String[] args) {
		SyncTest2 s=new SyncTest2();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				s.m1();
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				s.m2();
			}
		}).start();
		
	}
}
