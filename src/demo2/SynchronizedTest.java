package demo2;


/**  
* @Description: synchronized关键字使用  
* @author cofe  
* @date 2018年10月29日  
*    
*/
public class SynchronizedTest {
	public static void main(String[] args) {
		new SynchronizedTest().init();;
	}
	
	public void init() {
		Output out=new Output();
		//线程1
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				while(true) {
					out.output1("zhangsan");
				}
			}
		}).start();
		
		//线程2
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				while(true) {
					out.output2("lisi");
				}
			}
		}).start();
		
	}
	class Output{
		public synchronized void output1(String name) {
				for (int i = 0; i < name.length(); i++) {
					System.out.print(name.charAt(i));
				}
				System.out.println();
		}
		public void output2(String name) {
			synchronized (this) {
				for (int i = 0; i < name.length(); i++) {
					System.out.print(name.charAt(i));
				}
				System.out.println();
			}
		}
	}
}
