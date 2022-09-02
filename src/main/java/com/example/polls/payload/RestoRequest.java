package com.example.polls.payload;

import com.example.polls.model.Location;

public class RestoRequest {
	
	 private String restoname;
	    private String restotype;
	    
	    private String restourl;
	    private String restoimage;
	    
	    private Location location ;

		public String getRestoname() {
			return restoname;
		}

		public void setRestoname(String restoname) {
			this.restoname = restoname;
		}

		public String getRestotype() {
			return restotype;
		}

		public void setRestotype(String restotype) {
			this.restotype = restotype;
		}

		public String getRestourl() {
			return restourl;
		}

		public void setRestourl(String restourl) {
			this.restourl = restourl;
		}

		public String getRestoimage() {
			return restoimage;
		}

		public void setRestoimage(String restoimage) {
			this.restoimage = restoimage;
		}

		public Location getLocation() {
			return location;
		}

		public void setLocation(Location location) {
			this.location = location;
		}
	    
	    

}
