package edu.ucam.practicafinaldad.back;

public class Email {
	
	private String emailId;
	private String subject;
	private String body;
	
	public Email(String emailId, String subject, String body) {
		this.subject = subject;
		this.body = body;
		this.emailId = emailId;
	}
	
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
