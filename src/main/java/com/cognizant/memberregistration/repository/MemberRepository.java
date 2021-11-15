package com.cognizant.memberregistration.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.memberregistration.model.Member;

@Repository
public interface MemberRepository extends MongoRepository<Member, String> {
	
	public Member findByMemberId(String memberId);
	
	@Query (value = "{'dependent.memberId' : ?0 }")
	public Member findByMemberDependentId(String memberId);

}
