package org.khwu._008_string_to_integer_atoi;

public class LE008MyAtoi {
    public int myAtoi(String str) {
        String trimmed = str.trim();
        if (trimmed.isEmpty()) return 0;
        boolean sign = false;
        int res = 0;
        int i = 0;
        if (trimmed.charAt(i) == '-') {
            sign = true;
            i++;
        } else if (trimmed.charAt(i) == '+') {
            i++;
        }
        for (; i < trimmed.length(); i++) {
            int num = trimmed.charAt(i) - '0';
            if (num >= 0 && num <= 9) {
                int tmp = 10*res;
                if ((tmp + num) / 10 != res) return sign ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                res = tmp + num;
            } else {
                break;
            }
        }
        return res * (sign ? (-1) : 1);
    }
}
