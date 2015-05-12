package SurroundedRegions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/*Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,

X X X X
X O O X
X X O X
X O X X

After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
*/

public class Solution {

	public static void main(String[] args) {
		char[][] board={{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
		System.out.println(solve(board));
	}
    public static char[][] solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				char cs = board[i][j];
				if(cs=='O'){
					Set<Integer> result=getAll(board,i,j);
					if(result!=null&&result.size()>0){
						for (Integer integer : result) {
							int r=integer/board[0].length;
							int c=integer%board[0].length;
							board[r][c]='X';
						}
					}
				}
			}
		}
       return board; 
    }

	private static Set<Integer> getAll(char[][] board, int i, int j) {
		// TODO Auto-generated method stub
		Set<Integer> result=new HashSet<Integer>();
		if(i==0||i==board.length-1||j==0||j==board[0].length-1) return null;
		if(board[i-1][j]=='O'||board[i][j-1]=='O') return null;
		Stack<Integer> temp=new Stack<Integer>();
		temp.add(i*board[0].length+j);
		result.add(i*board[0].length+j);
		while(!temp.isEmpty()){
			int num=temp.pop();
			int r=num/board[0].length;
			int c=num%board[0].length;
			if(r==0||r==board.length-1||c==0||c==board[0].length-1) return null;
			if(board[r][c+1]=='O'){
				if(!result.contains(r*board[0].length+c+1)){
					temp.add(r*board[0].length+c+1);
					result.add(r*board[0].length+c+1);
				}
			}
			if(board[r+1][c]=='O'){
				if(!result.contains((r+1)*board[0].length+c)){
					temp.add((r+1)*board[0].length+c);
					result.add((r+1)*board[0].length+c);
				}
			}
			if(board[r][c-1]=='O'){
				if(!result.contains(r*board[0].length+c-1)){
					temp.add(r*board[0].length+c-1);
					result.add(r*board[0].length+c-1);
				}
			}
			if(board[r-1][c]=='O'){
				if(!result.contains((r-1)*board[0].length+c)){
					temp.add((r-1)*board[0].length+c);
					result.add((r-1)*board[0].length+c);
				}
			}
		}
		return result;
	}
    
    
}
