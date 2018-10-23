package demo;

import java.util.concurrent.ConcurrentHashMap;

/**  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author cofe  
* @date 2018年9月4日  
*    
*/
public class ConcurrentHashMapTest {
	public static void main(String[] args) {
		ConcurrentHashMap<String, String>map=new ConcurrentHashMap<>();
		map.put("1", "concurrent");
		map.put("2", "hello");
	}
}
