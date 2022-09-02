package com.example.polls.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.polls.model.Gameuser;

@Repository
public interface GameUserRepository extends JpaRepository<Gameuser, Long>{

}
