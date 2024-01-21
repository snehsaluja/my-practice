package com.practice.mypractice.interview4.repository;

import java.util.Map;

import com.practice.mypractice.interview4.cache.LFUCache;
import com.practice.mypractice.interview4.cache.LRUCache;

public class ProductCacheRepository extends ProductRepositoryProxy {

    // @Value("caching.strategy")
    String cachingStrategy;


    @Override
    public String findProductById(int id) {

        if(cachingStrategy.equals("LRU")){
            // LRUCache's object
        } else if(cachingStrategy.equals("LFU")) {
            // LFUCache's object
        }


        return null;
    }


    // Map<Integer (key) , ValueObject : String val, int index>
}


/*                           2
                    4           3
                10    15       12     16
              18 20  17,16    13,14   21,22

              */




