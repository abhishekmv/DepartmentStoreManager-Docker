
package com.storemanager.repo;

import org.springframework.data.repository.CrudRepository;

import com.storemanager.model.ProductDetails;

public interface StoreManagerRepository extends CrudRepository<ProductDetails, Long> {
    // @Query
    // List<ProductDetails> findProduct(@Param(value = "productname") String productname);
}
