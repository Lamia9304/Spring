package com.itwillbs.dao;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import com.itwillbs.domain.MemberDTO;

public class MemberDAOImpl implements MemberDAO{
	
//	private SimpleJdbcTemplate simpleJdbcTemplate=new SimpleJdbcTemplate(dataSource);
	private SimpleJdbcTemplate simpleJdbcTemplate;

	@Inject
	public void setDataSource(DataSource dataSource) {
		simpleJdbcTemplate=new SimpleJdbcTemplate(dataSource);
	}

	String insertMember="insert into member(id,pass,name,date) values(?,?,?,?)";
	@Override
	public void insertMember(MemberDTO memberDTO) {
		System.out.println("MemberDAOImpl insertMember()");
		// 디비작업
		simpleJdbcTemplate.update(insertMember, memberDTO.getId(),memberDTO.getPass(),memberDTO.getName(),memberDTO.getDate());
	}
}
