package com.example.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by DaikiTakeuchi on 2016/11/24.
 */
@Repository
public interface ProductLineRepository extends JpaRepository<ProductLine, Long> {

    @Query(value = "select * from product_line where product_line = :productLine limit 1", nativeQuery = true)
    ProductLine findByPk(@Param("productLine") String productLine);

}