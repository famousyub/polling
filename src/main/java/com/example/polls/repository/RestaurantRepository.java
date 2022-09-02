package com.example.polls.repository;

import java.lang.annotation.Retention;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.polls.model.Restaurants;
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurants, Long> {

}
