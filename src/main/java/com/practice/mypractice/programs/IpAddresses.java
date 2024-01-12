package com.practice.mypractice.programs;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class IpAddresses {

    public static List<Integer> getRegions(List<String> ip_addresses) {

        return ip_addresses.stream().map(ip -> {
            if (!isValid(ip)) {
                return -1;
            }
            int firstOctet = Integer.parseInt(ip.substring(0, ip.indexOf('.')));
            if (firstOctet >= 0 && firstOctet <= 127) {
                return 1;
            } else if (firstOctet >= 128 && firstOctet <= 191) {
                return 2;
            } else if (firstOctet >= 192 && firstOctet <= 223) {
                return 3;
            } else if (firstOctet >= 224 && firstOctet <= 239) {
                return 4;
            } else {
                return 5;
            }
        }).collect(Collectors.toList());

    }

    private static boolean isValid(String ip) {
        StringTokenizer st = new StringTokenizer(ip, ".");
        while (st.hasMoreTokens()) {
            try {
                int octet = Integer.parseInt(st.nextToken());
                if (octet < 0 || octet > 255) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String ip = "15.231.268.11";
        List<String> s = new ArrayList<>();
        s.add(ip);
        System.out.println(getRegions(s));
    }
}
