package com.itwillbs.dao;

import com.itwillbs.domain.MemberDTO;
import java.util.List;

public interface MemberDAO {

	public void insertMember(MemberDTO memberDTO);
	public MemberDTO userCheck(MemberDTO memberDTO);
	public MemberDTO getMember(String id);
	public void updateMember(MemberDTO memberDTO);
	public List <MemberDTO> getMemberList();
	

}
