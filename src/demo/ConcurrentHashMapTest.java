package demo;

import java.util.concurrent.ConcurrentHashMap;

/**  
* @Description: TODO(������һ�仰��������������)  
* @author cofe  
* @date 2018��9��4��  
*    
*/
public class ConcurrentHashMapTest {
	public static void main(String[] args) {
		ConcurrentHashMap<String, String>map=new ConcurrentHashMap<>();
		map.put("1", "concurrent");
		map.put("2", "hello");
	}
}
