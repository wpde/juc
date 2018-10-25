package demo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**  
* @Description: 使用callable接口创建线程  
* @author cofe  
* @date 2018年10月25日  
*    
*/
public class CallableTest {
	public static void main(String[] args) {
		CallableT call=new CallableT();
		FutureTask<Integer> future=new FutureTask<>(call);
		try {
			new Thread(future).start();
			System.out.println("main线程执行了");
			System.out.println(future.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class CallableT implements Callable<Integer>{

	/* (non-Javadoc)
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public Integer call() throws Exception {
		System.out.println("call线程执行了");
		int sum=0;
		for (int i = 0; i < 1000; i++) {
			sum+=i;
		}
		return sum;
	}
	
}