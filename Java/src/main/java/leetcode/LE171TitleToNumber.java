package leetcode;

public class LE171TitleToNumber {
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
		LE171TitleToNumber test = new LE171TitleToNumber();
    	System.out.println(test.titleToNumber(str));
    }
}
