package com.wan.app.persistence;

import com.wan.app.domain.MemberVO;

public interface MemberDAO {

	public String getTime();
	public void insertMember(MemberVO vo);
	
}
