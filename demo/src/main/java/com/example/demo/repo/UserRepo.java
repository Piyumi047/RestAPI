package com.example.demo.repo;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,Integer> {
    @Query(value = "SELECT * FROM User WHERE id= ?1", nativeQuery = true)
    User getUserByUserId(String userId);

    @Query(value = "SELECT * FROM User WHERE Id= ?1 AND ADDRESS= ?2", nativeQuery = true)
    User getUserByUserIdAndAddress(String userId, String address);
}