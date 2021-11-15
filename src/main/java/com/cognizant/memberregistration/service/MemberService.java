package com.cognizant.memberregistration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.memberregistration.model.Member;
import com.cognizant.memberregistration.repository.MemberRepository;


@Service
public class MemberService {
	
	@Autowired
	private MemberRepository repo;
	
	public Member create(Member member){
		return repo.save(member);
	}
	
	public List<Member> getAll(){
		return repo.findAll();
	}
	
	public Member getMember(String memberId){
		return repo.findByMemberId(memberId);
	}
	
	public Member getMemberDependent(String memberId){
		return repo.findByMemberDependentId(memberId);
	}
	
	public Member update(Member member){
		Member m = repo.findByMemberId(member.getMemberId());
		m.setName(member.getName());
		m.setAddress(member.getAddress());
		m.setCountry(member.getCountry());
		m.setState(member.getState());
		m.setEmail(member.getEmail());
		m.setPan(member.getPan());
		m.setContactNum(member.getContactNum());
		m.setDob(member.getDob());
		m.setRegDate(member.getRegDate());
		m.setAge(member.getAge());
		return repo.save(m);
		
	}

}
