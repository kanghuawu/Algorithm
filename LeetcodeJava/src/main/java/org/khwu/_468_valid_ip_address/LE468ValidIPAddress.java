package org.khwu._468_valid_ip_address;

public class LE468ValidIPAddress {
    public String validIPAddress(String IP) {
        if (IP.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}") && validIPv4(IP)) return "IPv4";
        else if (IP.matches("([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}")) return "IPv6";
        else return "Neither";
    }

    private boolean validIPv4(String IP) {
        String[] arr = IP.split("\\.");
        for (int i = 0; i < 4; i++) {
            int num = Integer.parseInt(arr[i]);
            if (num > 255 || num < 0) return false;
            String s = String.valueOf(num);
            if (!s.equals(arr[i])) return false;
        }
        return true;
    }
}
