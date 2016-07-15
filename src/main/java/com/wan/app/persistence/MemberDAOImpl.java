package com.wan.app.persistence;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wan.app.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	private static final String NAMESPACE = "com.wan.mappers.boardMapper";
	@Override
	public String getTime() {
		return sqlSession.selectOne(NAMESPACE + ".getTime");
	}

	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert("insertMember", vo);
	}

	@Override
	public MemberVO readMember(String userid) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+".readMember",userid);
	}

	@Override
	public MemberVO readWithPW(String userid, String userpw) throws Exception {
		Map<String,Object> paramMap = new HashMap<String , Object>();
		paramMap.put("userid",userid);
		paramMap.put("userpw",userpw);
		MemberVO vo =  sqlSession.selectOne(NAMESPACE+".readWithPW",paramMap);
		
		if(vo==null){
			throw new Exception();
		}
		return vo;
	}
	
	

}
