package Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author cofe  
* @date 2018年10月26日  
*    
*/
public class LockTest {
	public static void main(String[] args) {
		LockT l1=new LockT();
		new Thread(l1,"1号").start();
		new Thread(l1,"2号").start();
		new Thread(l1,"3号").start();
	}
}
class LockT implements Runnable{
	private int ticket=1000;
	private Lock lock=new ReentrantLock();
	
	@Override
	public void run() {
		lock.lock();
		try {
			while(true) {
				if(ticket>0)
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+ "余票为："+--ticket);
			}
		}finally {
			lock.unlock();
		}
	}
	
} 