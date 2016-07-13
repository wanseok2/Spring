package com.wan.app.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wan.app.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	private static final String NAMESPACE = "com.wan.mappers.memberMapper";
	@Override
	public String getTime() {
		return sqlSession.selectOne(NAMESPACE + ".getTime");
	}

	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert("insertMember", vo);
	}

}
