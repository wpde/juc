package demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**  
* @Description: TODO(������һ�仰��������������)  
* @author cofe  
* @date 2019��5��18��  
*    
*/
public class Test2 {
	//��Ŀ:���߳�ѭ��3�Σ��������߳�ѭ��5�Σ����������߳�3�Σ����߳�5�Σ����ִ��10��
	public static void main(String[] args) {
		MyTask myTask=new MyTask();

		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					myTask.sub(i+1);
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					myTask.main(i+1);
				}
			}
		}).start();
	}
}
class MyTask {
	Lock lock=new ReentrantLock();
	Condition condition=lock.newCondition();
	boolean flag =true;
	public void sub(int num) {
		lock.lock();
		try {
			if(flag) {
				for(int i=1;i<=3;i++) {
					System.out.println(Thread.currentThread().getName()+",Sub�̵߳� " + i +"��ִ��" + num);
				}
				flag=false;
				condition.signal();
			}
			condition.await();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			lock.unlock();
		}
	}
	
	public void main(int num) {
		lock.lock();
		try {
			if(!flag) {
				for(int i=1;i<=5;i++) {
					System.out.println(Thread.currentThread().getName()+",Main�̵߳� " + i +"��ִ��" + num);
				}
				flag=true;
				condition.signal();
			}
			condition.await();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		
	}
	
}

