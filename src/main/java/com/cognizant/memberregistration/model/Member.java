package com.cognizant.memberregistration.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document
public class Member {
	
	@Transient
	public static final String SEQUENCE_NAME="member_sequence";
	
	@Id
	private String memberId;
	private String name;
	private String address; 
	private String country;
	private String state;
	private String email;
	private String pan;
	private Long contactNum;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dob;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date regDate;
	private int age;
	
	private List<Dependent> dependent;

	public Member() {
		super();
	}

	public List<Dependent> getDependent() {
		return dependent;
	}



	public void setDependent(List<Dependent> dependent) {
		this.dependent = dependent;
	}



	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public Long getContactNum() {
		return contactNum;
	}

	public void setContactNum(Long contactNum) {
		this.contactNum = contactNum;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", name=" + name + ", address=" + address + ", country=" + country
				+ ", state=" + state + ", email=" + email + ", pan=" + pan + ", contactNum=" + contactNum + ", dob="
				+ dob + ", regDate=" + regDate + ", age=" + age + ", dependent=" + dependent + "]";
	}

}
