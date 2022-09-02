package com.example.polls.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.polls.model.Networks;

@Repository
public interface NetworkRepository extends JpaRepository<Networks, Long> {

}
