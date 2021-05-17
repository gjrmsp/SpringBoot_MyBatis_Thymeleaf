package com.sana.s1.board.qna;

import org.apache.ibatis.annotations.Mapper;

import com.sana.s1.board.BoardMapper;
import com.sana.s1.board.BoardVO;

@Mapper
public interface QnaMapper extends BoardMapper {

	public int setReplyInsert(BoardVO boardVO) throws Exception;

	public int setReplyUpdate(BoardVO boardVO) throws Exception;

	public int setRefUpdate(BoardVO boardVO) throws Exception;

}
