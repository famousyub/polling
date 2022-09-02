package com.example.polls.service;


//import org.apache.commons.io.FilenameUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.example.polls.dao.UploadMediaDao;
//import com.example.polls.exception.ResourceNotFoundException;
//import com.example.polls.model.PostVideo;
//import com.example.polls.model.User;
//import com.example.polls.repository.UserRepository;
//import com.example.polls.security.UserPrincipal;
////import com.example.polls.util.FileStorageUtil;
//
//import java.io.IOException;
//import java.nio.file.Paths;
//import java.sql.Timestamp;
//import java.time.LocalDateTime;
//import java.util.Optional;
//
//@Service
//@Transactional(readOnly = true)
//public class UploadMediaService {
//
//    @Autowired
//    private UploadMediaDao dao;
//    
//	@Autowired
//	UserRepository userrepo;
//
//    @Autowired
//    private FileStorageUtil storageUtil;
//
//    public byte[] getFile(String path) throws IOException {
//        return storageUtil.getFile(path);
//    }
//
//    public Optional<PostVideo> findById(Long id) {
//        return dao.findById(id);
//    }
//
//    @Transactional
//    public PostVideo createFile(UserPrincipal currentUser,MultipartFile file) throws IOException {
//    	PostVideo media = new PostVideo();
//    	
//    	String username =currentUser.getUsername();
//		 User user = userrepo.findByUsername(currentUser.getUsername())
//	                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
//		
//		 
//		media.setUser(user);
//        media.setOriginalFileName(Paths.get(file.getOriginalFilename()).getFileName().toString());
//        media.setOriginalFileExtension(FilenameUtils.getExtension(media.getOriginalFileName()));
//        media.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
//        media.setWrite(false);
//        media.setCompressed(false);
//        String path = storageUtil.createFile(file);
//        media.setOriginalFilePath(path);
//        return dao.upload(media);
//    }
//
//    @Transactional
//    public void compressed(PostVideo media) {
//        dao.convert(media);
//    }
//
//    @Transactional
//    public void thumbnail(PostVideo media) {
//        dao.generateThumbnail(media);
//    }
//
//}