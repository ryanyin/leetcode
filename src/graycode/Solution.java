package graycode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(grayCode(3));
	}

    public static List<Integer> grayCode(int n) {
        if(n==0) return null;
        StringBuilder[] temp= getString(n);
        List<Integer> result=new ArrayList<Integer>();
        for(int i=0;i<temp.length;i++){
            result.add(Integer.parseInt(temp[i].toString(),2));
        }
        return result;
    }
    public static StringBuilder[] getString(int n){
        StringBuilder[] result=new StringBuilder[(int) Math.pow(2, n)];
        if(n==1){
            result[0]=new StringBuilder("0");
            result[1]=new StringBuilder("1");
            return result;
        }
        StringBuilder[] temp=getString(n-1);
        for(int i=0;i<temp.length;i++){
            result[i]=(new StringBuilder(temp[i].toString()).insert(0,'0'));
            		
        }
        for(int i=temp.length;i<2*temp.length;i++){
            result[i]=(new StringBuilder(temp[2*temp.length-i-1].toString()).insert(0,'1'));
        }
        return result;
    }
}
