package org.khwu._800_similar_rgb_color;

public class LE800SimilarRGB {

    public String similarRGB(String color) {
        int n = color.length();
        String[] ar = setup();
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 1; i < n - 1; i += 2) {
            String s = color.substring(i, i+1);
            int idx = Integer.parseInt(s, 16);
            int small = Integer.parseInt(ar[(idx - 1 + 16) % 16], 16);
            int medium = Integer.parseInt(ar[(idx) % 16], 16);
            int big = Integer.parseInt(ar[(idx + 1) % 16], 16);
            int num = Integer.parseInt(color.substring(i, i+2), 16);
            int nS = Math.abs(num - small);
            int nM = Math.abs(num - medium);
            int nB = Math.abs(num - big);
            if (nB < nS && nB < nM){
                sb.append(ar[(idx + 1) % 16] );
            } else if (nS < nB && nS < nM) {
                sb.append(ar[(idx - 1) % 16]);
            } else {
                sb.append(ar[idx]);
            }
        }

        return sb.toString();
    }

    private String[] setup() {
        String[] ar = new String[16];
        for (int i = 0; i < 16; i++) {
            ar[i] = Integer.toHexString(i) + Integer.toHexString(i);
        }
        return ar;
    }
}
