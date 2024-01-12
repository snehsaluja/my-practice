package com.practice.mypractice.programs;

/*
Given the following data set, find the coupon to display for a given category.

Note: Category structure is hierarchical. Categories without coupons inherit their parent’s coupon.

data
Coupons = [
{"CategoryName":"Comforter Sets", "CouponName":"Comforters Sale"},
{"CategoryName":"Bedding", "CouponName":"Savings on Bedding"},
{"CategoryName":"Bed & Bath", "CouponName":"Low price for Bed & Bath"}
]

Categories = [
{"CategoryName":"Comforter Sets", "CategoryParentName":"Bedding"},
{"CategoryName":"Bedding", "CategoryParentName":"Bed & Bath"},
{"CategoryName":"Bed & Bath", "CategoryParentName":null},
{"CategoryName":"Soap Dispensers", "CategoryParentName":"Bathroom Accessories"},
{"CategoryName":"Bathroom Accessories", "CategoryParentName":"Bed & Bath"},
{"CategoryName":"Toy Organizers", "CategoryParentName":"Baby And Kids"},
{"CategoryName":"Baby And Kids", "CategoryParentName":null}
]

tests: input(CategoryName) => output(CouponName)
"Comforter Sets" => "Comforters Sale"
"Bedding" => "Savings on Bedding"
"Bathroom Accessories" => "Low price for Bed & Bath"
"Soap Dispensers" => "Low price for Bed & Bath"
"Toy Organizers" => null

Followup Question
The system has added a new piece of data to the coupon - “Date Modified”. Use this when resolving any ties.

Coupons = [

{ "CategoryName":"Comforter Sets", "CouponName":"Comforters Sale", "DateModified":"2021-01-01" },
{ "CategoryName":"Comforter Sets", "CouponName":"Cozy Comforter Coupon", "DateModified":"2020-01-01" },
{ "CategoryName":"Bedding", "CouponName":"Best Bedding Bargains", "DateModified":"2019-01-01" },
{ "CategoryName":"Bedding", "CouponName":"Savings on Bedding", "DateModified":"2019-01-01" },
{ "CategoryName":"Bed & Bath", "CouponName":"Low price for Bed & Bath", "DateModified":"2018-01-01" },
{ "CategoryName":"Bed & Bath", "CouponName":"Bed & Bath extravaganza", "DateModified":"2019-01-01" },
{ "CategoryName":"Bed & Bath", "CouponName":"Big Savings for Bed & Bath", "DateModified":"2030-01-01" }

]
*/

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

public class Coupons {

    public static void main(String[] args) throws IOException {
        Map<String, String> coupons = new HashMap<>();
        coupons.put("Comforter Sets", "Comforters Sale");
        coupons.put("Bedding", "Savings on Bedding");
        coupons.put("Bed & Bath", "Low price for Bed & Bath");

        Map<String, String> categoriesParentMap = new HashMap<>();
        categoriesParentMap.put("Comforter Sets", "Bedding");
        categoriesParentMap.put("Bedding", "Bed & Bath");
        categoriesParentMap.put("Bed & Bath", null);
        categoriesParentMap.put("Soap Dispensers", "Bathroom Accessories");
        categoriesParentMap.put("Bathroom Accessories", "Bed & Bath");
        categoriesParentMap.put("Toy Organizers", "Baby And Kids");
        categoriesParentMap.put("Baby And Kids", null);

        System.out.println("Comforter Sets = " + getCoupon("Comforter Sets", coupons, categoriesParentMap));
        System.out.println("Bedding = " + getCoupon("Bedding", coupons, categoriesParentMap));
        System.out.println("Bathroom Accessories = " + getCoupon("Bathroom Accessories", coupons, categoriesParentMap));
        System.out.println("Soap Dispensers = " + getCoupon("Soap Dispensers", coupons, categoriesParentMap));
        System.out.println("Toy Organizers = " + getCoupon("Toy Organizers", coupons, categoriesParentMap));
        System.out.println("Bed & Bath = " + getCoupon("Bed & Bath", coupons, categoriesParentMap));
        System.out.println("Baby And Kids = " + getCoupon("Baby And Kids", coupons, categoriesParentMap));

        //init();
    }

    public static void init() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ClassPathResource classPathResource = new ClassPathResource("config/couponsConfig.json");
        JsonNode jsonNode = objectMapper.readTree(classPathResource.getInputStream());
        var coupons = objectMapper.convertValue(jsonNode.get("Coupons"), Map.class);
        var categoriesParentMap = objectMapper.convertValue(jsonNode.get("Categories"), Map.class);

        System.out.println(coupons);
        System.out.println(categoriesParentMap);
    }

    private static String getCoupon(String category, Map<String, String> coupons, Map<String, String> categoriesParentMap) {

        String parent;
        if (coupons.containsKey(category)) {
            return coupons.get(category);
        } else {
            while (true) {
                parent = categoriesParentMap.get(category);
                if (parent == null || parent.isEmpty()) {
                    break;
                }
                if (coupons.containsKey(parent)) {
                    return coupons.get(parent);
                }
                category = parent;
            }
        }
        return null;
    }

}
