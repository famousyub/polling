package com.example.polls.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.polls.model.Contactus;

@Repository
public interface ContactusRepository extends JpaRepository<Contactus, Long> {
 
}
