package com.cognizant.memberregistration.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.BDDMockito.given;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cognizant.memberregistration.model.Member;
import com.cognizant.memberregistration.repository.MemberRepository;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTests {
	@Mock
    private MemberRepository repo;

    @InjectMocks
    private MemberService service;
    
//    @Test
//    public void testCreateMember() throws ParseException{
//    	final Member m = new Member();    	
//    	String dDate="11-04-2000"; 
//		DateFormat df = new SimpleDateFormat("dd-MM-yyy");
//		Date bDate = df.parse(dDate);
//		
//		String cDate="09-11-2021"; 
//		Date rDate = df.parse(cDate);
//		
//		m.setName("Vignesh C");m.setAddress("9th Cross street");m.setCountry("USA");
//		m.setState("California");m.setEmail("vignesh.c@gmail.com");m.setPan("VIG97531086C");
//		m.setContactNum(9876543210L);m.setDob(bDate);m.setRegDate(rDate);m.setAge(21);	
//		
//		given(repo.findByMemberId(m.getMemberId())).willReturn(Optional.empty());
//		given(repo.save(m)).willAnswer(invocation -> invocation.getArgument(0));
//		
//		Member savedMember = service.create(m);
//		assertThat(savedMember).isNotNull();
//		verify(repo).save(any(Member.class));
//    }
}
