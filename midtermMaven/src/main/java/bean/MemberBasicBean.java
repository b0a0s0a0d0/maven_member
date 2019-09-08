package bean;

import java.io.Serializable;
import java.sql.Date;

public class MemberBasicBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer memberId;
	private String memberEmail;
	private String memberPassword;
	private String memberName;
	private Date memberBirth;
	private Integer memberSex;
	private String memberCity;
	private Integer vipStatus;


	public Integer getMemberId() {
		return memberId;
	}


	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}


	public String getMemberEmail() {
		return memberEmail;
	}


	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}


	public String getMemberPassword() {
		return memberPassword;
	}


	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	public Date getMemberBirth() {
		return memberBirth;
	}


	public void setMemberBirth(Date memberBirth) {
		this.memberBirth = memberBirth;
	}


	public Integer getMemberSex() {
		return memberSex;
	}


	public void setMemberSex(Integer memberSex) {
		this.memberSex = memberSex;
	}


	public String getMemberCity() {
		return memberCity;
	}


	public void setMemberCity(String memberCity) {
		this.memberCity = memberCity;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Integer getVipStatus() {
		return vipStatus;
	}


	public void setVipStatus(Integer vipStatus) {
		this.vipStatus = vipStatus;
	}

}
