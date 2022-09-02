package com.example.polls.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.example.polls.model.audit.DateAudit;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="postvideo")
public class PostVideo extends DateAudit {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
	
	
	    @JsonIgnore
	    @Column(name = "original_path")
	    @Type(type = "text")
	    public String originalFilePath;

	    @Column(name = "original_file_name", nullable = false)
	    @Type(type = "text")
	    public String originalFileName;

	    @Column(name = "original_file_ext", nullable = false)
	    public String originalFileExtension;

	    @JsonIgnore
	    @Column(name = "is_write")
	    private boolean write;

	    @JsonIgnore
	    @Column(name = "compressed_path")
	    @Type(type = "text")
	    public String compressedFilePath;

	    @JsonIgnore
	    @Column(name = "is_compressed")
	    private boolean compressed;

	    @JsonIgnore
	    @Column(name = "thumbnail_path")
	    @Type(type = "text")
	    private String thumbnailPath;

	    @JsonIgnore
	    @Column(name = "is_thumbnail")
	    private boolean thumbnail;

	    @Column(name = "created_by")
	    private String createdBy;

	    @Column(name = "created_date", nullable = false)
	    private Timestamp createdDate;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public String getOriginalFilePath() {
			return originalFilePath;
		}

		public void setOriginalFilePath(String originalFilePath) {
			this.originalFilePath = originalFilePath;
		}

		public String getOriginalFileName() {
			return originalFileName;
		}

		public void setOriginalFileName(String originalFileName) {
			this.originalFileName = originalFileName;
		}

		public String getOriginalFileExtension() {
			return originalFileExtension;
		}

		public void setOriginalFileExtension(String originalFileExtension) {
			this.originalFileExtension = originalFileExtension;
		}

		public boolean isWrite() {
			return write;
		}

		public void setWrite(boolean write) {
			this.write = write;
		}

		public String getCompressedFilePath() {
			return compressedFilePath;
		}

		public void setCompressedFilePath(String compressedFilePath) {
			this.compressedFilePath = compressedFilePath;
		}

		public boolean isCompressed() {
			return compressed;
		}

		public void setCompressed(boolean compressed) {
			this.compressed = compressed;
		}

		public String getThumbnailPath() {
			return thumbnailPath;
		}

		public void setThumbnailPath(String thumbnailPath) {
			this.thumbnailPath = thumbnailPath;
		}

		public boolean isThumbnail() {
			return thumbnail;
		}

		public void setThumbnail(boolean thumbnail) {
			this.thumbnail = thumbnail;
		}

		public String getCreatedBy() {
			return createdBy;
		}

		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}

		public Timestamp getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(Timestamp createdDate) {
			this.createdDate = createdDate;
		}

		public PostVideo(Long id, User user, String originalFilePath, String originalFileName,
				String originalFileExtension, boolean write, String compressedFilePath, boolean compressed,
				String thumbnailPath, boolean thumbnail, String createdBy, Timestamp createdDate) {
			super();
			this.id = id;
			this.user = user;
			this.originalFilePath = originalFilePath;
			this.originalFileName = originalFileName;
			this.originalFileExtension = originalFileExtension;
			this.write = write;
			this.compressedFilePath = compressedFilePath;
			this.compressed = compressed;
			this.thumbnailPath = thumbnailPath;
			this.thumbnail = thumbnail;
			this.createdBy = createdBy;
			this.createdDate = createdDate;
		}

		public PostVideo() {
			super();
		}
	    
	    

}
