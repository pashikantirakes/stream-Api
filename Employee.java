package in.banking.com;

public class Employee {

	int id;
	String name;
	int age;
    String gender;
    String dept;
    int dateOfJoin;
    String city;
    double salary;
	public Employee(int id, String name, int age, String gender, String dept, int dateOfJoin, String city,double salary) {
		
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.dept = dept;
		this.dateOfJoin = dateOfJoin;
		this.city=city;
		this.salary = salary;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getDateOfJoin() {
		return dateOfJoin;
	}
	public void setDateOfJoin(int dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", dept=" + dept
				+ ", dateOfJoin=" + dateOfJoin + ", city=" + city + ", salary=" + salary + "]";
	}

}
