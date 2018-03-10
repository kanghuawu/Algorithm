package org.khwu._076_min_window_substring;

import java.util.HashMap;
import java.util.Map;

public class LE076MinWindow {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty()) return "";
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        char[] sAr = s.toCharArray();
        int nT = t.length();
        int nS = sAr.length;
        int count = 0;
        int res = Integer.MAX_VALUE;
        int iMin = 0;
        int jMin = nS;
        for (int i = 0, j = 0; i < nS; i++) {
            if (!map.containsKey(sAr[i])) continue;

            map.put(sAr[i], map.getOrDefault(sAr[i], 0) - 1);
            if (map.get(sAr[i]) >= 0) count++;

            while (count >= nT) {
                if (i -j < res) {
                    iMin = i;
                    jMin = j;
                    res = i - j;
                }
                if (map.containsKey(sAr[j])) {
                    map.put(sAr[j], map.getOrDefault(sAr[j], 0) + 1);
                    if (map.get(sAr[j]) > 0) count--;
                }
                j++;
            }
        }
        if (jMin > iMin) return "";
        return s.substring(jMin, iMin + 1);
    }
}
