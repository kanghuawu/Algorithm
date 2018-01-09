package leetcode._267_palidrome_permutation_ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LE267GeneratePalindromesDFS {
    private int len;
    private String oddChar;
    public List<String> generatePalindromes(String s) {
        char[] str = s.toCharArray();
        len = str.length / 2;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            int num = map.getOrDefault(str[i], 0);
            map.put(str[i], num + 1);

        }

        int odd = 0;
        oddChar = "";
        for (char ch : map.keySet()) {
            int n = map.get(ch);
            if (n % 2 == 1) {
                odd++;
                oddChar = String.valueOf(ch);
                map.put(ch, n - 1);
            }
            if (odd > 1) {
                return new ArrayList<String>();
            }
        }
        List<String> res = new ArrayList<String>();

        dfs(res, new StringBuilder(), map);
        return res;
    }

    private void dfs(List<String> res, StringBuilder sb, Map<Character, Integer> map) {
        if (sb.length() == len) {
            StringBuilder tmp = new StringBuilder(sb);
            tmp.append(oddChar);
            tmp.append(sb.reverse());
            res.add(tmp.toString());
            sb.reverse();
            return;
        }
        // System.out.println(map);
        for (char ch : map.keySet()) {
            int n = map.get(ch);
            if (n > 1) {
                map.put(ch, n - 2);
                sb.append(ch);
                dfs(res, sb, map);
                sb.deleteCharAt(sb.length() - 1);
                map.put(ch, n);
            }
        }
    }
}
