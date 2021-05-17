package com.sana.s1.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

	public int setJoin(MemberVO memberVO) throws Exception;

	public int setJoinFile(MemberFileVO memberFileVO) throws Exception;

	public MemberVO getLogin(MemberVO memberVO) throws Exception;
	
}
