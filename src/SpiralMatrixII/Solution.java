package SpiralMatrixII;

/*Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,
You should return the following matrix:

[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/

public class Solution {
	public static void main(String[] args) {
		int[][] a=generateMatrix(3);
		System.out.println("------");
	}
    public static  int[][] generateMatrix(int n) {
    	int[][] result=new int[n][n];
    	int rb=0,re=n-1,cb=0,ce=n-1;
    	int num=0;
    	while(rb<=re&&cb<=ce){
    		for(int i=cb;i<=ce;i++){
    			result[rb][i]=++num;
    		}
    		rb++;
    		for(int i=rb;i<=re;i++)
    			result[i][ce]=++num;
    		ce--;
//    		if(rb<=re){
    			for(int i=ce;i>=cb;i--)
    				result[re][i]=++num;
    			re--;
//    		}
    		
//    		if(cb<=ce){
    			for(int i=re;i>=rb;i--)
    				result[i][cb]=++num;
    			cb++;
//    		}
    	}
		return result;
        
    }
}
