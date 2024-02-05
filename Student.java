package in.ReflectionApi.com;

public class Student {
	private int id;
	private String name;
	
	public Student() {

}
	public Student(int no,String userName) {
		this.id=no;
		this.name=userName;
	}
       public void setId(int id) {
    	   this.id=id;
       }
       public void setName(String name) {
    	   this.name=name;
       }
       public Integer getId() {
    	   return id;
       }
       public String getName() {
    	   return name;
       }
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
       private void privateMethod(String x) {
    	   System.out.println("Private method " + x);
       }
       private static void isAmPrivate() {
    	   System.out.println("Hi i am private method");
       }
}