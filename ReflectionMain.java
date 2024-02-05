package in.ReflectionApi.com;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* 
 * Reflection api is allows to manipulate classes,interfaces,fileds and methods 
 * at runtime and it allows you to perform operations such as invoking methods,accessing fields,and dynamically creating new instances of classes.
 * 
 */
public class ReflectionMain {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Student s=new Student(1, "Rakesh");
		System.out.println(s);
		
		//Get the declared field of the class
		Class<?> className=s.getClass();
		//declared field of the class
		System.out.println("Before Reflection " + className.getName());
		
		Field[] fileds=className.getDeclaredFields();
		for(Field f : fileds) {
			if(f.getName().equals("name")) {
				f.setAccessible(true);
				f.set(s, "joshna");
				
			}
		}
		System.out.println("After reflection " +s.getName());

		Method[] methods=className.getDeclaredMethods();
			for(Method m : methods) {
				if(m.getName().equals("privateMethod")) {
					m.setAccessible(true);
					m.invoke(s,"This is private method");
				}
				if(m.getName().equals("isAmPrivate")){
				  m.setAccessible(true);
				  m.invoke(s, args);
				}
		}
 	}

}
