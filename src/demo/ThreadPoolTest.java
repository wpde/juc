package demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**  
* @Description: TODO(ʹ���̳߳ش����߳�)  
* @author cofe  
* @date 2018��11��4��  
*    
*/
public class ThreadPoolTest {
	public static void main(String[] args) {
		ExecutorService pool=Executors.newCachedThreadPool();
		pool.execute(new PoolR());
	}
}
class PoolR implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
	
}