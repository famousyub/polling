package com.example.polls.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.polls.model.PostInfo;

@Repository
public interface PostInfoRepository  extends JpaRepository<PostInfo, Long>{
	
	
	@Query("select p from PostInfo p order by   p.id desc ")
	List<PostInfo>  getAllpostsInfo();

}
