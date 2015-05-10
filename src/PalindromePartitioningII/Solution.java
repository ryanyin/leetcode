package PalindromePartitioningII;

/*Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.*/ 

public class Solution {
    public int minCut(String s) {
    	int [][] temp=new int[s.length()][s.length()];
    	for(int i=0;i<temp.length;i++) temp[i][i]=i;
    	
		return 0;
        
    }
}
