package model;

import java.io.Serializable;

public class Planning implements Serializable {

	private static final long serialVersionUID = -8330931803299214645L;

	private String course = null;
	
	private String dateStart = null;

	private String dateEnd = null;
	
	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	
	public String getDateStart() {
		return dateStart;
	}

	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}

	public String getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}
	
}
