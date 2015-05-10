package PermutationSequence;

import java.util.LinkedList;
import java.util.List;

/*The set [1,2,3,бн,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

    "123"
    "132"
    "213"
    "231"
    "312"
    "321"

Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.*/

public class Solution {
	public static void main(String[] args) {
		System.out.println(getPermutation(4, 12));
	}
    public static String getPermutation(int n, int k) {
    	StringBuilder result=new StringBuilder();
    	int[] temp=new int[n+1];
    	temp[0]=1;
    	List<Integer> sc=new LinkedList<>();
    	for(int i=1;i<=n;i++){
    		 temp[i]=temp[i-1]*i;
    		 sc.add(i);
    	}
    	k=k-1;
    	for(int i=1;i<=n;i++){
    		int a=k/temp[n-i];
    		k=k%temp[n-i];
    		result.append(sc.get(a));
    		sc.remove(a);
    	}
    	
		return result.toString();
        
    }


}
