package Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**  
* @Description: TODO(�쳣�ӳ������run����)  
* @author cofe  
* @date 2018��11��28��  
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
		
//		�޷������쳣
		try {
			ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
			cachedThreadPool.execute(new ExceptionThread());
		} catch (Exception e) {
			System.out.println("Exception in method");
		}
	}
	
}
