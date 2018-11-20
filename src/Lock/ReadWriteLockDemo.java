package Lock;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**  
* @Description: TODO(¶ÁÐ´Ëø)  
* @author cofe  
* @date 2018Äê11ÔÂ19ÈÕ  
*    
*/
public class ReadWriteLockDemo {
	public static void main(String[] args) {
		ReadWrite rw=new ReadWrite();
		
		
		for(int i=0;i<10;i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					rw.get();
				}
			}).start();
			
			new Thread(new Runnable() {
				@Override
				public void run() {
					rw.set(new Random().nextInt(100));
				}
			}).start();
		}
		
	}
}
class ReadWrite{
	private int num=0;
	private ReadWriteLock lock=new ReentrantReadWriteLock();
	public void get()  {
		try {
			lock.readLock().lock();
			System.out.println(Thread.currentThread().getName()+" :"+"ready to read data");
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName()+" :"+num);
			System.out.println(Thread.currentThread().getName()+" :"+"end to read data");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.readLock().unlock();
		}
		
	}
	
	public void set(int num)  {
		try {
			lock.writeLock().lock();
			System.out.println(Thread.currentThread().getName()+" :"+"ready to write data");
			Thread.sleep(1000);
			this.num=num;
			System.out.println(Thread.currentThread().getName()+" :"+num);
			System.out.println(Thread.currentThread().getName()+" :"+"end to write data");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.writeLock().unlock();
		}
	}
}