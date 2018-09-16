juc即java.util.concurrent简称


1.volatile
作用：用volatile修饰的变量，线程在每次使用变量的时候，都会读取变量修改后的最新的值（内存可见性）
	 不能保证原子性	
2.Atomic原子类
作用：保证内存可见性和
	 原子性，操作不可分割如：i++（通过cas算法实现）
	