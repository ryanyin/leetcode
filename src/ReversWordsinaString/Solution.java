package ReversWordsinaString;

/*Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space. */

public class Solution {
	  public String reverseWords(String s) {
	        String[] result=s.trim().split(" +");
	        StringBuilder temp=new StringBuilder();
	        for (int i = result.length-1; i >=0; i--) {
	        	temp.append(result[i]);
	        	if(i>0) temp.append(" ");
			}
	        return temp.toString();
	    }
}
