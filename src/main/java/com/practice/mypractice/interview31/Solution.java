package com.practice.mypractice.interview31;

import java.io.*;
import java.util.*;

// Wayfair - Round 1 (Coding) - 19th Dec
/**
 *
ORDER MANAGEMENT:

An order management system for a restaurant is being developed. Implement the /Order and /OrderSystem interface as described.
Create a class called Order implementing /Order interface.
Create a new class called OrderSystem and implement the /OrderSystem interface supporting following use-cases.
• Add the order item to the cart
• Remove the order item from the cart
• Calculate the discounted prices for each order in the cart and sum the values.
        Discounted Price = Order Price - (Order Price * Discount Rals) / 100).
        • Calculate discounts for each product category in the cart. The method returns
a map of categories name and the discount amount. (key = category, value =
category discount)
        • Retrieve the list of items in the cart along with their quantities.
Category determination is done as follows:
        • Order Price <= 10: Cheap
• Order Price <= 20 and OrderPrice > 10: Moderate
• Order Price > 20: Expensive
The discount per category is as follows:
        • Cheap - 10%
        • Moderate = 20%
        • Expensive - 30%
Example
There are 2 Order objects, with name, price:
Pizza 40
Sandwich 30
After they are added, calculate the total amount from orders.
        e,g. The Price for Pizza = 40 and 40 > 20, so the discount equals 30%. The
discounted price = 40 - (40*30)/100) = 28. Similarly, the 30% discounted price of
Sandwich is 21,
Output:
Total Amount: 49
Expensive Category Discount: 21
Pizza (1 items)
Sandwich (1 items)

 *
 */

interface IOrder {
    void setName(String name);

    String getName();

    void setPrice(int price);

    int getPrice();
}

interface IOrderSystem {
    void addToCart(IOrder order);

    void removeFromCart(IOrder order);

    int calculateTotalAmount();

    Map<String, Integer> categoryDiscounts();

    Map<String, Integer> cartItems();
}

class Order implements IOrder {

    String name;
    int price;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        IOrder ord = (IOrder) obj;
        return this.getName().equals(ord.getName());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}

class OrderSystem implements IOrderSystem {

    private Map<IOrder, Integer> cartItems = new HashMap<>();
    private Map<String, Integer> categoryDisc = new TreeMap<>((a, b) -> a.compareTo(b));

    // T = O(1)
    @Override
    public void addToCart(IOrder order) {
        cartItems.put(order, cartItems.getOrDefault(order, 0) + 1);

        //int quantity = cartItems.get(order);
        int eachPrice = order.getPrice();
        //int itemAmount = eachPrice * quantity;
        int discountPercentage = getDiscountPercentage(eachPrice);
        String category = getDiscountCategory(eachPrice);
        //int itemDiscount = ((itemAmount*discountPercentage)/100);
        categoryDisc.put(category, categoryDisc.getOrDefault(category, 0) + (((eachPrice * discountPercentage) / 100)));
    }

    // T = O(1)
    @Override
    public void removeFromCart(IOrder order) {
        if (cartItems.containsKey(order)) {
            cartItems.put(order, cartItems.get(order) - 1);
            if (cartItems.get(order) == 0) {
                cartItems.remove(order);
            }
            //int quantity = cartItems.get(order);
            int eachPrice = order.getPrice();
            //int itemAmount = eachPrice * quantity;
            int discountPercentage = getDiscountPercentage(eachPrice);
            String category = getDiscountCategory(eachPrice);
            //int itemDiscount = ((itemAmount*discountPercentage)/100);
            //categoryDisc.put(category, categoryDisc.getOrDefault(category, 0) + itemDiscount);
            categoryDisc.put(category, categoryDisc.get(category) - (((eachPrice * discountPercentage) / 100)));
        }
    }

    // T = O(n), Space = O(1)
    @Override
    public int calculateTotalAmount() {
        int sum = 0;

        for (Map.Entry<IOrder, Integer> entry : cartItems.entrySet()) {
            int quantity = entry.getValue(), eachPrice = entry.getKey().getPrice();
            int itemAmount = eachPrice * quantity;
            int discountPercentage = getDiscountPercentage(eachPrice);
            itemAmount -= ((itemAmount * discountPercentage) / 100);
            sum += itemAmount;
        }
        return sum;
    }

    // T = O(n), Space = O(n)
    // update : T = O(1)
    @Override
    public Map<String, Integer> categoryDiscounts() {
        /*Map<String, Integer> categoryDisc = new TreeMap<>((a,b) -> a.compareTo(b));
		for (Map.Entry<IOrder, Integer> entry : cartItems.entrySet()) {
            int quantity = entry.getValue(), eachPrice = entry.getKey().getPrice();
            int itemAmount = eachPrice * quantity;
            int discountPercentage = getDiscountPercentage(eachPrice);
            String category = getDiscountCategory(eachPrice);
            int itemDiscount = ((itemAmount*discountPercentage)/100);
            categoryDisc.put(category, categoryDisc.getOrDefault(category, 0) + itemDiscount);
        }*/
        return categoryDisc;
    }

    // T = O(n), Space = O(n)
    @Override
    public Map<String, Integer> cartItems() {
        Map<String, Integer> items = new TreeMap<>((a, b) -> a.compareTo(b));
        for (Map.Entry<IOrder, Integer> entry : cartItems.entrySet()) {
            items.put(entry.getKey().getName(), entry.getValue());
        }
        return items;
    }

    private int getDiscountPercentage(int price) {
        if (price > 0 && price <= 10) {
            return 10;
        } else if (price > 10 && price <= 20) {
            return 20;
        } else {
            return 30;
        }
    }

    private String getDiscountCategory(int price) {
        if (price > 0 && price <= 10) {
            return "Cheap";
        } else if (price > 10 && price <= 20) {
            return "Moderate";
        } else {
            return "Expensive";
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter textWriter = new PrintWriter(System.out);

        IOrderSystem orderSystem = new OrderSystem();
        int oCount = Integer.parseInt(br.readLine().trim());
        for (int i = 1; i <= oCount; i++) {
            String[] a = br.readLine().trim().split(" ");
            IOrder e = new Order();
            e.setName(a[0]);
            e.setPrice(Integer.parseInt(a[1]));
            orderSystem.addToCart(e);
        }
        int totalAmount = orderSystem.calculateTotalAmount();
        textWriter.println("Total Amount: " + totalAmount);

        Map<String, Integer> categoryDiscounts = orderSystem.categoryDiscounts();
        for (Map.Entry<String, Integer> entry : categoryDiscounts.entrySet()) {
            if (entry.getValue() > 0) {
                textWriter.println(entry.getKey() + " Category Discount: " + entry.getValue());
            }
        }

        Map<String, Integer> cartItems = orderSystem.cartItems();
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            textWriter.println(entry.getKey() + " (" + entry.getValue() + " items)");
        }

        textWriter.flush();
        textWriter.close();
    }
}


/**
 *

 Input Format For Custom Testing:
 Sample Case 1
 Sample Input For Custom Testing
 STDIN
 Function
 9
 Order-1 49
 Order-2 31
 Order-3 74
 Order-4 21
 Order-s 64
 Order-6 94
 Order-7 23
 Order-8 23
 Order-9 71

 number of orders n = 9
 •first order: name = 'Order-1', price = 49 second order...
 Sample Output:
 Total Amount: 319
 Expensive Category Discount: 131
 Order-1 (1 items)
 Order-2 (1 items)
 Order-3 (1 items)
 Order-4 (1 items)
 Order-5 (1 items)
 Order-6 (1 items)
 Order-7 (1 items)
 Order-8 (1 items)
 Order-9 (1 items)

 Explanation:
 9 orders are added and grouped by price category. All items are in the
 'Expensive' category, so only 1 group of items is reported. Data is read, method calls are made, and results are printed by the provided stub.
 • Sample Case 2
 Sample Input For Custom Testing
 Order-s 57
 Sample Output
 Total Amount: 40
 Expensive Category Discount: 17
 Order-1 (1 items)
 Explanation
 1 order is added, and it belongs to the 'Expensive' category. Data is read,
 method calls are made and results are printed by the provided stub

 *
 */
