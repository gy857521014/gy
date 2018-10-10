package com.zd.entity;

public class sendemail {
		private String senderEmail;
		private String human_email;
		private String emailTitle;
		private String eidaa;
		
		public String getSenderEmail() {
			return senderEmail;
		}
		public void setSenderEmail(String senderEmail) {
			this.senderEmail = senderEmail;
		}
		public String getHuman_email() {
			return human_email;
		}
		public void setHuman_email(String human_email) {
			this.human_email = human_email;
		}
		public String getEmailTitle() {
			return emailTitle;
		}
		public void setEmailTitle(String emailTitle) {
			this.emailTitle = emailTitle;
		}
		public String getEidaa() {
			return eidaa;
		}
		public void setEidaa(String eidaa) {
			this.eidaa = eidaa;
		}
		public sendemail(String senderEmail, String human_email, String emailTitle, String eidaa) {
			super();
			this.senderEmail = senderEmail;
			this.human_email = human_email;
			this.emailTitle = emailTitle;
			this.eidaa = eidaa;
		}
		public sendemail() {
			super();
		}
		
		
	}

