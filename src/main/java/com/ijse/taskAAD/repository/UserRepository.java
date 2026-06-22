package com.ijse.taskAAD.repository;

import com.ijse.taskAAD.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // JPQL
    @Query (value = "SELECT u FROM User u WHERE u.role = 'CUSTOMER'")
    List<User> getAllCustomers();

}
