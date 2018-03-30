package org.khwu._067_add_binary;

public class LE067AddBinary {
    public String addBinary(String a, String b) {
        int aL = a.length();
        int bL = b.length();
        boolean carry = false;
        int i = aL - 1;
        int j = bL - 1;
        StringBuilder sb = new StringBuilder();
        while (carry || i >= 0 ||j >= 0) {
            int sum = 0;
            if (i >= 0 && a.charAt(i--) == '1') sum++;
            if (j >= 0 && b.charAt(j--) == '1') sum++;
            if (carry) sum++;
            sb.append(sum % 2);
            if (sum >= 2) {
                carry = true;
            } else {
                carry = false;
            }
        }
        return sb.reverse().toString();
    }
}
