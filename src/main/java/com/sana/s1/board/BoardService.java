package com.sana.s1.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sana.s1.util.Pager;

public interface BoardService {
	
	//List
	public List<BoardVO> getList(Pager pager) throws Exception;
	//Select
	public BoardVO getSelect(BoardVO boardVO) throws Exception;
	//Insert
	public int setInsert(BoardVO boardVO, MultipartFile [] files) throws Exception;
	//Update
	public int setUpdate(BoardVO boardVO) throws Exception;
	//Delete
	public int setDelete(BoardVO boardVO) throws Exception;
	
}
