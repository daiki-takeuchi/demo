package com.example.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by DaikiTakeuchi on 2016/11/24.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select * from product where product_code = :productCode limit 1", nativeQuery = true)
    Product findByPk(@Param("productCode") String productCode);

    @Query(name = "Product.findByDescriptionOrderByProductName")
    List<Product> findByDescOrderByProductName(@Param("desc") String desc);

}