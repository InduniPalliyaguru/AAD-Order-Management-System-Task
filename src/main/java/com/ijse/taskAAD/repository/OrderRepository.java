package com.ijse.taskAAD.repository;

import com.ijse.taskAAD.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "SELECT * FROM orders o" +
            "JOIN customer c ON o.customer_id = c.customer_id" +
            "WHERE (?1 IS NULL OR c.name LIKE %?1%)", nativeQuery = true)
    List<Order> findByCustomerName(String name);
}
