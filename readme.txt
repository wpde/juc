juc即java.util.concurrent简称

1.volatile
作用：用volatile修饰的变量，线程在每次使用变量的时候，都会读取变量修改后的最新的值（内存可见性）
	 不能保证原子性	
	 
2.Atomic原子类
作用：保证内存可见性和
	 原子性，操作不可分割如：i++（通过cas算法实现）

3.concurrentHashMap:concurrent包提供的并发容器类来改进同步容器性能
	采用“锁分段”机制，jdk1.8之后采用CAS算法实现

4.countDownLatch闭锁
作用：在完成一组其他线程操作之前，允许一个或多个线程一直等待
			