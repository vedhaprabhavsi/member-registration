package com.cognizant.memberregistration;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cognizant.memberregistration.controller.MemberController;
import com.cognizant.memberregistration.model.Member;
import com.cognizant.memberregistration.repository.MemberRepository;
import com.cognizant.memberregistration.service.MemberService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRegistrationApplicationTests {
	
	@MockBean
	private MemberRepository repo;
	
	@Autowired
	private MemberService service;
	
	@Autowired
	ApplicationContext ac;
	
	Member mem;
	Member mem1;
	
	@Test
	public void contextLoads(){
		MemberService m = ac.getBean(MemberService.class);
		assertTrue(m instanceof MemberService);
		
		MemberController ctrl = ac.getBean(MemberController.class);
		assertNotNull(ctrl);
	}
	
	@BeforeEach
    public void setup() throws Exception{
        MockitoAnnotations.initMocks(this);
		
		String dDate="11-04-2000"; 
		DateFormat df = new SimpleDateFormat("dd-MM-yyy");
		Date bDate = df.parse(dDate);
		
		String cDate="09-11-2021"; 
		Date rDate = df.parse(cDate);
		
		mem = new Member();
		mem.setName("Vignesh C");
		mem.setAddress("9th Cross street");
		mem.setCountry("USA");
		mem.setState("California");
		mem.setEmail("vignesh.c@gmail.com");
		mem.setPan("VIG97531086C");
		mem.setContactNum(9876543210L);
		mem.setDob(bDate);
		mem.setRegDate(rDate);
		mem.setAge(21);		
		
		mem1 = new Member();
		mem1.setName("Suriya M");
		mem1.setAddress("10th Cross street");
		mem1.setCountry("India");
		mem1.setState("Tamil Nadu");
		mem1.setEmail("suriya.@gmail.com");
		mem1.setPan("SUR97531086M");
		mem1.setContactNum(9876543211L);
		mem1.setDob(bDate);
		mem1.setRegDate(rDate);
		mem1.setAge(21);
    }

	@Test
	public void testGetMembers() {
		when(repo.findAll()).thenReturn(Stream.of(mem, mem1).collect(Collectors.toList()));
		assertEquals(2, service.getAll().size());
	}
	
	@Test
	public void testGetMember(){
		String memberId = "R-123";
		when(repo.findByMemberId(memberId)).thenReturn(mem);
		assertEquals(mem, service.getMember(memberId));
	}
	
	
	@Test
	public void registerMember() throws ParseException{
		when(repo.save(mem)).thenReturn(mem);
		assertEquals(mem, service.create(mem));
	}
	
/*	@Test
	public void updateMember() throws ParseException{
		String dDate="11-04-2000"; 
		DateFormat df = new SimpleDateFormat("dd-MM-yyy");
		Date bDate = df.parse(dDate);
		
		String cDate="09-11-2021"; 
		Date rDate = df.parse(cDate);
		
		Member m = new Member();
		m.setMemberId("R-127");
		m.setName("Sai Pawan");
		m.setAddress("200/7, Abc Street, Xyz");
		m.setCountry("USA");
		m.setState("Kansas City");
		m.setEmail("sai.pawan@cognizant.com");
		m.setPan("ASDF87654321");
		m.setContactNum(6804213579L);
		m.setDob(bDate);
		m.setRegDate(rDate);
		m.setAge(50);
		when(repo.save(m)).thenReturn(m);
		assertEquals(m, service.update(m));
	}		
*/
}