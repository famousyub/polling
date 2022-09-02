package com.example.polls.dao;


import com.example.polls.model.PostVideo;
import com.example.polls.repository.PostVideoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UploadMediaDao {

    @Autowired
    private PostVideoRepository repository;

    public Optional<PostVideo> findById(Long id) {
        return repository.findById(id);
    }

    public PostVideo upload(PostVideo value) {
        return repository.save(value);
    }

    public void convert(PostVideo value) {
        repository.convertFileSuccess(value.getId(), value.getCompressedFilePath());
    }

    public void generateThumbnail(PostVideo media) {
        repository.generateThumbnail(media.getId(), media.getThumbnailPath());
    }
}
