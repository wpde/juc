package demo2;


/**  
* @Description: TODO(���߳�֮�乲������)  
* @author cofe  
* @date 2018��11��3��  
*    
*/
public class MultiThreadShareData {
	
	public static void main(String[] args) {
		

		Data data=new Data();
		data.num=100;
			for(int i=0;i<2;i++) {
				new Thread(new Thread1(data)).start();
				new Thread(new Thread2(data)).start();
			}
		
		
	}
}
class Thread1 implements Runnable{
	
private Data data;
	
	
	public Thread1(Data data) {
		super();
		this.data = data;
	}


	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		data.increment();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}}

class Thread2 implements Runnable{
	private Data data;
	
	
	public Thread2(Data data) {
		super();
		this.data = data;
	}


	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		data.decrement();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}}

class Data{
	int num=0;
	public synchronized void increment() {
		num++;
		System.out.println(Thread.currentThread().getName()+"ִ��increment������"+" ֵΪ�� "+num);
	}
	
	public synchronized void decrement() {
		num--;
		System.out.println(Thread.currentThread().getName()+"ִ��decrement������"+" ֵΪ�� "+num);
	}
}