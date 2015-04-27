package Sqrt;

public class Solution {
    public int mySqrt(int x) {
        if(x==0) return 0;
        int left=1,right=x,ans=0;
        while(left<=right){
            int med=left+(right-left)/2;
            if(med<=x/med){
                left=med+1;
                ans=med;
            }else{
                right=med-1;
            }
        }
        return ans;
    }
}