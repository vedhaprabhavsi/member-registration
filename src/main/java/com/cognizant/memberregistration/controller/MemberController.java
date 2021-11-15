package com.cognizant.memberregistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.memberregistration.model.Dependent;
import com.cognizant.memberregistration.model.Member;
import com.cognizant.memberregistration.service.MemberSequenceGenerator;
import com.cognizant.memberregistration.service.MemberService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/members")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@Autowired
	private MemberSequenceGenerator seqService;
	
	@RequestMapping("/register")
	@ApiOperation(value = "Register a Member", notes = "Header is not required", response = List.class)
	public Member register(@RequestBody Member member) {
		member.setMemberId("R-"+seqService.getSequenceNumber(Member.SEQUENCE_NAME));
		List<Dependent> li = member.getDependent();
		if(!li.isEmpty()){			
			for(Dependent d: li){
				d.setMemberId("R-"+seqService.getSequenceNumber(Member.SEQUENCE_NAME));
			}
		}		
		return service.create(member);	
	}
	
	@RequestMapping("/getMember/{id}")
	@ApiOperation(value = "Get Member", notes = "Header is not required", response = List.class)
	public Member getMember(@PathVariable("id") String id){
		System.out.println("GetMember ID is: "+id);
		if(service.getMember(id) != null){
			Member mo = service.getMember(id);
			System.out.println(mo.toString());
			return service.getMember(id);
		}
		else {
			Member mo = service.getMemberDependent(id);
			System.out.println(mo.toString());
			Member m1 = service.getMemberDependent(id);
			Member m = new Member();
			m.setMemberId(m1.getMemberId());
			m.setName(m1.getName());
			m.setDob(m1.getDob());
			return m;
		}
	}
	
	@RequestMapping("/getMembers")
	@ApiOperation(value = "Get Members", notes = "Header is not required", response = List.class)
	public List<Member> getMembers(){
		return service.getAll();
	}
	
	@RequestMapping("/updateMember")
	@ApiOperation(value = "Update a Member", notes = "Header is not required", response = List.class)
	public Member update(@RequestBody Member member){
		Member m = service.update(member);
		return m;
		
	}
}