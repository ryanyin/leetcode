package MaximumGap;

import java.util.Arrays;

public class Solution {
	/*Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
	Try to solve it in linear time/space.
	Return 0 if the array contains less than 2 elements.
	You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
	
	˼·��Ͱ����
	 ������N��Ԫ��A��B��
	��ô����ֵ����С��ceiling[(B - A) / (N - 1)]�� ���ݸ볲ԭ��
	��bucket��Ͱ���Ĵ�Сlen = ceiling[(B - A) / (N - 1)]����������(B - A) / len + 1��Ͱ
	���������е���������K��������ͨ����ʽloc = (K - A) / len�ҳ���Ͱ��λ�ã�Ȼ��ά��ÿһ��Ͱ�����ֵ����Сֵ
	����ͬһ��Ͱ�ڵ�Ԫ��֮��Ĳ�ֵ����Ϊlen - 1��������մ𰸲����ͬһ��Ͱ��ѡ��
         ����ÿһ���ǿյ�Ͱp���ҳ���һ���ǿյ�Ͱq����q.min - p.max���ܾ��Ǳ�ѡ�𰸡�����������Щ����ֵ�е����ֵ��
	*/
	public int maximumGap(int[] nums) {
        if(nums.length<2||nums==null) return 0;
        int min=nums[0];
        int max=nums[0];
        for (int i : nums) {
			min=Math.min(min, i);
			max=Math.max(max, i);
		}
        int gap=(int) Math.ceil((double)(max-min)/(nums.length-1));
        int[] buck_max=new int[nums.length-1];
        int[] buck_min=new int[nums.length-1];
        Arrays.fill(buck_max, Integer.MIN_VALUE);
        Arrays.fill(buck_min, Integer.MAX_VALUE);
        for (int i : nums) {
			if(i==min||i==max)
				continue;
			int index=(i-min)/gap;
			buck_max[index]=Math.max(buck_max[index], i);
			buck_min[index]=Math.min(buck_min[index], i);
		}
        int maxgap=Integer.MIN_VALUE;
        int pre=min;
        for(int i=0;i<nums.length-1;i++){
        	if(buck_max[i]==Integer.MIN_VALUE&&buck_min[i]==Integer.MAX_VALUE)
        		continue;
        	maxgap=Math.max(maxgap, buck_min[i]-pre);
        	pre=buck_max[i];
        }
        maxgap=Math.max(maxgap, max-pre);
        return maxgap;
    }
}
