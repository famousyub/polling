package com.example.polls.service;
import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFmpegUtils;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;
import net.bramp.ffmpeg.progress.Progress;
import net.bramp.ffmpeg.progress.ProgressListener;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.polls.dao.UploadMediaDao;
import com.example.polls.exception.ResourceNotFoundException;
import com.example.polls.model.PostVideo;
import com.example.polls.model.TypeOfMedia;
import com.example.polls.model.User;
import com.example.polls.repository.UserRepository;
import com.example.polls.security.UserPrincipal;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

//@Service
//public class FileStoreService {
//	
//	
//	private Logger log = LoggerFactory.getLogger(FileStoreService.class);
//
//    FFmpeg ffmpeg = null;
//    FFprobe ffprobe = null;
//    
//    
//   @Autowired
//	UserRepository userrepo;
//
//   @Autowired
//    private UploadMediaDao dao;
//    
//   // @Autowired
//    public FileStoreService(
//            @Value("${server.compression.ffmpeg}") String ffmpegPath,
//            @Value("${server.compression.ffprobe}") String ffprobePath
//           
//            
//    		
//    		) throws IOException {
//    	
//    	this.dao= dao ;
//    	this.userrepo=userrepo;
//        ffmpeg = new FFmpeg();
//        if (!StringUtils.isEmpty(ffmpegPath))
//            ffmpeg = new FFmpeg(ffmpegPath);
//
//        ffprobe = new FFprobe();
//        if (!StringUtils.isEmpty(ffprobePath))
//            ffprobe = new FFprobe(ffprobePath);
//
//    }
//
//   
//
//    public static String getHomeDir() {
//        return System.getProperty("user.home");
//    }
//
//    public PostVideo createFile(MultipartFile file, TypeOfMedia type,UserPrincipal me) throws IOException {
//       
//    	
//    	PostVideo media = new PostVideo();
//    	String username =me.getUsername();
//		 User user = userrepo.findByUsername(me.getUsername())
//	                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
//		
//		 
//    	String dirPath = new StringBuilder(getHomeDir()).append(File.separator)
//                .append(type.toString()).append(File.separator)
//                .append("original").append(File.separator)
//                .append(LocalDate.now()).toString();
//
//        String fileName = String.format(
//                "%s.%s",
//                UUID.randomUUID().toString(),
//                FilenameUtils.getExtension(file.getOriginalFilename())
//        );
//
//        File dir = new File(dirPath);
//        if (!dir.exists()) {
//            dir.mkdirs();
//        }
//
//        String location = new StringBuilder(dirPath).append(File.separator).append(fileName).toString();
//        Path path = Paths.get(location);
//        Files.write(path, file.getBytes());
//        
//        media.setUser(user);
//        media.setOriginalFileName(Paths.get(file.getOriginalFilename()).getFileName().toString());
//        media.setOriginalFileExtension(FilenameUtils.getExtension(media.getOriginalFileName()));
//        media.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
//        media.setWrite(false);
//        media.setCompressed(false);
//       
//        media.setOriginalFilePath(path.toString());
//        dao.upload(media);
//        log.info(location);
//        return dao.upload(media);
//    }
//
//    public void convertVideo(String fileName, String format) throws IOException {
//        String dirPath = new StringBuilder(getHomeDir()).append(File.separator)
//                .append(TypeOfMedia.Videos).append(File.separator)
//                .append("compressed").append(File.separator)
//                .append(LocalDate.now()).toString();
//
//        File dir = new File(dirPath);
//        if (!dir.exists()) {
//            dir.mkdirs();
//        }
//
//        FFmpegProbeResult input = ffprobe.probe(fileName);
//
//        FFmpegBuilder builder = new FFmpegBuilder()
//                .setInput(input).overrideOutputFiles(true)
//
//                .addOutput(new StringBuilder(dirPath)
//                        .append(File.separator).append(UUID.randomUUID().toString()).append(".").append(format).toString())
//                .setFormat(format)
//                .disableSubtitle()
//
////                config audio
//                .setAudioChannels(1)
//                .setAudioCodec("aac")
//                .setAudioSampleRate(48_000)
//                .setAudioBitRate(32_768)
//
////                config video
//                .setVideoCodec("libx264")
//                .setVideoFrameRate(24, 1)
//                .setVideoResolution(640, 480)
//
//                .setStrict(FFmpegBuilder.Strict.EXPERIMENTAL)
//                .done();
//
//        FFmpegExecutor executor = new FFmpegExecutor(ffmpeg, ffprobe);
//        executor.createJob(builder, new ProgressListener() {
//
//            final double duration_ns = input.getFormat().duration * TimeUnit.SECONDS.toNanos(1);
//
//            @Override
//            public void progress(Progress progress) {
//                double percentage = progress.out_time_ns / duration_ns;
//                log.info("filename: {} -> {} status: {} time: {} ms",
//                        input.getFormat().filename,
//                        String.format("[%.0f%%]", (percentage * 100)),
//                        progress.status,
//                        FFmpegUtils.toTimecode(progress.out_time_ns, TimeUnit.NANOSECONDS)
//                );
//            }
//        }).run();
//    }
//
//    public void getThumbnailByVideo(String filePath) {
//    }
//}
