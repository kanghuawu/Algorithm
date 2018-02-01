package leetcode._443_string_compression;

public class LE443Compress {
    public int compress(char[] chars) {
        if (chars.length == 0) return 0;
        int pt0 = 0;
        int pt1 = 0;
        for (int pt2 = 0; pt2 <= chars.length; pt2++) {
            if (pt2 == chars.length || chars[pt1] != chars[pt2]) {
                if (pt2 - pt1 > 1) {
                    String n = String.valueOf(pt2 - pt1);
                    for (int i = 0; i < n.length(); i++) {
                        chars[++pt0] = n.charAt(i);
                    }
                }
                if (pt2 < chars.length) {
                    chars[++pt0] = chars[pt2];
                    pt1 = pt2;
                }
            }
        }
        return pt0+1;
    }
}
