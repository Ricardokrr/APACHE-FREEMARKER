package model;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class User implements Serializable {

	private static final long serialVersionUID = 8244917722011784069L;

	private String email = null;

	private String name = null;

	private String surname = null;

	private String gender = null;

	private List<Planning> plannings = null;

	public User() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String arg) {
		this.email = arg;
	}

	public String getName() {
		return name;
	}

	public void setName(String arg) {
		this.name = arg;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String arg) {
		this.surname = arg;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String arg) {
		this.gender = arg;
	}

	public List<Planning> getPlannings() {
		return plannings;
	}

	public void setPlannings(List<Planning> args) {
		this.plannings = args;
	}
	
	public String getFullName() {
		if (StringUtils.isNotBlank(getName()) && StringUtils.isNotBlank(getSurname())) {
			return getName() + " "+ getSurname();
		} else if (StringUtils.isNotBlank(getName())) {
			return getName();
		} else if (StringUtils.isNotBlank(getSurname())) {
			return getSurname();
		}
		return "";
	}

}
