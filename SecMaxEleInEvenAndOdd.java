package in.example.com;

import java.util.Arrays;

public class SecMaxEleInEvenAndOdd {
	public static void main(String[] args) {
		int a[]={3,2,1,7,5,4};
		  System.out.println(sumofSecondMaximumElement(a));
		  int b[]={-4,-7,-9,-6,-2,-1,1};
		  System.out.println(sumofSecondMaximumElement(b));
		  int c[]=null;
		  System.out.println(sumofSecondMaximumElement(c));
		  //call the methods with valid array input-(contains 2 elements)
		  System.out.println(sumofSecondMaximumElement(new int[]{1,2})); 
	}

	private static int sumofSecondMaximumElement(int[] a) {
		System.out.println("Given List" + Arrays.toString(a));
		if(a==null || a.length<=3) {
			System.out.println("Invalid input:"+"your array is empty or only 2 elements in array");
		   System.out.print("Sum is: ");
			return 0;
		}
		int evenSize=0,oddSize=0;
		for(int i=0;i<a.length;i++) {
			if(i%2==0) {
				evenSize++;
			}
			oddSize++;
		}
		  int[] arrayOfEvenElements=new int[evenSize];
		  int[] arrayOfOddElements=new int[oddSize];
		  
		  int evenCount=0,oddCount=0;
		for(int i=0;i<a.length;i++) {
			if(i%2==0) {
			arrayOfEvenElements[evenCount]=a[i];
			evenCount++;
			}else {
			arrayOfOddElements[oddCount]=a[i];
			oddCount++;
			}
		}
		System.out.println("Array of Even Positioned: "+Arrays.toString(arrayOfEvenElements));
		  System.out.println("Array of Odd Positioned: "+Arrays.toString(arrayOfOddElements));
		  
		  int findFirstMaxInEven=firstMax(arrayOfEvenElements);
		  int findFirstMaxInOdd=firstMax(arrayOfOddElements);
		  int findSecondMaxInEven=secondMax(arrayOfEvenElements,findFirstMaxInEven);
		  int findSecondMaxInOdd=secondMax(arrayOfOddElements,findFirstMaxInOdd);
		  
		  System.out.println("Second maxmium element from array contains even positioned elements: "+findSecondMaxInEven);
		  System.out.println("Second maxmium element from array contains odd positioned elements: "+findSecondMaxInOdd);
		  //to notify result info
		  System.out.print("Sum is: ");
		return findSecondMaxInEven+findSecondMaxInOdd;
	}

	private static int secondMax(int[] arr, int max) {
		 //Initialize secMax for comparison
		  //we can't assume arr[0] as second maximum value because arr[0] might be maximum value
		  //we can't set 0 or -1 as initial value for secMax -because it not suitable for [-4,-9,-2,1] values.
		  //so use atmost minimum value for secMax=Integer.MIN_VALUE(built in variable)
		int secMax=Integer.MIN_VALUE;
		for(int k=0;k<arr.length;k++) {
			//second maximum value-must be less than max value and greater than remaining elements in array
		      //check array value arr[k] is not max value and arr[k]>secMax-arr[k] greater than secMax,then set secMax as arr[k]
		      //arr-[3, 1, 5],max=5
		      //1st iteration-(3>-2147483648&&3!=5)-true-secMax->5
		      //2nd iteration-(1>5&&2!=5)-&&-one of the conditions fail-false-secMax->5
		      //3rd iteration-(5>5&&2!=5)-false-secMax->5
		      //like wise check for Array of Odd Positioned:[2, 7, 4]
			if(arr[k]>secMax && arr[k]!=max) {
				secMax=arr[k];
			}
		}
		return secMax;
	}

	private static int firstMax(int[] a) {
		int max=a[0];
		for(int j=1;j<a.length;j++) {
			if(a[j]>max) {
				max=a[j];
			}
		}
		return max;
	}
 
	
}
