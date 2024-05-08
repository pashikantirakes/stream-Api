package in.example.com;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class CompressGivenString {
	public static void main(String[] args) {
		 stringCompression("aaabbbcc");
		 stringCompression("aabbbcccc");
		 stringCompression("abc");
	}

	private static void stringCompression(String str) {
		
		System.out.println("Given String " + str);
	String[] s1=str.split("");
	LinkedHashSet<String> set=new LinkedHashSet<>(Arrays.asList(s1));
	String[] newStr=new String[set.size()];
	newStr=set.toArray(newStr);
	String res="";
	for(int i=0;i<newStr.length;i++) {
		int cnt=0;
		for(int j=0;j<s1.length;j++) {
			if(newStr[i].equals(s1[j])) {
				cnt++;
			}
		}
		res+=newStr[i]+cnt;
	}
	System.out.println(res);
	
	}
	
}
