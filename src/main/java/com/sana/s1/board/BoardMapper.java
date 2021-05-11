package com.sana.s1.board;

import java.util.List;

public interface BoardMapper {
	
	//List
	public List<BoardVO> getList() throws Exception;
	//count
	public Long getTotalCount() throws Exception;
	//Select
	public BoardVO getSelect(BoardVO boardVO) throws Exception;
	//Insert
	public int setInsert(BoardVO boardVO) throws Exception;
	//Update
	public int setUpdate(BoardVO boardVO) throws Exception;
	//HitUpdate
	public int setHitUpdate(BoardVO boardVO) throws Exception;
	//Delete
	public int setDelete(BoardVO boardVO) throws Exception;
	
}
