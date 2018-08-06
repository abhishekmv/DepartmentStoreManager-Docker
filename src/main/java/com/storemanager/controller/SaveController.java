/*
 * Copyright (C) 2018 Abhishek M. Vijaya Kumar.
 * All rights reserved.
 */
package com.storemanager.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.storemanager.model.ProductDetails;
import com.storemanager.repo.StoreManagerRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "API Description")
// @ActiveProfiles("save") to test only
@Profile("save")
public class SaveController {

    @Autowired
    StoreManagerRepository repository;

    // @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    // public void addProductDetails(@RequestBody ProductDetails product) {
    //
    // repository.save(new ProductDetails(product.getProductName(), product.getCategory(), product.getQuantity(),
    // product.getPrice()));
    // }

    @ApiOperation(value = "It will save all the product entered")
    @GetMapping("/saveAll")
    public String process() {
        // save a single product
        repository.save(new ProductDetails("Rice", "Pulse", 5, 4));

        // save a list of product
        repository.saveAll(Arrays.asList(new ProductDetails("carrot", "vegetable", 5, 2),
                new ProductDetails("corns", "vegetable", 1, 4), new ProductDetails("salted chips", "Bakery", 10, 5)));

        return "Done";
    }

    @ApiOperation(value = "API Description", hidden = true)
    @GetMapping("/test")
    public String testDocker() {
        String result = "The application is working. huuurrrray";
        return result;
    }
}
