package BestTimetoBuyandSellStock;

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<=1||prices==null) return 0;
        int[] temp=new int[prices.length-1];
        for (int i = 0; i < temp.length; i++) {
        	temp[i]=prices[i+1]-prices[i];
		}
        int max=0;
        int sum=0;
        for (int i = 0; i < temp.length; i++) {
        	sum=Math.max(sum+temp[i],temp[i]);
        	max=Math.max(max,sum);
		}
        return max;
    }
}
