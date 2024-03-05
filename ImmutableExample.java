package in.immutable.com;

import java.util.HashMap;
import java.util.Map;

/*
 * Declare class as final and fields as private and final.Because to restrict the data members must declare as private
 *  and the value cannot be changed after object creation.
 *  A Parameterized con.should initialize all the fields perform a deep copy so that data members can't be modified with an obj ref.
 *  Deep copy of objects should be performe in the getter()s,to return a copy rather than returning actual object ref.
 */
public final class ImmutableExample {
	
	private final String name;
	private final String id;
	private final Map<String,String> dataMap;
	
private	ImmutableExample(String name,String id,Map<String,String> dataMap) {
		this.name=name;
		this.id=id;
		Map<String,String> tempMap=new HashMap<>();
		for(Map.Entry<String, String> entry : dataMap.entrySet()) {
			tempMap.put(entry.getKey(), entry.getValue());
		}
		this.dataMap=tempMap;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public Map<String, String> getDataMap() {
		Map<String,String> tempMap=new HashMap<>();
		for(Map.Entry<String, String> entry : dataMap.entrySet()) {
			tempMap.put(entry.getKey(), entry.getValue());
		}
		return tempMap;
	}
	public static void main(String[] args) {
		Map<String,String> m=new HashMap<>();
		m.put("one", "1");
		m.put("two", "2");
		ImmutableExample i=new ImmutableExample("rakesh", "123",m);
		
		System.out.println(i.getId());
		System.out.println(i.getName());
		System.out.println(i.getDataMap());
		
		m.put("three", "3");
		System.out.println(i.getDataMap());
		
	}

}
