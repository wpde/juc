package demo;

import java.util.concurrent.CountDownLatch;

/**  
* @Description: TODO(������һ�仰��������������)  
* @author cofe  
* @date 2018��10��23��  
*    
*/
public class CountDownLatchTest {
	
	public static void main(String[] args) {
		CountDownLatch count =new CountDownLatch(5);
		MyThreadForConunt t=new MyThreadForConunt(count );
		int begin=(int) System.currentTimeMillis();
		for (int i = 0; i < 5; i++) {
			new Thread(t).start();
		}
		try {
			count.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int end =(int) System.currentTimeMillis();
		System.out.println("����ʱ�� " + (end -begin));
	}
}

class MyThreadForConunt implements Runnable{

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	private CountDownLatch count;
	
	public MyThreadForConunt(CountDownLatch count) {
		this.count=count;
	}
	@Override
	public void run() {
		try {
			for (int i = 0; i < 1000; i++) {
				if(i%2 ==0) {
					System.out.println(i);
				}
			}
		}finally{
			count.countDown();
		}
		
	}
	
}