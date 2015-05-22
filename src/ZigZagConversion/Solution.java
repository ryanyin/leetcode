package ZigZagConversion;

/*The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);

convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR". */

public class Solution {
	public static void main(String[] args) {
		System.out.println(convert("ABCD",3));
	}
    public static String convert(String s, int numRows) {
    	 if(s.length()<=1||numRows<=1) return s;
    	int size=s.length();
    	int n=(size-1)/(2*numRows-2);
    	StringBuilder result=new StringBuilder();
    	for(int i=0;i<numRows;i++){
    		if(i==0){
    			for(int j=0;j<=n;j++){
    				result.append(s.charAt(j*(2*numRows-2)));
    			}
    		}else if(i==numRows-1){
    			for(int j=0;j<n;j++){
    				result.append(s.charAt(j*(2*numRows-2)+numRows-1));
    			}
    			if(n*(2*numRows-2)+numRows-1<size) result.append(s.charAt(n*(2*numRows-2)+numRows-1));
    		}else{
    			for(int j=0;j<n;j++){
    				result.append(s.charAt(j*(2*numRows-2)+i));
    				result.append(s.charAt((j+1)*(2*numRows-2)-i));
    			}
    			if(n*(2*numRows-2)+i<size) result.append(s.charAt(n*(2*numRows-2)+i));
    			if((n+1)*(2*numRows-2)-i<size) result.append(s.charAt((n+1)*(2*numRows-2)-i));
    		}
    	}
		return result.toString();
        
    }
}
