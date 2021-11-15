package com.cognizant.memberregistration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.cognizant.memberregistration.model.MemberDbSequence;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import java.util.Objects;

@Service
public class MemberSequenceGenerator {
	
	@Autowired
	private MongoOperations op;
	
	public int getSequenceNumber(String seqName){
		Query query = new Query(Criteria.where("id").is(seqName));
		Update update = new Update().inc("seq", 1);
		MemberDbSequence counter = op.findAndModify(query, update, options().returnNew(true).upsert(true),MemberDbSequence.class);
		return !Objects.isNull(counter) ? counter.getSeq() : 101;
	}
}
