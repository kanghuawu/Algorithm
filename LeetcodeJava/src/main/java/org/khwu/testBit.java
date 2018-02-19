package org.khwu;

public class testBit {
	public static int clearBitsMSBthroughI(int num, int i){
	    int mask = (1 << i) - 1;
	    return num & mask;
	}
	public static void main(String arg[]){
		System.out.println(testBit.clearBitsMSBthroughI(31, 3));
	}
	
}
