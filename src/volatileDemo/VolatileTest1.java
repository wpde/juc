package volatileDemo;


/**  
* @Description: TODO(volatile�ؼ���)  
* @author cofe  
* @date 2018��11��6��  
*    
*/
public class VolatileTest1 extends Thread{
//	private boolean res=true;
	/**
	 * ÿһ���̴߳������Ὠ��һ���Լ��ĸ�����ʹ��volatile���κ󣬱�֤�������ڴ��Ŀɼ��ԣ�����֤ԭ����
	 */
	private volatile boolean res=true;
	
	public boolean isRes() {
		return res;
	}
	public void setRes(boolean res) {
		this.res = res;
	}

	@Override
	public void run() {
		System.out.println("������run����");
		while(res) {
			
		}
		System.out.println("run��������");
	}

	public static void main(String[] args) throws InterruptedException {
		VolatileTest1 t=new VolatileTest1();
		t.start();
		Thread.sleep(2000);
		t.setRes(false);
		System.out.println("res ����Ϊfalse");
		System.out.println(t.isRes());
	}
}
