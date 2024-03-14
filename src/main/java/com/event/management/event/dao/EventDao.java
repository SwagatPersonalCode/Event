package com.event.management.event.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.event.management.event.entity.Event;

@Repository
public interface EventDao extends JpaRepository<Event, Long>{

}
