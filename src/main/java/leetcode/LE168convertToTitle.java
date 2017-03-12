package leetcode;

public class LE168convertToTitle {
	public String convertToTitle(int n) {
		int i;
		char ch;
		String result = new String();
		while(n != 0){
			n -= 1;
			i = n % 26;
			System.out.println("i: " + i);
			ch = (char)('A' + i);
//			System.out.println(ch);
			result = ch + result;
			n /= 26;
//			System.out.println("n" + n);
		}
		return result;
    }
	public static void main(String[] args){
		int num = 53;
//		System.out.print(ch);
		LE168convertToTitle test = new LE168convertToTitle();
    	System.out.println(test.convertToTitle(num));
    }
}
