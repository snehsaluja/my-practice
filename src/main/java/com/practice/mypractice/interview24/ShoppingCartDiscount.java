package com.practice.mypractice.interview24;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCartDiscount {

    /*
     * Complete the 'findLowestPrice' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. 2D_STRING_ARRAY products
     *  2. 2D_STRING_ARRAY discounts
     */

    /*

    FIND LOWEST CART VALUE (LOWEST/MIN CART PRICE):

    Each Product can be assigned with Multiple Tags.

    Discount Tag Types:
    Type 0 -> Tag value is already at discounted rate.
    Type 1 -> % discount will be applied.
    Type 2 -> absolute discount value will be applied.
    EMPTY tags -> no discounts for this tag type

    Example Input:
    Discounts => {d0, 0, 7}, {d1, 1, 10} , {d2, 2, 10}      ; format -  <tage_name, type, value>

    Products =>  {20, d1, d2} , {50, d2, EMPTY, EMPTY}  , {44, d0}      ; format - <product MRP, tag name>

    Output = 57

    Explanation:
    first product = min(20-10% , 20-10) = min(18,10) = 10
    second product = min(50-10, 50, 50) = 40
    third product = apply d0 tag = direct value = 7

    total min cart value = 10+40+7 = 57

    */

    public static int findLowestPrice(List<List<String>> products, List<List<String>> discounts) {
        // Write your code here
        // prod -> n , disc -> d
        Map<String, List<Discount>> discountMap = new HashMap<>();
        int sum = 0;

        for (List<String> disc : discounts) {       // O(d)
            String name = disc.get(0);
            int type = Integer.parseInt(disc.get(1));
            int value = Integer.parseInt(disc.get(2));
            discountMap.computeIfAbsent(name, k -> new ArrayList<>()).add(new Discount(name, type, value));
        }

        for (List<String> prod : products) {            // O(n)
            int mrp = Integer.parseInt(prod.get(0));
            int discountedPrice = mrp;
            int len = prod.size();

            for (int i = 1; i < len; i++) {             // O(m-1)
                String tagName = prod.get(i);
                List<Discount> discList = discountMap.get(tagName);
                if (discList == null || discList.size() == 0) {
                    continue;
                }
                for (Discount disc : discList) {
                    int price = mrp;
                    switch (disc.type) {
                        case 0:
                            price = disc.value;
                            break;
                        case 1:
                            price = (int) (price - ((price * disc.value) / (double) 100));
                            break;
                        case 2:
                            price -= disc.value;
                            break;
                        default:
                            break;
                    }
                    discountedPrice = Math.min(discountedPrice, price);
                }
            }
            sum += discountedPrice;
        }
        return sum;
    }

}

class Discount {
    String name;
    int type;
    int value;

    Discount(String n, int t, int v) {
        name = n;
        type = t;
        value = v;
    }
}