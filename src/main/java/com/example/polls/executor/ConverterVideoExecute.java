package com.example.polls.executor;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.polls.model.PostVideo;
//import com.example.polls.service.UploadMediaService;
//import com.example.polls.util.CompressedMediaVideoUtil;

//@Component
//public class ConverterVideoExecute {
//	
//	 @Autowired
//	 private CompressedMediaVideoUtil compress;
//
//	    @Autowired
//	    private UploadMediaService service;
//
//	    public void scaleVideo(Map<String, Object> value) {
//	        PostVideo media = new PostVideo();
//	        media.setId(Long.parseLong( value.get("id").toString()));
//	        media.setOriginalFilePath(value.get("original_path").toString());
//	        try {
//	            String compressedPath = compress.convertVideo(media.getOriginalFilePath(), "mp4");
//	            media.setCompressedFilePath(compressedPath);
//	            media.setCompressed(true);
//	            service.compressed(media);
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	    }
//
//	    public void generateThumbnail(Map<String, Object> value) {
//	    	PostVideo media = new PostVideo();
//	        media.setId(Long.parseLong( value.get("id").toString()));
//	        media.setOriginalFilePath(value.get("original_path").toString());
//	        try {
//	            String compressedPath = compress.generateThumbnail(media.getOriginalFilePath());
//	            media.setThumbnailPath(compressedPath);
//	            media.setThumbnail(true);
//	            service.thumbnail(media);
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	    }
//
//}
