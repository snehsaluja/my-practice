package com.practice.mypractice.programs;

public class ValidateIPAddress {

    public String validIPAddress(String queryIP) {
        if (isValidIPv4(queryIP)) {
            return "IPv4";
        } else if (isValidIPv6(queryIP)) {
            return "IPv6";
        }
        return "Neither";
    }

    private boolean isValidIPv6(String queryIP) {
        String[] segments = queryIP.split(":");
        if (segments.length != 8 || queryIP.startsWith(":") || queryIP.endsWith(":")) {  //  || countDelimeter(queryIP, ':') != 7) {
            return false;
        }
        for (int i = 0; i < segments.length; i++) {
            String seg = segments[i];
            if (seg.length() == 0 || seg.length() > 4) {
                return false;
            }
            for (char ch : seg.toCharArray()) {
                if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'f') || (ch >= 'A' && ch <= 'F')) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidIPv4(String queryIP) {
        String[] segments = queryIP.split("\\.");
        if (segments.length != 4 || queryIP.startsWith(".") || queryIP.endsWith(".")) {  // || countDelimeter(queryIP, '.') != 3) {
            return false;
        }
        for (int i = 0; i < segments.length; i++) {
            String seg = segments[i];
            if (seg.length() > 1 && seg.charAt(0) == '0') {
                return false;
            }
            try {
                int segNum = Integer.parseInt(seg);
                if ((i == 0 && segNum == 0) || !(segNum >= 0 && segNum < 256)) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }


    // Not necessary :
    private int countDelimeter(String queryIP, char delim) {
        int counter = 0;
        for (char ch : queryIP.toCharArray()) {
            if (ch == delim)
                counter++;
        }
        return counter;
    }

    public static void main(String[] args) {
        ValidateIPAddress ob = new ValidateIPAddress();
        System.out.println(ob.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(ob.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
    }
}
