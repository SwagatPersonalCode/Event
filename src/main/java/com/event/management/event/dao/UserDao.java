package com.event.management.event.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.event.management.event.entity.User;

public interface UserDao extends JpaRepository<User, Long> {

}
