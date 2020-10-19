package Contest.Contest33.Problem2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
 
public class main1 {
	 public static String printMinNumber(int a[]){
		 ArrayList<Integer> list=new ArrayList<>();
		 for(int i=0;i<a.length;i++){
			 list.add(a[i]);
		 }
		 Collections.sort(list,new Comparator<Integer>() {
			 @Override
			public int compare(Integer o1, Integer o2) {
				 String s1=o1+"";//一个整数加一个字符串会自动转换成字符串
				 String s2=o2+"";
				 return s1.compareTo(s2);
			}
		});
		 String s="";
		 for(int num:list){
			 s=s+num;
		 }
		 return s;
	 }
     public static void main(String[] args) {
		 int a[]={321,321,321};
		 String s=printMinNumber(a);
		 System.out.println(s);
	}
}