package Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**  
* @Description: TODO(������һ�仰��������������)  
* @author cofe  
* @date 2018��10��26��  
*    
*/
public class LockTest {
	public static void main(String[] args) {
		LockT l1=new LockT();
		new Thread(l1,"1��").start();
		new Thread(l1,"2��").start();
		new Thread(l1,"3��").start();
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
				System.out.println(Thread.currentThread().getName()+ "��ƱΪ��"+--ticket);
			}
		}finally {
			lock.unlock();
		}
	}
	
} 