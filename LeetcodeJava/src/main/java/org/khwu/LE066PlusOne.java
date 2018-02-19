package org.khwu;

public class LE066PlusOne {
	public int[] plusOne(int[] digits) {
        plusOneHelper(digits, digits.length-1);
        if (digits[0] == 0) {
            int[] newDigits = new int[digits.length+1];
            newDigits[0] = 1;
            return newDigits;
        }
        return digits;
    }
    
    private void plusOneHelper(int[] digits, int index) {
        if (index<0) return;
        
        digits[index]++;
        // System.out.println(digits[index] + " " + index);
        if( digits[index] > 9 ) {
            digits[index]-=10;
            plusOneHelper(digits, --index);
        }
    }
}
