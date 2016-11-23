package com.example.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by DaikiTakeuchi on 2016/11/24.
 */
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

    @Query(value = "select * from order_detail where order_number = :orderNumber and product_code = :productCode limit 1", nativeQuery = true)
    OrderDetail findByPk(@Param("orderNumber") Long orderNumber, @Param("productCode") String productCode);

}