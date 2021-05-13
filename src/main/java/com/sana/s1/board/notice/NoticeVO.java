package com.sana.s1.board.notice;

import java.util.List;

import com.sana.s1.board.BoardFileVO;
import com.sana.s1.board.BoardVO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO extends BoardVO {
	private List<BoardFileVO> files;
}
