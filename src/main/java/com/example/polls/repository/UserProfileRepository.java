package com.example.polls.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.polls.model.UserProfile;


@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
	
	Optional<UserProfile>  findByuserId(Long user_id);

}
