package volatileDemo;


/**  
* @Description: TODO(volatile关键字)  
* @author cofe  
* @date 2018年11月6日  
*    
*/
public class VolatileTest1 extends Thread{
//	private boolean res=true;
	/**
	 * 每一个线程创建都会建立一个自己的副本，使用volatile修饰后，保证变量在内存间的可见性，不保证原子性
	 */
	private volatile boolean res=true;
	
	public boolean isRes() {
		return res;
	}
	public void setRes(boolean res) {
		this.res = res;
	}

	@Override
	public void run() {
		System.out.println("进入了run方法");
		while(res) {
			
		}
		System.out.println("run方法结束");
	}

	public static void main(String[] args) throws InterruptedException {
		VolatileTest1 t=new VolatileTest1();
		t.start();
		Thread.sleep(2000);
		t.setRes(false);
		System.out.println("res 设置为false");
		System.out.println(t.isRes());
	}
}
