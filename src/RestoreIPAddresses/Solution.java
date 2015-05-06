package RestoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

/*Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter) */

public class Solution {
	public static void main(String[] args) {
		System.out.println(restoreIpAddresses("010010"));
	}
 public static List<String> restoreIpAddresses(String s) {
	 List<String> result= new ArrayList<>();
	 if(s==null||s.length()<4||s.length()>12) return result;
     int i=2;
     while(s.length()-i>6) i++;
     while(i<=6&&i<s.length()){
    	 String a=s.substring(0, i);
    	 String b=s.substring(i, s.length());
    	 List<String> A=restoreIp(a);
    	 List<String> B=restoreIp(b);
    	 if(A.size()>0&&B.size()>0){
    		 for (int j = 0; j < A.size(); j++) {
				for (int p = 0; p < B.size(); p++) {
					result.add(A.get(j)+"."+B.get(p));
				}
			}
    	 }
    	 i++;
     }
	 return result;   
    }
 
 public static List<String> restoreIp(String s){
	 List<String> result= new ArrayList<>();
	 if(s.length()<2||s.length()>6||s==null) return result;
	 for(int i=1;i<s.length();i++){
		 if(isVa(s.substring(0, i))&&isVa(s.substring(i, s.length())))
				 {
			 		result.add(s.substring(0, i)+"."+s.substring(i, s.length()));	 		
				 }
	 }
	 return result;
 }
 
 public static boolean isVa(String s){
	 if(s.length()>1&&s.charAt(0)=='0') return false;
	 int result=Integer.parseInt(s);
	 
	 return result<256&&result>=0;
 }
}
