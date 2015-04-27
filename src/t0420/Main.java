package t0420;

import java.util.Stack;

public class Main {
	public static void main(String[] args){
		char[][] grid=new char[3][3];
		grid[0]="111".toCharArray();
		grid[1]="010".toCharArray();
		grid[2]="111".toCharArray();
		Main m=new Main();
		System.out.println(m.numIslands(grid));
	}
	boolean [][] isVisit;
    Stack<String> stc=new Stack<String>();
    int result=0;
    int leni=0;
    int lenj=0;
    public int numIslands(char[][] grid) {
        leni=grid.length;
        if(leni==0)   return 0;
        lenj=grid[0].length;
        isVisit=new boolean[leni][lenj];
        for(int i=0;i<leni;i++)
        {
            for(int j=0;j<lenj;j++){
                if(!isVisit[i][j]&&grid[i][j]=='1')
                 {
                     result++;
                     stc.push((String.valueOf(i)+"S"+String.valueOf(j)));
                     getVisit(grid);
                 }   
            }
        }
        return result;
    }
    
    public void getVisit(char[][] grid){
        String[] tij=new String[2];
        int i=0,j=0;
        while(!stc.isEmpty()){
        	tij=stc.pop().split("S");
            i=Integer.parseInt(tij[0]);
            j=Integer.parseInt(tij[1]);
            if(1+j<lenj&&!isVisit[i][1+j]&&grid[i][1+j]=='1')
            {
                stc.push((String.valueOf(i)+"S"+String.valueOf(j+1)));
            }
            if(1+i<leni&&!isVisit[i+1][j]&&grid[i+1][j]=='1')
            {
                stc.push((String.valueOf(i+1)+"S"+String.valueOf(j)));
            }
            if(i-1>=0&&!isVisit[i-1][j]&&grid[i-1][j]=='1')
            {
                stc.push((String.valueOf(i-1)+"S"+String.valueOf(j)));
            }
            if(j-1>=0&&!isVisit[i][j-1]&&grid[i][j-1]=='1')
            {
                stc.push((String.valueOf(i)+"S"+String.valueOf(j-1)));
                
            }
            isVisit[i][j]=true;
        }
    }
}
