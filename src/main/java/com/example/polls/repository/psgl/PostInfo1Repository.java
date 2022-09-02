package com.example.polls.repository.psgl;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.polls.model.psgl.PostInfoPg;


@Repository
public interface PostInfo1Repository extends JpaRepository<PostInfoPg, Long> {

}
