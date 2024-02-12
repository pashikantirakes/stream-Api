package in.practice.com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Java_Interview_Coding {
  public static void main(String[] args) {
	  //1.
	  String str="leetcode";
//System.out.println(reverse(str));
	//2.
	  String s1="racecar";
	  //System.out.println(palindrome(s1));

	  //3.
	 String a1="cart",a2="tarc";
	// System.out.println(a1 + " , " +  a2 +  " - " + " are  " +anagram(a1,a2));
	 //4.
	 int[] m1= {1,3,5,7,9,10},m2= {2,4,6,8};
	int[] na= mergedSortedArryay(m1,m2);
	//System.out.println(Arrays.toString(na));
	//5.
	int g=6;
	int fib=fibonacciNumber(g);
	//System.out.println("Fibonacci series "  + fib);
	
	String avg[][]= {{"ram","50"},{"lav","40"},{"lav","70"},{"lav","100"},{"lav","80"},{"janu","50"}};
	int stdAvg=  findAvg(avg);
	//System.out.println(stdAvg);
	
	
	//7.Find number is divisible by all digits
	 // eg. 124 id divisible by 1,2,4
	 int divNum=121;
	int finalResult= findAllDivisbleDigits(divNum);
	System.out.println("Digits divisble by number " + finalResult);
	
	//8.Max Product of subArray
	 int num[]= {2,3,-2,-5,6,-1,4};
	 int resi=findMaxSubArray(num);
	 System.out.println("Max Sub-Array Product Result - " +  resi);
	/* 
	 *9. count the no of zeros and ones using any inbuilt function
	 */
	int[] one=new int[] {1,1,0,1,0,1,1,0};
	int sum=0;
	for(int i : one) {
		sum+=i;
	}
	
	/*
	 * 10.Sliding algo to find max sum array average 
	 * [1,2,4,6,3,5,8] ; k=4
	 * 1st - it will take  1,2,4,6 and sum=13
	 * 2nd - 13-1+3=15
	 *  till on last 4 digits   then Math.max(maxSum,sum);
	 */
	   int avgSub[] = {1,12,-5,-6,50,3};
	   int k=4;
	   double d= findSubArrayAverage(avgSub,k);
	   System.out.println("Max SubArray Average  - " + d);
	  
	   /*
	    *11. Repeating String 
	    * "abab" n= 10 , how many times a will repeat ? output=5 abab(a=2)/abab(a=2)/ab(a=1)
	    * 
	    */
	   String repeatString="abab";
	   int repeatedTimes=10;
	 int result=repeatTheString(repeatString,repeatedTimes);
	 System.out.println("Repeated times of character - " + result);
	   System.out.println("---------------------------");
	   
	   /*
	    * 12.find 1st and last position in sorted array
	    *  eg.[3,4,5,8,8,9] output=[3,4];
	    */
	   int [] fl= {3,4,5,8,7,9,8};
	      int target=8;
	     int[] flResult= findFirstAndLastPosition(fl,target);
	     System.out.println("First & Last position - " + Arrays.toString(flResult));
	     
	     /*13.
	      * Find 1st occurance in string
	      * s1="abcsadefg",s2="sad"; output=3rd position s2 will start. 
	      *    
	      */
	     String str1="aadsadbcsadeg",str2="sad";
	        int result1=findFirstOccurance(str1,str2);
	        System.out.println("First Occurance of s2 letter will start from index - " + result1);

	//System.out.println("count of 1s " + sum);
	//System.out.println("Count of zeros " + (one.length-sum));
	
	int[] equalPair= {15,12,4,16,9,8,24,0};
	int asum=24;
	Map<Integer,Integer> map=new HashMap<>();
	for(int i=0;i<equalPair.length-1;i++) {
		/* 
		 * map puts 15,12,4,16
		 * next iteration it will check 24-9=15;15 will present in map,so containesKey is true and 24-9=15(key),value=9 ==> 15+9=24;
		 * same 24-8=16 .
		 */
		if(map.containsKey(asum-equalPair[i])) {
			System.out.println("Pair found " + (asum-equalPair[i] + " + " + equalPair[i] + " = " + asum));
		}
		map.put(equalPair[i], i);
	}
	
}
private static int findFirstOccurance(String str1, String str2) {
     for(int i=0;i<str1.length()-str2.length()+1;i++) {
    	  // s ==(abcs)
    	 if(str2.charAt(0)==str1.charAt(i)) {
    		 if(str1.substring(i,str2.length()+i).equals(str2)) {
    			 return i;
    		 }
    		 
    	 }
     }
	return -1;
}
/*
 * 1st we create a new arra with size of 2 and insert [-1,-1] values in this after,
 * we traversing an array if we get a arr[i]=target then store that arr[i] address in new created array at 0th place,then we place a 2nd value in 1st place.
 * after we traversing remaining ele we find a target value then we insert 1st position the targeted address in new array{3,4,5,8,6,8,9} target=8
 *  the return address [3,5];  
 */
private static int[] findFirstAndLastPosition(int[] arr, int target) {
	int[] result=new int[2];
	result[0]=-1;
	result[1]=-1;
	for(int i=0;i<arr.length;i++) {
		if(arr[i]==target) {
			if(result[0]==-1) {
				result[0]=i;
			}
			result[1]=i;
		}
	}
	return result;
	
	
}

private static int repeatTheString(String str, int n) {
	int count=0;
	  for(int i=0;i<str.length();i++) {
		  if(str.charAt(i)=='a') {
			  count++; //Here count =2
		  }
	  }
	  count=count*(n/str.length()); // count( )= 2*(10/4)=2*2=4 ; count=4;
	  for(int i=0;i<(n%str.length());i++) {  //10 % 4=2 ( abab => travel upto lessthan 2 it means it goes to 0,1 = ab
		  if(str.charAt(i)=='a') { // if the char i = a ;count ++ ; 4 becomes 5.
			  count++;
		  }
	  }
	return count;

	
}

private static double findSubArrayAverage(int[] a, int k) {
	
	int sum=0;
	for(int i=0;i<k;i++) 
		sum+=a[i];
	
	int maxSum=sum;
	//Start sliding window
	 int start=0,end=k;
	  
	  sum-=a[start];
	  start++;
	  sum+=a[end];
	  end++;
	  
	  maxSum=Math.max(maxSum, sum);
	return (double)(maxSum/k);
}


private static int findMaxSubArray(int[] num) {
	int n=num.length;
	int left=1,right=1;
	int ans=num[0];
	for(int i=0;i<n;i++) {
		left=left==0 ?1 : left;
		right= right==0 ? 1 : right;
		
		//Prefix Product
		left=left*num[i];
		
		//Suffix product  n-1 last position and -i=0 (6-1-0 =5 ele)
		right=right*num[n-1-i];
		ans=Math.max(ans, Math.max(left, right));
	}
	return ans;
}


//eg. 124 id divisible by 1,2,4
private static int findAllDivisbleDigits(int n) {
	     int t=n;
	     int ld=0,count=0;
	     while(t>0) {
	    	 ld=t%10;
	    	 if(ld!=0) {
	    		 if(n%ld==0) {
		    		 count++;
		    	 } 
	    	 }
	    	 
	    	 t=t/10;
	     }
	     return count;
	
}

private static int findAvg(String[][] avg) {
	Map<String,Student> m=new HashMap<>();
	int max=Integer.MIN_VALUE;
	for(String[] s : avg) {
		if(m.containsKey(avg)) {
			Student student=m.get(s[0]);
			m.put(s[0], new Student(s[0],student.marks+ Integer.parseInt(s[1]), student.count+1));
			int marksAverage=(student.marks+Integer.parseInt(s[1]))/(student.count+1);
			max=Math.max(marksAverage, max);
		}else {
			m.put(s[0], new Student(s[0], Integer.parseInt(s[1]), 1));
			max=Math.max(Integer.parseInt(s[1]), max);
		}
	}
	return max;
	
}

private static int fibonacciNumber(int i) {
	if(i<=1)
		return i;
int p=0,f=1;
for(int j=2;j<=i;j++) {
	int curr=p+f;
	p=f;
	f=curr;
	
}
	return f;
}
private static int[] mergedSortedArryay(int[] m1, int[] m2) {
	int merged[]=new int[m1.length+m2.length];
	int i=0,j=0,k=0;
	//Loop through both input arrays until we reach end of them
	while(i<m1.length && j<m2.length) {
		//compare both ele and add the small number to merged array.
		if(m1[i]<m2[j]) {
			merged[k]=m1[i];
			i++;
		}else {
			merged[k]=m2[j];
			j++;
		}
		k++;
	}
	//If remaining are present in i ele add to merged array
		while(i<m1.length) {
			merged[k]=m1[i];
			i++;
			k++;
		}
		//If remaining are present in j ele add to merged array
		while(j<m2.length) {
			merged[k]=m2[j];
			j++;
			k++;
		}
	//return the merged array
	return merged;
	
	
}

private static boolean anagram(String a1, String a2) {
	if(a1.length()!=a2.length())
		return false;
	char[] c1=a1.toLowerCase().toCharArray();
	char[] c2=a2.toLowerCase().toCharArray();
	Arrays.sort(c1);
	Arrays.sort(c2);
	
	return Arrays.equals(c1, c2);
	
}

private static boolean palindrome(String s1) {
	String low=s1.toLowerCase().replaceAll("[a-z]", "");//It remove all non-letter characters.
	for(int i=0,j=s1.length()-1;i<j;i++,j--) {
		if(s1.charAt(i)!=s1.charAt(j)) {
			return false;
		}
	}
	return true;
}

private static String reverse(String str) {
	StringBuilder sb=new StringBuilder();
	for(int i=str.length()-1;i>=0;i--) {
		sb.append(str.charAt(i));
	}
	return sb.toString();
}
}
