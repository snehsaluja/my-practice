package com.practice.mypractice.interview4.service;

import com.practice.mypractice.interview4.repository.ProductRepositoryProxy;

public class ProductService {

    private ProductRepositoryProxy productRepository;

    ProductService(ProductRepositoryProxy productRepository){
        this.productRepository = productRepository;
    }

    public String getProductById(int id) {

        return productRepository.findProductById(id);

    }

}
