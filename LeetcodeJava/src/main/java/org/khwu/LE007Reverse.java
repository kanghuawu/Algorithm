package org.khwu;

public class LE007Reverse {
	public int reverse(int x) {
        int result = 0;

        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result)
            { return 0; }
            result = newResult;
            x = x / 10;
        }
    
        return result;
    }
	
//	public int reverse(int x) {
//		int re = 0;
//		while(x != 0){
//			if (Integer.MAX_VALUE / 10 < Math.abs(re) || (Integer.MAX_VALUE - Math.abs(x) % 10) < Math.abs(x) * 10) {
//                return 0;
//            }
//            re = re * 10 + x % 10;
//            x /= 10;
//		}
//		return re;
//	}
	
    public static void main(String[] arg){
    	System.out.println( Math.abs(-2147483648) );
    	int x =  -2147483412; //-2147483412; //-2147483648; //104; // INT_MAX 2147483647; // INT_MIN -2147483648;
//    	LE007Reverse test = new LE007Reverse();
//    	System.out.println(test.reverse(x));
    }
}
