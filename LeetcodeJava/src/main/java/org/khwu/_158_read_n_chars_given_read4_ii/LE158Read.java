package org.khwu._158_read_n_chars_given_read4_ii;

public class LE158Read {
}

class Reader4 {
    protected int read4(char[] buf) {
        return 0;
    }
}

class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */

    private int cachePt = 0;
    private int cacheLen = 0;
    private char[] cache = new char[4];
    public int read(char[] buf, int n) {
        int pt = 0;
        while (pt < n) {
            if (cachePt == 0) {
                cacheLen = read4(cache);
            }
            if (cacheLen == 0) break;
            while (pt < n && cachePt < cacheLen) {
                buf[pt++] = cache[cachePt++];
            }
            if (cachePt >= cacheLen) cachePt = 0;
        }
        return pt;
    }
}