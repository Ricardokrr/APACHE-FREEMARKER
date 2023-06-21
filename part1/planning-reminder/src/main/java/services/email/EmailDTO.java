package services.email;

import java.io.Serializable;

public class EmailDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String fromAddress;

	private String fromName;

	private String toAddress;

	private String subject;
	
	private String message;

	public EmailDTO() {
		super();
	}

	public String getFromAddress() {
		return fromAddress;
	}
	
	public void setFromAddress(String fromAddressValue) {
		this.fromAddress = fromAddressValue;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromNameValue) {
		this.fromName = fromNameValue;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddressValue) {
		this.toAddress = toAddressValue;
	}
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subjectValue) {
		this.subject = subjectValue;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String messageValue) {
		this.message = messageValue;
	}

}
