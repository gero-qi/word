package db.config;

import java.util.LinkedHashMap;
import java.util.Map;

public class DBbook {
	private static Map<String,Book> map = new LinkedHashMap<String,Book>();
	static{
		map.put("1",new Book("1","java开发"));
		map.put("2", new Book("2","java设计")	);
		map.put("3", new Book("3","java吃饭"));
		map.put("4", new Book("4","java 学了不困"));
		
	}
	public static Map<String,Book> getAll(){
		return map;
	}
}
