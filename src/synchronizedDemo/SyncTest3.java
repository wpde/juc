package synchronizedDemo;


/**  
* @Description: TODO(synchronized����Ķ������Ա��޸�)  
* @author cofe  
* @date 2018��11��6��  
*    
*/
public class SyncTest3 {
	
	String str =new String("qwe");
	People  p=new People(1, "cofe");
	/**
	 * synchronized�����ַ�������ʱ���ַ������޸�ʱ���ܱ�֤ͬ��
	 * 				�������Ͷ���ֵ���޸Ĳ����������
	 */
	public void m1() {
//		synchronized(str){
		synchronized(p){
			try {
				System.out.println("��ǰ�̣߳�"+Thread.currentThread().getName() + "��ʼ");
				str="abc";
				p.setName("hello");
				p.setAge(2);
				Thread.sleep(1000);
				System.out.println("��ǰ�̣߳�"+Thread.currentThread().getName() + "����");
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