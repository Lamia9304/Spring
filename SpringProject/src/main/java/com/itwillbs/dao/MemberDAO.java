package com.itwillbs.dao;

import com.itwillbs.domain.MemberDTO;

public interface MemberDAO {


	public void insertMember(MemberDTO memberDTO);
	
	public MemberDTO userCheck(MemberDTO memberDTO);
	
}
