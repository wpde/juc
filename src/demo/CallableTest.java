package demo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**  
* @Description: ʹ��callable�ӿڴ����߳�  
* @author cofe  
* @date 2018��10��25��  
*    
*/
public class CallableTest {
	public static void main(String[] args) {
		CallableT call=new CallableT();
		FutureTask<Integer> future=new FutureTask<>(call);
		try {
			new Thread(future).start();
			System.out.println("main�߳�ִ����");
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
		System.out.println("call�߳�ִ����");
		int sum=0;
		for (int i = 0; i < 1000; i++) {
			sum+=i;
		}
		return sum;
	}
	
}