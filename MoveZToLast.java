package in.string.com;

public class MoveZToLast {
	public static void main(String[] args) {
		int[] n= {1,0,1,1,0,0,1,0,1};
		int l=n.length;
		moveZeros(n,l);
	}

	private static void moveZeros(int[] in, int l) {
		int counter=0;
		for(int i : in) {
			if(in[i]==1) {
				counter++;
			}
		}
		for(int i=0;i<counter;i++) {
			in[i]=1;
		}
		for(int i=counter;i<l;i++) {
			in[i]=0;
		}
		for(int num:in ) {
			System.out.println(num);
		}
	
	// 2. No extra space
	 for(int i=0;i<n;i++) {
			 if(num[i]==0) {
				 na[k++]=num[i];
			 }
		 }
		while(k<n) {
			 na[k++]=1;
		}
		 for(int i=0;i<n;i++) {
			 System.out.println(na[i]); 
			 
		 }  
	//___________________________________________________________________
	//3.In given array only we swapping ele...	 
	 int[] num= {1,0,1,1,0,0,1,0};
		 int n=num.length;
		 int k=0,l=num.length-1;
		 while(k<l) {
			 if(num[k]==1 && num[l]==0) {
				 int t=num[k];
				 num[k]=num[l];
				 num[l]=t;
				 k++;
				 l--;
			 }else if(num[k]==0){
				 k++;
			 }else {
				 l--;
			 }
		 }
		  
		  for(int i=0;i<n;i++) {
			  System.out.print(num[i]+" ");
		  }

}
