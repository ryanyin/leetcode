package EditDistance;

/*Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character*/

public class Solution {
	public static void main(String[] args) {
		System.out.println(minDistance("sea","eat"));
	}
	
	//没有考虑有重复字符串的情况
	
	public static int minDistance(String word1, String word2) {
        if(word1.length()==0||word2.length()==0) return Math.max(word1.length(),word2.length());
        int[][] result=new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<=word1.length();i++) result[i][0]=i;
        for(int i=0;i<=word2.length();i++) result[0][i]=i;
        for(int i=1;i<=word1.length();i++){
        	for(int j=1;j<=word2.length();j++){
        		result[i][j]=Math.min(Math.min(result[i-1][j]+1, result[i][j-1]+1), result[i-1][j-1]+(word1.charAt(i-1)==word2.charAt(j-1)?0:1));
        	}
        }
		return result[word1.length()][word2.length()];
    }
}
