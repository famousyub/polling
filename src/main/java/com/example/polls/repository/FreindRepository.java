package com.example.polls.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.polls.model.Freind;
import com.example.polls.model.User;


@Repository
public interface FreindRepository   extends JpaRepository<Freind, Long> {
	
	 boolean existsByFirstUserAndSecondUser(User first,User second);

	    List<Freind> findByFirstUser(User user);
	    List<Freind> findBySecondUser(User user);

}
