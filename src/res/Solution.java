package res;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			System.out.println(reverse(sc.nextInt()));
//			sc.nextLine();
		}*/
		combine(2,2);
	}
	
	/* public static int reverse(int x) {
		 int result=0;
	    boolean posi=true;
	    StringBuilder s=(new StringBuilder(String.valueOf(x))).reverse();
	    
	    if(x<0) {
	    	posi=false;
	    	s.deleteCharAt(s.length()-1);
	    }

	    result=Integer.parseInt(s.toString());
		return posi?result:0-result;
    }*/
	 
	 public static List<List<Integer>> combine(int n, int k) {
	        if(k==0)    return null;
	        if(n<k) return null;
	        List<List<Integer>> result=new ArrayList<List<Integer>>();
	        if(k==1){
	            for(int i=1;i<=n;i++){
	                List<Integer> tem=new ArrayList<Integer>();
	                tem.add(i);
	                result.add(tem);
	            }
	            return result;
	        }
	        
	        result=combine( n-1,  k-1);
	        for(List<Integer> a:result){
	            a.add(n);
	        }
	        result.addAll(combine( n-1,  k));
	        return result;
	        
	    }
}
