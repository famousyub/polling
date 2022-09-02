package com.example.polls.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.polls.model.PostGallery;

@Repository
public interface PostGalleryRepository  extends JpaRepository<PostGallery, Long>{

}
