package synchronizedDemo;


/**  
* @Description: TODO(synchronized传入的对象属性被修改)  
* @author cofe  
* @date 2018年11月6日  
*    
*/
public class SyncTest3 {
	
	String str =new String("qwe");
	People  p=new People(1, "cofe");
	/**
	 * synchronized传入字符串对象时，字符串被修改时不能保证同步
	 * 				其他类型对象值被修改不会出现问题
	 */
	public void m1() {
//		synchronized(str){
		synchronized(p){
			try {
				System.out.println("当前线程："+Thread.currentThread().getName() + "开始");
				str="abc";
				p.setName("hello");
				p.setAge(2);
				Thread.sleep(1000);
				System.out.println("当前线程："+Thread.currentThread().getName() + "结束");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		final SyncTest3 s=new SyncTest3();
		for(int i=0;i<15;i++) {
			new	Thread(new Runnable() {
					@Override
					public void run() {
						s.m1();
					}
				}).start();;
		}
	}
}
class People{
	private int age;
	private String name;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public People(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	
}