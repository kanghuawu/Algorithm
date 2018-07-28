package org.khwu._068_text_justification;

import java.util.LinkedList;
import java.util.List;

public class LE068FullJustify {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> res = new LinkedList<>();
        int i = 0;
        int n = words.length;
        while (i < n) {
            int cnt = words[i].length();
            int last = i + 1;
            while (last < n) {
                if (cnt + words[last].length() + 1 > maxWidth) break;
                cnt += words[last].length() + 1;
                last++;
            }


            StringBuilder sb = new StringBuilder();
            int diff = last - i - 1;
            if (last == n || diff == 0) {
                for (int j = i; j < last; j++) {
                    sb.append(words[j]);
                    sb.append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
                for (int j = sb.length(); j < maxWidth; j++) {
                    sb.append(" ");
                }
            } else {
                int space = (maxWidth - cnt) / diff;
                int remain = (maxWidth - cnt) % diff;
                for (int j = i; j < last; j++) {
                    sb.append(words[j]);
                    if (j == last - 1) break;
                    for (int k = 0; k <= space; k++) {
                        sb.append(" ");
                    }
                    if (remain-- > 0) sb.append(" ");
                }
            }
            res.add(sb.toString());
            i = last;
        }

        return res;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        LE068FullJustify test = new LE068FullJustify();
        System.out.println(test.fullJustify(words, maxWidth));
    }
}
