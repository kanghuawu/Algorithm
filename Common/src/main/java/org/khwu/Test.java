package org.khwu;

import java.util.*;

public class Test {
    public static int closest(String s) {
        String[] words = s.split("\\s+");
        Map<String, Integer> position = new HashMap<>();
        int res = Integer.MAX_VALUE;
        int idx = 0;
        for (String word : words) {
            int curIdx = s.indexOf(word, idx);
            System.out.println(word + " " + curIdx);
            if (position.containsKey(word)) {
                res = Math.min(res, curIdx - position.get(word));
            }
            position.put(word, curIdx);
            idx = curIdx + 1;
        }
        return res;
    }

    public static boolean isValidIp(String ip) {
        if (!ip.matches("(\\d{1,3}\\.){3}\\d{1,3}")) return false;
        String[] arr = ip.split("\\.");
        for (int i = 0; i < 4; i++) {
            int num = Integer.parseInt(arr[i]);
            if (num < 0 || num > 255) return false;
            String numStr = String.valueOf(num);
            if (!numStr.equals(arr[i])) return false;
        }
        return true;
    }

    public static int findPattern(String s, String pat) {
        int idx = 0;
        int count = 0;
        while (idx != -1) {
            idx = s.indexOf(pat, idx);
            if (idx != -1) {
                count++;
                idx++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(5 << 2);
    }
}
