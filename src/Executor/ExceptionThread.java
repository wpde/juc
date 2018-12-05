package Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**  
* @Description: TODO(异常逃出任务的run方法)  
* @author cofe  
* @date 2018年11月28日  
*    
*/
public class ExceptionThread implements Runnable {

	@Override
	public void run() {
		throw new RuntimeException();
	}
	
	public static void main(String[] args) {
//		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//		cachedThreadPool.execute(new ExceptionThread());
		
//		无法捕获异常
		try {
			ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
			cachedThreadPool.execute(new ExceptionThread());
		} catch (Exception e) {
			System.out.println("Exception in method");
		}
	}
	
}
