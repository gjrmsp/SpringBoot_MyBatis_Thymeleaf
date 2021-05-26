package com.sana.s1.member;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

	public int setJoin(MemberVO memberVO) throws Exception;
	
	public int setMemberRole(Map<String, String> map) throws Exception;

	public int setJoinFile(MemberFileVO memberFileVO) throws Exception;

	public MemberVO getLogin(MemberVO memberVO);
	
	public MemberVO getUsername(MemberVO memberVO) throws Exception;

}
