package LongestValidParentheses;

import java.util.Stack;

/*Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4. */

public class Solution {
	public static void main(String[] args) {
		longestValidParentheses(")()())");
	}
    public static int longestValidParentheses(String s) {
    	if(s.length()<=1) return 0;
    	int[] temp=new int[s.length()];
//    	Stack<Character> stc=new Stack<Character>();
    	Stack<Integer> index=new Stack<Integer>();
    	for(int i=0;i<s.length();i++){
    		switch (s.charAt(i)) {
			case '(':
				index.push(i);
				break;
			case ')':
				if(index.size()>0){
					temp[i]=1;
					temp[index.pop()]=1;
				}
				break;
			default:
				break;
			}
    	}
    	int count=0;
    	int pre=temp[0];
    	int cur=1;
    	for (int i = 1; i < temp.length; i++) {
			if(temp[i]==pre&&pre==1)
				cur++;
			else{
				cur=1;
			}
			pre=temp[i];
			if(cur>1&&cur>count) count=cur;
		}
		return count;
        
    }
}
