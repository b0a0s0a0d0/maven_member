package bean;

import java.io.Serializable;

public class MemberInfoHope implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer memberId;
	private Integer interestId;
	private String insterest;
	private String bodyType;
	private Integer marriage;
	private String education;
	private Integer smoking;
	private String drink;
	private String ethnicity;
	private String religion;
	private Integer salary;
	
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Integer getInterestId() {
		return interestId;
	}
	public void setInterestId(Integer interestId) {
		this.interestId = interestId;
	}
	public String getInsterest() {
		return insterest;
	}
	public void setInsterest(String insterest) {
		this.insterest = insterest;
	}
	public String getBodyType() {
		return bodyType;
	}
	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}
	public Integer isMarriage() {
		return marriage;
	}
	public void setMarriage(Integer marriage) {
		this.marriage = marriage;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public Integer isSmoking() {
		return smoking;
	}
	public void setSmoking(Integer smoking) {
		this.smoking = smoking;
	}
	public String getDrink() {
		return drink;
	}
	public void setDrink(String drink) {
		this.drink = drink;
	}
	public String getEthnicity() {
		return ethnicity;
	}
	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
