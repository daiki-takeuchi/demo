package com.example.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by DaikiTakeuchi on 2016/11/23.
 */
@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

    @Query(value = "select * from orders where order_number = :orderNumber limit 1", nativeQuery = true)
    Orders findByPk(@Param("orderNumber") Long orderNumber);

    @Query(value = "select customerNumber from Orders where id = :id")
    Long getCustomerNumber(@Param("id") Long id);

    @Query(name = "Orders.findByOrderDateRange")
    List<Orders> findByOrderDateRange(@Param("from") Date from, @Param("to") Date to);

    @Modifying(clearAutomatically = true)
    @Query(value = "update Orders o set o.comments = :comments where o.orderNumber = :orderNumber")
    Integer updateComments(@Param("orderNumber") Long orderNumber, @Param("comments") String comments);

}
