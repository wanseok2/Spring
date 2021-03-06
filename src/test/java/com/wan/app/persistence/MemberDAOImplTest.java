package com.wan.app.persistence;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wan.app.domain.MemberVO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDAOImplTest {
	@Inject
	private MemberDAO dao;
	
	@Ignore @Test
	public void testGetTime() {
		System.out.println("getTime()��� : " + dao.getTime());
	}

	@Ignore @Test
	public void testInsertMember() {
		MemberVO vo = new MemberVO();
		vo.setEmail("aaa@aaa");
		vo.setUserid("bbb");
		vo.setUsername("wan");
		vo.setUserpw("1111");
		
		dao.insertMember(vo);
	}

	@Ignore @Test
	public void testReadMember() throws Exception {
		System.out.println(dao.readMember("bbb"));
		
	}
	
	@Test
	public void testReadWithPW() throws Exception {
	
		System.out.println(dao.readWithPW("bbb", "1111"));
	}
	
}
