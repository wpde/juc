package demo;


/**  
* @Description: TODO(线程之间通信)  
* @author cofe  
* @date 2018年11月21日  
*    
*/
public class TradtionThreadCommunication {
	
	//题目:子线程循环3次，接着主线程循环5次，接着又子线程3次，主线程5次，如此执行10次
	public static void main(String[] args){
		Task task=new Task();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					task.Ch(i);
				}
			}
		}).start();
		for(int i=0;i<10;i++) {
			task.Fa(i);
		}
	}
}

class Task{
	private boolean res=false;
	public synchronized void Ch(int j){
		//while ?
		if(res) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int i=0;i<3;i++) {
			System.out.println("sub thread sequence of " + i + ",loop of " + j);
		}
		res=true;
		this.notify();
	}
	
	public synchronized void Fa(int j) {
		if(!res) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int i=0;i<5;i++) {
			System.out.println("main thread sequence of " + i + ",loop of " + j);
		}
		res=false;
		this.notify();
	}
}