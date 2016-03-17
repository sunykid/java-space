package confirm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CoreJava {
	private String mark;
	private Map map ;
	private List list;
	
	public CoreJava(String mark) {
		super();
		this.mark = mark;
		switch (mark) {
		case "A":
			map = new HashMap<>();
			list = new ArrayList();
			break;
		case "B":
			map = new Hashtable<>();
			list = new LinkedList();
			break;
		}
	}

	public static void main(String[] args) {
		new CoreJava("B").putNull();
	}
	
	public void putNull(){

		this.map.put(1,1);
		
		this.list.add(null);
		System.out.println(map);
		System.out.println(list.size());

	}
}
