package leetcode;

public class LE292CanWinNim {
//    public boolean canWinNim(int n) {
//    	if(n % 4 == 0) return false;
//    	return true;
//    }
	public boolean canWinNim(int n) {
		return (n & 3) != 0;
    }
    public static void main(String[] arg){
    	int n = 8;
    	LE292CanWinNim test = new LE292CanWinNim();
    	System.out.println(test.canWinNim(n));
    }
}
