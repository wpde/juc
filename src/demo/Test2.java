package demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author cofe  
* @date 2019年5月18日  
*    
*/
public class Test2 {
	//题目:子线程循环3次，接着主线程循环5次，接着又子线程3次，主线程5次，如此执行10次
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
					System.out.println(Thread.currentThread().getName()+",Sub线程第 " + i +"次执行" + num);
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
					System.out.println(Thread.currentThread().getName()+",Main线程第 " + i +"次执行" + num);
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

