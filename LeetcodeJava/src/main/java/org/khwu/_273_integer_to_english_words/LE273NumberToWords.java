package org.khwu._273_integer_to_english_words;

import java.util.Deque;
import java.util.LinkedList;

public class LE273NumberToWords {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        Deque<StringBuilder> li = new LinkedList<>();
        int i = 0;
        while (num > 0) {
            StringBuilder sb = new StringBuilder();
            if (num % 1000 != 0) {
                build(sb, num % 1000);
                sb.append(THOUSANDS[i]);
                sb.append(" ");
            }
            i++;
            num /= 1000;
            li.addFirst(sb);
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : li) {
            res.append(sb);
        }

        return res.toString().trim();
    }

    private void build(StringBuilder sb, int num) {
        if (num == 0) {

        } else if (num < 20) {
            sb.append(LESS_THAN_20[num]);
            sb.append(" ");
        } else if (num < 100) {
            sb.append(TENS[num/10]);
            sb.append(" ");
            build(sb, num % 10);
        } else {
            sb.append(LESS_THAN_20[num/100]);
            sb.append(" Hundred ");
            build(sb, num % 100);
        }
    }
}
