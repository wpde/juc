package demo;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
	public static void main(String[] args) {
		MyThread mt=new MyThread();
		for (int i = 0; i < 10; i++) {
			Thread t=new Thread(mt);
				t.start();
		}
	}
}

class MyThread implements Runnable{
	
	private volatile int i=1;
//	AtomicInteger at=new AtomicInteger();
	@Override
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		System.out.println(Thread.currentThread().getName()+":"+at.getAndIncrement());
		System.out.println(Thread.currentThread().getName()+":"+i++);
	}
	
}