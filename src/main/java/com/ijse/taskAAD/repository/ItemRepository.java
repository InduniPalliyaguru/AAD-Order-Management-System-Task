package com.ijse.taskAAD.repository;

import com.ijse.taskAAD.dto.ItemDTO;
import com.ijse.taskAAD.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query (value = "SELECT i FROM OrderItem oi " +
            "JOIN Item i ON oi.item = i " +
            "JOIN Order o ON oi.order = o " +
            "WHERE o.orderId = ?1")
    List<Item> filterItemsByOrderId01(Long orderId);

    @Query (value = "SELECT oi.item FROM OrderItem oi " +
            "WHERE oi.order.orderId = ?1")
    List<Item> filterItemsByOrderId02(Long orderId);

    @Query (value = "SELECT new com.ijse.taskAAD.dto.ItemDTO(i.itemId, i.name, i.price) " +
            "FROM Item i WHERE (?1 IS NULL OR i.name LIKE %?1%)")
    List<ItemDTO> filterItems(String itemName);

    @Query (value = "SELECT new com.ijse.taskAAD.dto.ItemDTO(i.itemId, i.name, i.price) FROM OrderItem oi " +
            "JOIN Item i ON oi.item = i " +
            "JOIN Order o ON oi.order = o " +
            "WHERE o.orderId = ?1")
    List<ItemDTO> filterItemsByOrderId03(Long orderId);

}
