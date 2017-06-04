package leetcode;

public class LE171titleToNumber {
	public int titleToNumber(String s) {
        int result = 0;
		for(char ch : s.toCharArray()){
			result *= 26;
        	result += ch - 'A' + 1;
        }
		return result;
    }
	public static void main(String[] args){
		String str = "AZ";
		LE171titleToNumber test = new LE171titleToNumber();
    	System.out.println(test.titleToNumber(str));
    }
}
