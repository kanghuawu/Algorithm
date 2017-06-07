package leetcode;

public class LE292canWinNim {
//    public boolean canWinNim(int n) {
//    	if(n % 4 == 0) return false;
//    	return true;
//    }
	public boolean canWinNim(int n) {
		return (n & 3) != 0;
    }
    public static void main(String[] arg){
    	int n = 8;
    	LE292canWinNim test = new LE292canWinNim();
    	System.out.println(test.canWinNim(n));
    }
}
