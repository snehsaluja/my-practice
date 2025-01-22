package com.practice.mypractice.programs.bookingdotcom_leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CurrencyConversion {

    class CurrencyNode {
        String currency;
        double weight;

        public CurrencyNode(String currency, double weight) {
            this.currency = currency;
            this.weight = weight;
        }
    }

    class CurrencyValue {
        String currency;
        double value;

        public CurrencyValue(String currency, double value) {
            this.currency = currency;
            this.value = value;
        }
    }

    public double convertCurrency(String[][] conversionTable, double amount, String src, String target) {

        Map<String, List<CurrencyNode>> adjList = new HashMap<>();
        for (String[] row : conversionTable) {
            String from = row[0], to = row[1];
            double val = Double.parseDouble(row[2]);
            adjList.computeIfAbsent(from, k -> new ArrayList<>()).add(new CurrencyNode(to, val));
            adjList.computeIfAbsent(to, k -> new ArrayList<>()).add(new CurrencyNode(from, 1 / val));
        }

        Queue<CurrencyValue> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(new CurrencyValue(src, amount));
        visited.add(src);
        while (!q.isEmpty()) {
            CurrencyValue curr = q.poll();
            amount = curr.value;
            if (curr.currency.equals(target)) {
                return finalAmountWithTxnFees(curr.value);
            }
            for (CurrencyNode node : adjList.get(curr.currency)) {
                if (visited.contains(node.currency)) {
                    continue;
                }
                double tempVal = amount * node.weight;
                /*if (node.currency.equals(target)) {
                    return tempVal;
                }*/
                q.offer(new CurrencyValue(node.currency, tempVal));
                visited.add(node.currency);
            }
        }
        return -1;
    }

    private double finalAmountWithTxnFees(double value) {
        return value * 1.02;
    }

    public static void main(String[] args) {

        CurrencyConversion ob = new CurrencyConversion();
        String[][] convTable = {{"EUR", "GBP", "1.50"},
                {"GBP", "USD", "1.10"},
                {"CAD", "AED", "0.85"},
                {"GBP", "MXN", "100"}};
        System.out.println(ob.convertCurrency(convTable, 1000, "EUR", "USD"));
        System.out.println(ob.convertCurrency(convTable, 100, "CAD", "USD"));

    }
}
