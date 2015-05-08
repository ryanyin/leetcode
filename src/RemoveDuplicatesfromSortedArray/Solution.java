package RemoveDuplicatesfromSortedArray;

public class Solution {
	public static void main(String[] args) {
		int[] a={1,1,2,3,3,4};
		System.out.println(removeDuplicates2(a));
	}
	 public static int removeDuplicates(int[] nums) {
		 int count=0;
		 if(nums==null||nums.length==0) return count;
		 if(nums.length==1) return 1;
		 int pre=0;
		 int temp=nums[0];
		 count=1;
		 boolean flag=true;
		 for(int i=1;i<nums.length;i++){
			 if(temp==nums[i]) {
				 if(flag) {
					 pre=i;
					 flag=false;
				 }
			 }
			 if(temp!=nums[i]){
				 count++;
				 if(pre>0&&pre<i){
					 nums[pre]=nums[i];
					 pre++;
				 }
				 temp=nums[i];
			 }
		 }
		 return count;     
	    }
	 public static int removeDuplicates2(int[] nums){
		 
		 if(nums==null||nums.length==0) return 0;
		 if(nums.length==1) return 1;
		 int id=1;
		 for(int i=1;i<nums.length;i++){
			 if(nums[i]!=nums[i-1]) nums[id++]=nums[i];
		 }
		return id;
	 }
	 
}
