package in.banking.com;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import in.Employeecom.Emp;


public class EmpMain {
	public static void main(String[] args) {
		List<Employee>ls=Arrays.asList(new in.banking.com.Employee(1, "rakesh", 28, "male", "java", 2024, "hyd", 5000.0),
				new Employee(2, "naresh", 25, "male", "python", 2020, "chennai", 35000.0),
				new Employee(3, "leela", 22, "female", "java", 2022, "hyd", 12000.0),
				new Employee(4, "rahim", 18, "male", "tester", 2019, "banglore", 25000.0),
				new Employee(5, "vasavi", 29, "female", "mnc", 2021, "vizag", 13000.0),
				new Employee(6, "rakesh", 25, "male", "python", 2020, "hyd", 11000.0)
				);
     //1.group the emp. by city
	Map<String, List<Employee>> a= 	ls.stream().collect(Collectors.groupingBy(Employee::getCity,Collectors.toList()));
    System.out.println(a);
    System.out.println("--------------------");
    
    
//2.group the employess by age
      Map<Integer, List<Employee>> b=ls.stream().collect(Collectors.groupingBy(Employee::getAge,Collectors.toList()));
      System.out.println("2.By age - " + b);
      System.out.println("--------------------");
      
      
      //3.Count of male and female employees
      Map<String, Long> c=  ls.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
      System.out.println("3.Count of male and females " + c);
      System.out.println("--------------------");
      
      
      //4.Print all dept name
      System.out.println("4.Print all dept name");
    ls.stream().map(Employee::getDept).distinct().forEach(System.out::println);
    System.out.println("--------------------");
    
    
    //5.print age > 25
    System.out.println("5.print age > 25");
    ls.stream().filter(e->e.getAge()>25).collect(Collectors.toList()).forEach(System.out::println);
    System.out.println("--------------------");

    System.out.println("6.max age");
   Employee opt=   ls.stream().max(Comparator.comparing(Employee::getAge)).get();
      OptionalInt opt1=ls.stream().mapToInt(Employee::getAge).max();
      if(opt1.isPresent())
    	  System.out.println("Max age - " + opt1.getAsInt());
   System.out.println(opt.getName());
   System.out.println("--------------------");

   System.out.println("7.print avg age of male and female");
  Map<String,Double> avgAge= ls.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getAge)));
  System.out.println(avgAge);
  System.out.println("--------------------");
  
  
  System.out.println("8.Print no.of emp in each dept ");
 Map<String,Long> dep= ls.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.counting()));
  System.out.println("No of employees in each dept");
  for(Map.Entry<String, Long> map : dep.entrySet()) {
	  System.out.println(map.getKey() + " - " + map.getValue());  
  }
  System.out.println("--------------------");
  
  
System.out.println("9.Find oldest Employee");
Optional<Employee> oldEmp=ls.stream().max(Comparator.comparing(Employee::getAge));
System.out.println(oldEmp.get().getName());
System.out.println(oldEmp.get().getAge());

System.out.println("--------------------");


System.out.println("10.Young emp ");
Optional<Employee> youngEmp=ls.stream().min(Comparator.comparing(Employee::getAge));
System.out.println(youngEmp.get().getName());
System.out.println(youngEmp.get().getAge());

System.out.println("-----------------------------");


System.out.println("11. age > 30 and age<30");
 Map<Boolean,List<Employee>> bool=ls.stream().collect(Collectors.partitioningBy(e->e.getAge()>25));
 Set<Map.Entry<Boolean,List<Employee>>> set=bool.entrySet();
 
 for(Map.Entry<Boolean,List<Employee>> empSet : set) {
	 if(Boolean.TRUE.equals(empSet.getKey())) {
		 System.out.println("Employees greater than 25 " + empSet.getValue());
	 }else {
		 System.out.println("Employees less than 25 " + empSet.getValue());
	 }
 }
 System.out.println("-----------------------------");
 
 
 System.out.println("12.Find Dept highest no.of employees");
 Map.Entry<String, Long> high=ls.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.counting()))
		 .entrySet().stream().max(Map.Entry.comparingByValue()).get();
 System.out.println("Max no.of Employees " + high.getKey() + " - " + high.getValue());
 System.out.println("-----------------------------");
 
 
System.out.println("13.Testing dept");
Optional<Employee> tester=ls.stream().filter(e->e.getDept().equalsIgnoreCase("tester")).findAny();
if(tester.isPresent())
	System.out.println(tester.get().getName());
tester.ifPresent( e->System.out.println("Department from tester - " + tester.get().getName()));
System.out.println("-----------------------------");


System.out.println("14.Distinct dept names");
ls.stream().map(Employee::getDept).distinct().forEach(System.out::println);
System.out.println("-----------------------------");


System.out.println("15.Hyd employees sort by name");
   ls.stream().filter(e->e.getCity().equalsIgnoreCase("hyd")).sorted(Comparator.comparing(Employee::getName))
             .forEach(e->System.out.println(e.getName()));
System.out.println("-----------------------------");


System.out.println("16.no of employees in organization");
    System.out.println("No of employees - " + ls.stream().count() );
System.out.println("-----------------------------");


System.out.println("17.Employees count in every dept");
 Map<String,Long> count=ls.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.counting()));
 System.out.println("Employee count " + count);
System.out.println("-----------------------------");


System.out.println("18.high emp in dept");
  Optional<Map.Entry<String, Long>> highEmp=count.entrySet().stream().max(Map.Entry.comparingByValue());
if(highEmp.isPresent()) {
	System.out.println("Department with highest employee - " + highEmp.get());
}
System.out.println("-----------------------------");


System.out.println("19.Sorting a stream by age and name");
Comparator<Employee> c1=Comparator.comparing(Employee::getName);
Comparator<Employee> c2=Comparator.comparing(Employee::getAge);
ls.stream().sorted(c1.thenComparing(c2)).forEach(System.out::println);
System.out.println("-----------------------------");


System.out.println("20.Highest experience employee");
 Optional<Employee> highExp= ls.stream().sorted(Comparator.comparingInt(Employee::getDateOfJoin)).findFirst();
  System.out.println("Senior employee - " + highExp.get().getName());
 System.out.println("---------------------------");
 
 System.out.println("21.print avg and total salary of org.");
 DoubleSummaryStatistics ds=ls.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
 System.out.println("Avg salary Org - " + ds.getAverage());
 System.out.println("Total salary - " + ds.getSum());
 System.out.println("---------------------------");
 
 System.out.println("22.Print avg salary of each Dept.");
 Map<String,Double> avgSal=ls.stream().collect(Collectors.groupingBy(Employee::getDept,
		 Collectors.averagingDouble(Employee::getSalary)));
 System.out.println(avgSal);
 Set<Entry<String, Double>> set1=avgSal.entrySet();
 for(Map.Entry<String,Double> ent : set1) {
	 System.out.println(ent.getKey() +  " - " + ent.getValue());
 }
 System.out.println("---------------------------");

 System.out.println("23.Find highest sal in dept");
 Optional<Employee> highSal=ls.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).findFirst();
 System.out.println(highSal.get().getName());
 System.out.println(highSal.get().getSalary());
 System.out.println("---------------------------");

 
 System.out.println("24.2nd highest salary");
 Optional<Employee> secHighSal=ls.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).findFirst();
 System.out.println(secHighSal.get().getName());
 System.out.println(secHighSal.get().getSalary());
 System.out.println("---------------------------");
 
 System.out.println("25.nth highest salary");
 int n=4;
 Optional<Employee> op=ls.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(n-1).findFirst();
 System.out.println("2nd highest salary " + op.get().getSalary());
System.out.println("------------------------------");


System.out.println("26.find highest paid salary baesd on the gender");
 Map<String,Optional<Employee>> m1= ls.stream().collect(Collectors.groupingBy(Employee::getGender,
		                    Collectors.maxBy((t1,t2)->(int)(t1.getSalary()-t2.getSalary()))));
 System.out.println("High paid employee based on gender " + m1);
 System.out.println("------------------------------");

 
 System.out.println("27.Lowest paid salary based on gender");
 Map<String,Optional<Employee>> lowPaidGender=ls.stream().collect(Collectors.groupingBy(Employee::getGender,
		                                      // Collectors.minBy((t1,t2)->(int)t1.getSalary()-t2.getSalary())));
		 Collectors.minBy((t1,t2)->(int)(t1.getSalary()-t2.getSalary()))));
 System.out.println(lowPaidGender);
 System.out.println("-----------------------------");
 
 
 System.out.println("28.Sort the employees salary in ASC.Order");
 ls.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).toList().forEach(System.out::println);
 System.out.println("-----------------------------");

 
 System.out.println("29.Sort the employees salary in DESC.Order");
 ls.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).toList().forEach(System.out::println);
 System.out.println("-----------------------------");

 
 System.out.println("30.High sal based on dept");
 System.out.println("Highest salary based on the department " + ls.stream().collect(
		 Collectors.groupingBy(Employee::getDept,
		 Collectors.collectingAndThen(Collectors.toList(),
		 list->list.stream().max(Comparator.comparingDouble(Employee::getSalary))
		 )))
		 );
 System.out.println("-------------------");
 
 
 System.out.println("31.Print list of empl 2nd highest record based on dept");
 System.out.println("Highest 2nd salary dept wise : : \n" + ls.stream().collect(Collectors.groupingBy(Employee::getDept,
		    Collectors.collectingAndThen(Collectors.toList(),
		    		ne->ne.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).findFirst()))));
 System.out.println("-------------------");

 
 System.out.println("32.sort emp sal in each dept in asc order");
  Map<String,Stream<Employee>> l=ls.stream().collect(Collectors.groupingBy(Employee::getDept,
		  Collectors.collectingAndThen(Collectors.toList(),
				  list->list.stream().sorted(Comparator.comparingDouble(Employee::getSalary)))));
  l.forEach((k,v)->{
	  System.out.println(k);
	  System.out.println(v.collect(Collectors.toList()));
  });
  System.out.println("-------------------");
  
  
  System.out.println("33.sort emp sal in each dept in desc order");
  Map<String,Stream<Employee>> desc=ls.stream().collect(Collectors.groupingBy(Employee::getDept,
		  Collectors.collectingAndThen(Collectors.toList(),
				  list->list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()))));
  desc.forEach((k,v)->{
	  System.out.println(k);
	  System.out.println(v.collect(Collectors.toList()));
  });
  System.out.println("-------------------");
  
  
  System.out.println("34.");
	}
	}
