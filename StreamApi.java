package in.practice.com;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApi {
	public static void main(String[] args) {
		//1.number starts from '2' in Array
		int input[]= {7,2,3,4,5,21,22,65,44};
	List<String> ls= Arrays.stream(input).boxed().map(e->e.toString()).filter(e->e.startsWith("2")).collect(Collectors.toList());
	System.out.println(ls);
	
	//2.Longest String 
	  String s[] = {"ar","bat","deer","jeg","rajesh","no","rakesh"};
	 String longString=   Arrays.stream(s).reduce((a1,a2)->a1.length() > a2.length() ? a1 : a2).get();
	 System.out.println("2.Longest String - " + longString);
	 
	 //3.first repeated char in String
	 String in="lovevivek";
	       Arrays.stream(in.split(" ")).collect(Collectors.groupingBy(a->a,LinkedHashMap::new,Collectors.counting()));
	             //.entrySet()
	       in.toLowerCase().chars().mapToObj(e->(char)e).collect(Collectors.groupingBy(a->a,LinkedHashMap::new,Collectors.counting()))
	                  ;
	       
	       //4.Most repeated ele in array
	 List<String> lt=Arrays.asList("java","c","python","java","spring");
	   Map<String,Long> m=  lt.stream().collect(Collectors.groupingBy(se->se,Collectors.counting()));
	   Entry<String,Long> ent=m.entrySet().stream().max(Map.Entry.comparingByValue()).get();
	   System.out.println("Most repeating string - " + ent.getKey() + " - repeated times " + ent.getValue());
	   
	   //5.2 strings are Anagram
	   String s1="cheater",s2="teacher";
	   s1=Stream.of(s1.split("")).map(se->se.toLowerCase()).sorted().collect(Collectors.joining());
	   s2=Stream.of(s2.split("")).map(se->se.toLowerCase()).sorted().collect(Collectors.joining());
	   if(s1.equals(s2)) {
		   System.out.println("Both are Anagram");
	   }else {
		   System.out.println("Not");
	   }
	   
	   //6.MergeSort
	    int i1[]= {2,3,6,8,4};
	    int i2[]= {1,7,9,5,0};
	    int[] res=   IntStream.concat(Arrays.stream(i1), Arrays.stream(i2)).sorted().distinct().toArray();
	   System.out.println(Arrays.toString(res));
	   
	   //7.Duplicate characters in string o/p -  [a, v, i, k]
	   String inp="vivek kadiyan";
	  List<String> dupChar= Arrays.stream(inp.split("")).collect(Collectors.groupingBy(st->st,Collectors.counting())).entrySet()
	          .stream().filter(e->e.getValue()>1).map(e->e.getKey()).collect(Collectors.toList());
	  System.out.println("Duplicate Characters - " + dupChar);
	  
	  //8.Sum of given number  o/p - 15
	   int n=12345;
	   Integer sumOfDigits=Stream.of(String.valueOf(n).split("")).collect(Collectors.summingInt(Integer::parseInt));
	   System.out.println("Sum of numbers - " + sumOfDigits);
	  
	   //9.First non-repeated char  o/p - o

	   String sJ="Progrmmpring java".replaceAll("\\s+", "").toLowerCase();
	   System.out.println(sJ);
	 Map<String,Long> mpa= Arrays.stream(sJ.split("")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
	 String firstNonRepeatChar=mpa.entrySet().stream().filter(e->e.getValue()==1).map(e->e.getKey()).findFirst().get();
	 System.out.println("First Non-repeat char- " + firstNonRepeatChar );
	 
	 //10.sum o all evevn numbers   o/p - 14
	   List<Integer> ev=Arrays.asList(1,2,4,7,8,5);
	     int sum=ev.stream().filter(e->e%2==0).mapToInt(Integer::intValue).sum();
	     System.out.println("Sum of even numbers - " + sum);
	     
		//11.Max ele in list  o/p -98
	     List<Integer> maxEle=Arrays.asList(1,27,4,57,98,5);
	      int maxele=maxEle.stream().mapToInt(Integer::intValue).max().getAsInt();
	      System.out.println("Maximum element - " + maxele);
	      
	      //12.Concat all strings  o/p -  apple,ball,cat,doll
	      List<String> concatStr=Arrays.asList("apple","ball","cat","doll");
	    String concat=  concatStr.stream().collect(Collectors.joining(","));
	    System.out.println(concat);
	    
	    //13.convert each string into uppercase and sort them into alphabetical order   o/p - [APPLE, BALL, CAT, DOLL, GITA, JEG]
	    List<String> upper=Arrays.asList("apple","jeg","gita","ball","cat","doll");
	    List<String> upperSort=     upper.stream().map(String::toUpperCase).sorted().collect(Collectors.toList());
	    System.out.println(upperSort);
	    
	    //14.Average    o/p - 3.525  
	     List<Double> doble=Arrays.asList(1.0,4.6,2.0,6.5);  
	      Double dblVal=  doble.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
	      System.out.println(dblVal);
	      
	      //15.Create a new list that dosen't contain duplicates   o/p --  [apple, ball, cat, jeg, gita, doll]
	      List<String> duplicates=Arrays.asList("apple","ball","cat","jeg","gita","ball","cat","doll");
	      List<String> NoDuplicates=  duplicates.stream().distinct().collect(Collectors.toList());
	      System.out.println(NoDuplicates);
	      
	      //16.check given number exist or not  o/p - true
	      List<Integer> exist=Arrays.asList(1,2,4,7,8,5);
	       boolean result=exist.stream().anyMatch(n1->n1.equals(8));
	       System.out.println(result);
	       
	       //17.Longest string  - o/p - 6
	       List<String> longStr=Arrays.asList("apple","ball","cat","jeg","doll","donkey");
	       int intLen= longStr.stream().mapToInt(String::length).max().getAsInt();
	       System.out.println(intLen);
	       
	       //18.2nd smallest string   o/p - 11
	       List<Integer> small=Arrays.asList(11,32,14,57,88,5);
	      Integer secSmall=  small.stream().distinct().sorted().skip(1).findFirst().get();
	       System.out.println(secSmall);
	       
	       //19.Intersection of 2 lists    o/p - [2, 7, 5]
	       List<Integer> l1=Arrays.asList(1,2,4,7,8,5);
	       List<Integer> l2=Arrays.asList(2,7,6,5);
	       
	       List<Integer>l3=   l1.stream().filter(l2::contains).collect(Collectors.toList());
	       System.out.println(l3);
	       
	       //20. Even / Odd 
	        int[] oe=new int[] {1,2,3,4,5,6,7,8};
	        System.out.println(Arrays.stream(oe).mapToObj(e->Integer.valueOf(e)).collect(Collectors.groupingBy(t->t%2==0 ? "odd" : "even ")));
	         
	        //21.Even sum & Odd sum
	        Map<String,Integer> eSum=Arrays.stream(oe).boxed()
	        		     .collect(Collectors.groupingBy(e->e%2==0 ? "Even sum " : "Odd sum " ,Collectors.summingInt(Integer::intValue)));
	        System.out.println(eSum);
	        
	        //22.word count
	        String ws= "my name is  my";
	   Map<String,Long> wordCnt=       Arrays.stream(ws.split(" ")).filter(e->Collections.frequency(Arrays.asList(ws.split(" ")), e)>=1)
	            .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
	   System.out.println(wordCnt);
	}

}
