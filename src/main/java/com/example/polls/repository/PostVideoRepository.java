package com.example.polls.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.polls.model.PostVideo;

@Repository
public interface PostVideoRepository extends JpaRepository<PostVideo, Long> {
	
	
	 @Modifying
	    @Query("update PostVideo set compressedFilePath = ?2, compressed = true where id = ?1")
	    int convertFileSuccess(Long id, String path);

	    @Modifying
	    @Query("update PostVideo set thumbnailPath = ?2, thumbnail = true where id = ?1")
	    int generateThumbnail(Long id, String thumbnailPath);

}
