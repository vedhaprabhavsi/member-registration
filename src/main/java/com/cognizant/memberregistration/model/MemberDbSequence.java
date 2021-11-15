package com.cognizant.memberregistration.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class MemberDbSequence {
	
	@Id
	private String id;
	private int seq;
		
	
	public MemberDbSequence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberDbSequence(String id, int seq) {
		this.id = id;
		this.seq = seq;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSeq() {
		return seq;
	}
	
}
