package com.event.management.event.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.event.management.event.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.userName LIKE %:userName%")
    List<User> findByUserName(String userName);
}
