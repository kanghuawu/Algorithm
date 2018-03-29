package org.khwu._273_integer_to_english_words;

import java.util.ArrayList;
import java.util.List;

public class LE273NumberToWords {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        List<StringBuilder> res = new ArrayList<>();

        int i = 0;
        while (num > 0) {
            res.add(new StringBuilder());
            if (num % 1000 != 0) {
                helper(res, i, num % 1000);
                res.get(i).append(THOUSANDS[i]);
                if (i != 0)
                    res.get(i).append(" ");
            }
            num /= 1000;
            i++;
        }

        StringBuilder sb = new StringBuilder();
        for (int j = res.size() - 1; j >= 0; j--) {
            sb.append(res.get(j));
        }

        return sb.toString().trim();
    }

    private void helper(List<StringBuilder> res, int i, int num) {
        if (num == 0) {

        } else if (num < 20) {
            res.get(i).append(LESS_THAN_20[num]);
            res.get(i).append(" ");
        } else if (num < 100) {
            res.get(i).append(TENS[num / 10]);
            res.get(i).append(" ");
            helper(res, i, num % 10);
        } else {
            res.get(i).append(LESS_THAN_20[num / 100]);
            res.get(i).append(" Hundred ");
            helper(res, i, num % 100);
        }
    }
}
