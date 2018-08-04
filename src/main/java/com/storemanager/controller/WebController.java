package com.storemanager.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.storemanager.model.ProductDetails;
import com.storemanager.repo.StoreManagerRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "API Description")
// @Profile("dev")
public class WebController {

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

    @ApiOperation(value = "It will return list of all the available products")
    @GetMapping("/findall")
    public String findAll() {
        String result = "";

        for (ProductDetails p : repository.findAll()) {
            result += p.toString() + "<br>";
        }

        return result;
    }

    @ApiOperation(value = "It will return each product buy its id")
    @GetMapping("/findbyid")
    public String findById(@RequestParam("id") long id) {
        String result = "";
        result = repository.findById(id).toString();
        return result;
    }

    @ApiOperation(value = "API Description", hidden = true)
    @GetMapping("/test")
    public String testDocker() {
        String result = "The application is working. huuurrrray";
        return result;
    }

    // @RequestMapping("/findbyproductname")
    // public String fetchDataByProductName(@RequestParam("productname") String productname) {
    // String result = "";
    //
    // for (ProductDetails p : repository.findProduct(productname)) {
    // result += p.toString() + "<br>";
    // }
    // return result;
    // }
}
