package leetcode;

public class LE482LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        for (int i = S.length() - 1; i >= 0; i-- ) {
            if (S.charAt(i) != '-') {
                if ((sb.length() + 1) % (K + 1) == 0) sb.append('-'); // <- this has to go first

                if (S.charAt(i) <= 122 && S.charAt(i) >= 97) sb.append(Character.toChars(S.charAt(i) - 32));
                else sb.append(S.charAt(i));
            }
        }
        return sb.reverse().toString();
    }
}
