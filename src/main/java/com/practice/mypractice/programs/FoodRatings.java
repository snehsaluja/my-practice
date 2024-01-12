package com.practice.mypractice.programs;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FoodRatings {

    Map<String, PriorityQueue<Food>> cuisineFoodMap = new HashMap<>();
    Map<String, Food> foodCuisineMap = new HashMap<>();

    class Food {
        String foodName;
        String cuisine;
        int rating;

        Food(String f, String c, int r) {
            foodName = f;
            cuisine = c;
            rating = r;
        }
    }

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            Food f = new Food(foods[i], cuisines[i], ratings[i]);
            foodCuisineMap.put(foods[i], f);
            PriorityQueue<Food> pq = cuisineFoodMap.getOrDefault(cuisines[i],
                    new PriorityQueue<>((o1, o2) -> {
                        int diff = o2.rating - o1.rating;
                        if (diff == 0) {
                            return o1.foodName.compareTo(o2.foodName);
                        }
                        return diff;
                    }));
            pq.add(f);
            cuisineFoodMap.put(cuisines[i], pq);
        }
    }

    public void changeRating(String food, int newRating) {
        Food f = foodCuisineMap.get(food);
        Food currFood = new Food(food, f.cuisine, newRating);
        cuisineFoodMap.get(f.cuisine).add(currFood);
        f.foodName = "";
        foodCuisineMap.put(food, currFood);
        /* Iterator<Food> iterator = pq.iterator();
        Food nextFood = null;
        while (iterator.hasNext()) {
            nextFood = iterator.next();
            if (nextFood.foodName.equals(food)) {
                //nextFood.rating = newRating;
                break;
            }
        }
        if (nextFood != null)
            pq.remove(nextFood);
        pq.add(new Food(food, f.cuisine, newRating)); */
    }

    public String highestRated(String cuisine) {
        while (cuisineFoodMap.get(cuisine).peek().foodName.equals("")) {
            cuisineFoodMap.get(cuisine).remove();
        }
        return cuisineFoodMap.get(cuisine).peek().foodName;
    }

    public static void main(String[] args) {
        String[] foods = {"emgqdbo", "jmvfxjohq", "qnvseohnoe", "yhptazyko", "ocqmvmwjq"};
        String[] cuisine = {"snaxol", "snaxol", "snaxol", "fajbervsj", "fajbervsj"};
        int[] ratings = {2, 6, 18, 6, 5};
        FoodRatings fr = new FoodRatings(foods, cuisine, ratings);
        fr.changeRating("qnvseohnoe", 11);
        System.out.println(fr.highestRated("fajbervsj"));
        fr.changeRating("emgqdbo", 3);
        fr.changeRating("jmvfxjohq", 9);
        fr.changeRating("emgqdbo", 14);
        System.out.println(fr.highestRated("fajbervsj"));
        System.out.println(fr.highestRated("snaxol"));

    }
}

