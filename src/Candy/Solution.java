package Candy;


public class Solution {
    public static void main(String[] args) {
		int[] a={2,2,2,1};
		System.out.println(candy(a));
	}
    public static int candy(int[] ratings) {
        if(ratings.length<2) return ratings.length==0?0:1;
        int[] candys=new int[ratings.length];
        candys[0]=1;
        for(int i=1;i<ratings.length;i++){
        	if(ratings[i]>ratings[i-1]) candys[i]=candys[i-1]+1;
        	else candys[i]=1;
        }
        
        for(int i=ratings.length-2;i>=0;i--){
        	if(ratings[i]>ratings[i+1]&&candys[i]<=candys[i+1]) candys[i]=candys[i+1]+1;
        }
       int sum=0;
       for (int i : candys) {
    	   sum+=i;
	}
       return sum;
    }
}
