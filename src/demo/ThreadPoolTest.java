package demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**  
* @Description: TODO(使用线程池创建线程)  
* @author cofe  
* @date 2018年11月4日  
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