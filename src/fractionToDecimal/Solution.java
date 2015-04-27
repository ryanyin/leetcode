package fractionToDecimal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fractionToDecimal(1,5));
	}
	public static String fractionToDecimal(long numerator, long denominator) {
		long num=(long)numerator;
		long den=(long)denominator;
		if(num==0)	return 0+"";
		if((num>0&&den>0)||(num<0&&den<0))
			return posivite(num,den);
		else return "-"+posivite(Math.abs(num),Math.abs(den));
      
    }
	private static String posivite(long l, long m) {
		// TODO Auto-generated method stub
		long fir=0;
	        if(l%m==0)
	        {
	            fir=l/m;
	            return String.valueOf(fir);
	        }else{
	            fir=(l-l%m)/m;
	            long last=l%m;
	            StringBuilder sec=new StringBuilder();
	            HashMap<Long,Long> temp=new HashMap<Long,Long>();
	            Long position=0L;
	            Long track=null;
	            while ((track=temp.put(last, position++))==null&&last!=0L) {
					sec.append(last*10/m);
					last=last*10%m;
				}
	            if(last!=0)
	            {
	            	sec.insert((int) (track+0), '(');
	                sec.insert(sec.length(), ')');
	            }
	            return fir+"."+sec.toString();
	        }
	}
}
