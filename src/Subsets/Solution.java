package Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		int[] a={1,2,3};
		System.out.println(subsets3(a));
	}
	 public static List<List<Integer>> subsets(int[] nums) {
	        List<List<Integer>> result=new ArrayList<List<Integer>>();
	        if(nums==null||nums.length==0) return result;
	        if(nums.length==1){
	            List<Integer> temp=new ArrayList<Integer>();
	            temp.add(nums[0]);
	            result.add(temp);
	            return result;
	        }
	        List<List<Integer>> temp=subsets2(nums,1,nums.length-1);
	        result.addAll(temp);
	         for (List<Integer> list : temp) {
	        	 List<Integer> te=new ArrayList<Integer>(list);
	        	 te.add(nums[0]);
	        	 result.add(te);
			}
	         return result;
	    }
	     public static List<List<Integer>> subsets2(int[] nums,int beg,int end){
	         List<List<Integer>> result=new ArrayList<List<Integer>>();
	         if(beg>end) return result;
	         if(beg==end){
	            List<Integer> temp=new ArrayList<Integer>();
	            temp.add(nums[beg]);
	            result.add(temp);
	            List<Integer> no=new ArrayList<Integer>();
	            result.add(no);
	            return result;
	         }
	         List<List<Integer>> temp=subsets2(nums,beg+1,nums.length-1);
	         result.addAll(temp);
	         for (List<Integer> list : temp) {
	        	 List<Integer> te=new ArrayList<Integer>(list);
	        	 te.add(nums[beg]);
	        	 result.add(te);
			}
	         return result;
	     }
	     
	     public static  List<List<Integer>> subsets3(int[] nums) {
		        List<List<Integer>> result=new ArrayList<List<Integer>>();
		        Arrays.sort(nums);
		        int total=1<<nums.length;
		        for(int i=0;i<total;i++){
		        	List<Integer> temp=new ArrayList<Integer>();
		        	for(int j=0;j<nums.length;j++){
		        		if((i&(1<<j))!=0)
		        			temp.add(nums[j]);
		        	}
		        	result.add(temp);
		        }
		        return result;
		    }
}
