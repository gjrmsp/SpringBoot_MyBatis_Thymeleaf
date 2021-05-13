package com.sana.s1.board.notice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sana.s1.board.BoardVO;

@SpringBootTest
class NoticeMapperTest {

	@Autowired
	private NoticeMapper noticeMapper;
	
	@Test
	void setInsertTest() throws Exception {
		
		for(int i=0;i<100;i++) {
			BoardVO boardVO = new BoardVO();
			boardVO.setTitle("title"+i);
			boardVO.setContents("contents"+i);
			boardVO.setWriter("writer"+i);
			noticeMapper.setInsert(boardVO);
		}

		System.out.println("Finish");
	}
	
	@Test
	void getListTest() throws Exception {
		List<BoardVO> ar = noticeMapper.getList(null);
		
		for(BoardVO boardVO:ar) {
			System.out.println(boardVO.toString());
		}
		
		assertNotEquals(0, ar.size());
	}

}
