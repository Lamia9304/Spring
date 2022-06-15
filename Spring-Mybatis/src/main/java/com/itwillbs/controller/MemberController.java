package com.itwillbs.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberDTO;
import com.itwillbs.service.MemberService;

@Controller
public class MemberController {

	
	//MemberService memberService= new MemberServiceImpl() 객체 생성
	@Inject
	private MemberService memberService;
	
	@RequestMapping(value="/member/insert", method=RequestMethod.GET)
	public String insert() {
		// WEB-INF/views/member/insertForm.jsp
		return "member/insertForm";
	}
	
	@RequestMapping(value="/member/insertPro", method=RequestMethod.POST)
	public String insertPro(MemberDTO memberDTO) {
		// 회원가입 메서드호출
		memberService.insertMember(memberDTO);
		
		
		return "redirect:/member/login";
		
	}
	
}
