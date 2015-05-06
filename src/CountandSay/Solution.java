package CountandSay;

/*The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n, generate the nth sequence.
1,11,21,1211,111221£¬312211£¬13112221£¬1113213211
Note: The sequence of integers will be represented as a string.*/ 

public class Solution {
	public static void main(String[] args) {
		System.out.println(countAndSay(6));
	}
    public static String countAndSay(int n) {
    	if(n==1) return 1+"";
    	String result="1";
    	int i=1;
    	while(i<n){
    		result=getNextString(result);
    		i++;
    	}
		return result;
        
    }

	public static String getNextString(String result) {
		char temp=result.charAt(0);
		int num=1;
		StringBuilder newString=new StringBuilder();
		for(int j=1;j<result.length();j++){
			if(temp==result.charAt(j))
			{
				num++;
				continue;
			}
			newString.append(num);
			newString.append(temp);
			temp=result.charAt(j);
			num=1;
		}
		newString.append(num);
		newString.append(temp);
		return newString.toString();
	}
}
