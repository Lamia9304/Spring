package com.itwillbs.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberDTO;
import com.itwillbs.service.MemberService;

@Controller
public class MemberController {
	//객체생성
	@Inject
	private MemberService memberService;

	@RequestMapping(value = "/member/insert", method = RequestMethod.GET)
	public String insert() {
		
		// /WEB-INF/views/member/join.jsp
		return "member/join";
	}
	
	@RequestMapping(value = "/member/insertPro", method = RequestMethod.POST)
	public String insertPro(MemberDTO memberDTO) {
		//디비 insertMember() 메서드호출
		
		memberService.insertMember(memberDTO);
		
		return "redirect:/member/login";
	}
	
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String login() {
		
		// /WEB-INF/views/member/login.jsp
		return "member/login";
	}
	
	@RequestMapping(value = "/member/loginPro", method = RequestMethod.POST)
	public String loginPro(MemberDTO memberDTO,HttpSession session) {
		
		MemberDTO memberDTO2=memberService.userCheck(memberDTO);
		
		if(memberDTO2!=null) {
			//아이디 비밀번호 일치 
			//세션값 생성 "id",id
			session.setAttribute("id", memberDTO.getId());
			return "redirect:/main/main";
		}else {
			//아이디 비밀번호 틀림 뒤로이동
			return "member/msg"; 
		}
	}
	
	@RequestMapping(value = "/main/main", method = RequestMethod.GET)
	public String main() {
		
		// /WEB-INF/views/main/main.jsp
		return "main/main";
	}
	
	@RequestMapping(value = "/member/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/main/main";
	}
	
	@RequestMapping(value = "/member/update", method = RequestMethod.GET)
	public String update(HttpSession session,Model model) {
		String id=(String)session.getAttribute("id");
		
		MemberDTO memberDTO=memberService.getMember(id);
		
		
		model.addAttribute("memberDTO", memberDTO);
		
		// /WEB-INF/views/member/update.jsp
		return "member/update";
	}
	
	@RequestMapping(value = "/member/updatePro", method = RequestMethod.POST)
	public String updatePro(MemberDTO memberDTO) {
		
		MemberDTO memberDTO2=memberService.userCheck(memberDTO);
		
		if(memberDTO2!=null) {
			//아이디 비밀번호 일치 
			//수정
			memberService.updateMember(memberDTO);
			return "redirect:/main/main";
		}else {
			//아이디 비밀번호 틀림 뒤로이동
			return "member/msg"; 
		}
	}
	
	@RequestMapping(value = "/member/list", method = RequestMethod.GET)
	public String list() {
		
		// /WEB-INF/views/member/list.jsp
		return "member/list";
	}
	
	@RequestMapping(value = "/test/test1", method = RequestMethod.GET)
	public String test1() {
		
		// /WEB-INF/views/member/list.jsp
		return "test/test1";
	}
	
	@RequestMapping(value = "/test/test2", method = RequestMethod.GET)
	public String test2() {
		
		// /WEB-INF/views/member/list.jsp
		return "test/test2";
	}
	
	
	
}
