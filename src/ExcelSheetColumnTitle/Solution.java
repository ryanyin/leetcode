package ExcelSheetColumnTitle;

public class Solution {
	public static void main(String[] args) {
		System.out.println(convertToTitle(53));
	}
    public static String convertToTitle(int n) {
    	StringBuilder result=new StringBuilder();
    	while(n>0){
    		n=n-1;
    		result.insert(0, (char)('A'+n%26));
    		n=n/26;
    	}
		return result.toString();
        
    }
}
