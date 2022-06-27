package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.MemberDTO;

public interface MemberService {

	public void insertMember(MemberDTO memberDTO);
	
	public MemberDTO userCheck(MemberDTO memberDTO);
	
	public MemberDTO getMember(String id);
	
	public void updateMember(MemberDTO memberDTO);
	
	public List<MemberDTO> getMemberList();

}
