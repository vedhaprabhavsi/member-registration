package com.cognizant.memberregistration.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document
public class Dependent {
	
	@Id
	private String memberId;
	private String dname;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date ddob;
	

	public Dependent() {
		super();
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public String getDname() {
		return dname;
	}


	public void setDname(String dname) {
		this.dname = dname;
	}


	public Date getDdob() {
		return ddob;
	}


	public void setDdob(Date ddob) {
		this.ddob = ddob;
	}	
}
