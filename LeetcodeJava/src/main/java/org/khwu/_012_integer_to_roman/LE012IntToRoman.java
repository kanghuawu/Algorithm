package org.khwu._012_integer_to_roman;

public class LE012IntToRoman {
    private static String[] rom = new String[]{"I","V","X","L","C","D","M"};
    public String intToRoman(int num) {
        String res = "";
        int i = 0;
        while (num > 0) {
            int rem = num % 10;
            String tmp = "";
            if (rem == 4) {
                tmp = rom[i] + rom[i+1];
                rem = 0;
            } else if (rem == 9) {
                tmp = rom[i] + rom[i+2];
                rem = 0;
            } else if (rem >= 5) {
                tmp = rom[i+1];
                rem -= 5;
            }
            while (rem-- > 0) {
                tmp = tmp + rom[i];
            }
            i += 2;
            num /= 10;
            res = tmp + res;
        }
        return res;
    }
}
