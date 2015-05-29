package SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

/*Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

You should return [1,2,3,6,9,8,7,4,5].*/ 

public class Solution {
	public static void main(String[] args) {
		int[][] a={{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(spiralOrder(a));
	}
    public static List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> result=new ArrayList<Integer>();
    	if(matrix.length==0||matrix[0].length==0) return result;
    	boolean[][] flag=new boolean[matrix.length][matrix[0].length];
    	int point=1;//1¡ú£¬2¡ý£¬3¡û£¬4¡ü£»
    	int m=0,n=0;
    	for(int i=0;i<matrix.length*matrix[0].length;i++){
    		result.add(matrix[m][n]);
    		flag[m][n]=true;
    		switch (point) {
			case 1:
				if(n<matrix[0].length-1&&!flag[m][n+1]) n++;
				else  {point=2;m++;}
				break;
			case 2:
				if(m<matrix.length-1&&!flag[m+1][n]) m++;
				else {point=3;n--;}
				break;
			case 3:
				if(n>0&&!flag[m][n-1]) n--;
				else {point=4;m--;}
				break;
			case 4:
				if(m>0&&!flag[m-1][n]) m--;
				else {point=1;n++;}
				break;
			default:
				break;
			}
    	}
		return result;
        
    }
}
