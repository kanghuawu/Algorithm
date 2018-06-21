package org.khwu._157_read_n_characters_given_read4;

public class LE157Read {
    private int read4(char[] buf) {
        return 0;
    }

    public int read(char[] buf, int n) {
        char[] tmp = new char[4];
        int len = read4(tmp);
        int i = 0;
        while (len != 0) {
            int j = 0;
            while (i < n && j < len) {
                buf[i++] = tmp[j++];
            }
            if (i == n) break;
            len = read4(tmp);
        }
        return i;
    }
}
