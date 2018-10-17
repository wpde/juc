package demo;

/**
 * 
 * @author cofe
 * @Date 2018Äê8ÔÂ21ÈÕ
 * @Description juc
 * 
 * 
 */
public class VolatileTest extends Thread {

	public static void main(String[] args) {
		ThreadDemo td = new ThreadDemo();
		new Thread(td).start();
		while (true) {
//			synchronized (td) {
				if (td.isFlag()) {
					System.out.println("------------------");
					break;
				}
//			}
		}
		

	}

}

class ThreadDemo implements Runnable {
//	private boolean flag=false;
	private  volatile boolean flag = false;

	@Override
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
		}
		flag = true;
		System.out.println("flag=" + isFlag());

	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}