package demo;


/**  
* @Description: TODO(�߳�֮��ͨ��)  
* @author cofe  
* @date 2018��11��21��  
*    
*/
public class TradtionThreadCommunication {
	
	//��Ŀ:���߳�ѭ��3�Σ��������߳�ѭ��5�Σ����������߳�3�Σ����߳�5�Σ����ִ��10��
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